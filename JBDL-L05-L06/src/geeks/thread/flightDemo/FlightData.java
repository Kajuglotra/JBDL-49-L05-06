package geeks.thread.flightDemo;

public class FlightData {

    private String source;
    private String destination;

    private int cost;

    public FlightData(String source, String destination, int cost) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "FlightData{" +
                "source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", cost=" + cost +
                '}';
    }
}
