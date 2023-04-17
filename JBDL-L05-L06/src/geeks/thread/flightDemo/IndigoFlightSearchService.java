package geeks.thread.flightDemo;

import java.util.ArrayList;
import java.util.List;

public class IndigoFlightSearchService implements AirlineFlightSearchInterface{
    @Override
    public List<FlightData> getFlightBySrcDest(String src, String dest) {
        List<FlightData> list = new ArrayList<>();
        list.add(new FlightData("Lucknow", "Delhi" ,11000));
        list.add(new FlightData("Lucknow", "Delhi" ,12000));
        list.add(new FlightData("Lucknow", "Delhi" ,13000));
        return list;
    }
}
