package avision.robotics.avisionroboticsspring.entities;


import java.util.List;

public class Flight {

    private Long flightNumber;
    private List<WayPoint> targetRoute;
    private List<TemporaryPoint> passedPoints;

    public Flight(){
        super();
    }

    public Flight(Long flightNumber, List<WayPoint> targetRoute, List<TemporaryPoint> passedPoints) {
        this.flightNumber = flightNumber;
        this.targetRoute = targetRoute;
        this.passedPoints = passedPoints;
    }

    public Long getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Long flightNumber) {
        this.flightNumber = flightNumber;
    }

    public List<WayPoint> getTargetRoute() {
        return targetRoute;
    }

    public void setTargetRoute(List<WayPoint> targetRoute) {
        this.targetRoute = targetRoute;
    }

    public List<TemporaryPoint> getPassedPoints() {
        return passedPoints;
    }

    public void setPassedPoints(List<TemporaryPoint> passedPoints) {
        this.passedPoints = passedPoints;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber=" + flightNumber +
                ", targetRoute=" + targetRoute +
                ", passedPoints=" + passedPoints +
                '}';
    }
}
