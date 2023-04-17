package geeks.thread.flightDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MmtApiDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<AirlineFlightSearchInterface> list = new ArrayList<>();
        list.add(new GoAirFlightSearchService());
        list.add(new IndigoFlightSearchService());
        MmtSearchService mmtSearchService = new MmtSearchService(list);
        List<FlightData> data = mmtSearchService.getAllFlightBySrcDest("Lucknow", "Delhi" );
        System.out.println(data);
    }
}
