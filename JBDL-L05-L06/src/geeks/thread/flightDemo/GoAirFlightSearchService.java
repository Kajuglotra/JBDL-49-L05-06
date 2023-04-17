package geeks.thread.flightDemo;

import java.util.ArrayList;
import java.util.List;

public class GoAirFlightSearchService implements AirlineFlightSearchInterface{
    @Override
    public List<FlightData> getFlightBySrcDest(String src, String dest) {

        // by default, it might be calling api from goAir and get some data
        // we can make a connection to db and get data

        List<FlightData> list = new ArrayList<>();
        list.add(new FlightData("Lucknow", "Delhi" ,10000));
        list.add(new FlightData("Lucknow", "Delhi" ,9000));
        list.add(new FlightData("Lucknow", "Delhi" ,8000));
        return list;
    }
}
