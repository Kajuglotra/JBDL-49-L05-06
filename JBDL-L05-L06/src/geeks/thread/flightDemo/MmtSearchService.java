package geeks.thread.flightDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MmtSearchService {

    List<AirlineFlightSearchInterface> airlineFlightSearchInterfaces;

    private ExecutorService executorService;

    public MmtSearchService(List<AirlineFlightSearchInterface> airlineFlightSearchInterfaces) {
        this.airlineFlightSearchInterfaces = airlineFlightSearchInterfaces;
        this.executorService = Executors.newFixedThreadPool(airlineFlightSearchInterfaces.size());
    }

    public List<FlightData> getAllFlightBySrcDest(String source, String dest) throws ExecutionException, InterruptedException {
        List<Callable<List<FlightData>>> callableList = new ArrayList<>();
        for(AirlineFlightSearchInterface impl: airlineFlightSearchInterfaces){
            callableList.add(new Callable<List<FlightData>>() {
                @Override
                public List<FlightData> call() throws Exception {
                    return impl.getFlightBySrcDest(source, dest);
                }
            });
        }
        List<Future<List<FlightData>>> futureList = new ArrayList<>();
        for(Callable<List<FlightData>> collable : callableList){
            Future<List<FlightData>> flightData = executorService.submit(collable);
            futureList.add(flightData);
        }
        List<FlightData> result = new ArrayList<>();
        for(Future<List<FlightData>> data: futureList){
            result.addAll(data.get());
        }
        return result;
    }


}
//jar war zip-> artifacts
