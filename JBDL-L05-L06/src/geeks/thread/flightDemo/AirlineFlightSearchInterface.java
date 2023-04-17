package geeks.thread.flightDemo;

import java.util.List;

public interface AirlineFlightSearchInterface {

    List<FlightData> getFlightBySrcDest(String src, String dest);
}
