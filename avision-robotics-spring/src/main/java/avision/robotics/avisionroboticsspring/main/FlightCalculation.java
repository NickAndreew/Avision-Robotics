package avision.robotics.avisionroboticsspring.main;

import avision.robotics.avisionroboticsspring.entities.*;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class FlightCalculation {

    private Airplane airplane;
    private List<TemporaryPoint> flightEstimatedPointsList  = new ArrayList<TemporaryPoint>();
    private List<WayPoint> routePointsList  = new ArrayList<WayPoint>();

    public FlightCalculation(){
        super();
    }

    private FlightCalculation (Airplane airplane, List<WayPoint> routePointsList){
        this.airplane = airplane;
        this.routePointsList = routePointsList;
    }

    public static void main(String[] args) {
        FlightCalculation flightCalculation = new FlightCalculation();

        flightCalculation.test();
    }

    private void test(){
        // TESTING THE CLASS FUNCTIONS

        // Create Airplane
        Airplane airplane;

        // Create properies for airplane
        AirplaneCharacteristics airplaneCharacteristics = new AirplaneCharacteristics(
                15.0,
                2.5,
                1.0,
                5.0
        );

        List<TemporaryPoint> passedRoute = new ArrayList<TemporaryPoint>();

        // Create flight
        Flight flight;

        TemporaryPoint position = new TemporaryPoint(41.3731, 2.1552, 0, 0, 0);

        // Create route for the flight
        WayPoint wayPoint1 = new WayPoint(41.3831, 2.1552, 400.0, 13.0 );

        WayPoint wayPoint2 = new WayPoint(41.4034, 2.1823, 388.0, 13.0 );
        WayPoint wayPoint3 = new WayPoint(41.4135, 2.2253, 221.0, 14.0 );
        WayPoint wayPoint4 = new WayPoint(41.3602, 2.1754, 0, 0 );

        getRoutePointsList().add(wayPoint1);
        getRoutePointsList().add(wayPoint2);
        getRoutePointsList().add(wayPoint3);
        getRoutePointsList().add(wayPoint4);


        // Initialize flight and airplane
        flight = new Flight((long)1, getRoutePointsList(), passedRoute);
        airplane = new Airplane((long)1, airplaneCharacteristics, position, flight);


        /// SOME CALCULATION TESTS
        getNecessaryTurnDegree(position, wayPoint1);

    }

    public List<TemporaryPoint> calculateRoute(List<WayPoint> targetRoute){

        List<TemporaryPoint> routePointsList  = new ArrayList<TemporaryPoint>();
        routePointsList.add(this.airplane.getPosition());

        for(WayPoint wp: targetRoute){
            achievePoint(wp);
        }

        return routePointsList;
    }

    private void achievePoint(WayPoint wp){
        TemporaryPoint currentPosition = new TemporaryPoint();
        currentPosition = getCurrentPosition();

        // vertical move
        do {
            TemporaryPoint newTP = new TemporaryPoint();

            double altitude;

            if( getCurrentPosition().getAltitude() < wp.getAltitude() ){
                altitude = getCurrentPosition().getAltitude() + this.airplane.getAirplaneCharacteristics().getAltitudeChangeSpeed();
            } else {
                altitude = getCurrentPosition().getAltitude() - this.airplane.getAirplaneCharacteristics().getAltitudeChangeSpeed();
            }

            newTP = getCurrentPosition();
            newTP.setAltitude(altitude);

            getFlightEstimatedPointsList().add(newTP);

        } while(getCurrentPosition().getAltitude() != wp.getAltitude());


        // direction angle move
        boolean dir = true;

        double degreeToTurn = getNecessaryTurnDegree(getCurrentPosition(), wp);

        do {
            TemporaryPoint newTP = new TemporaryPoint();
            newTP = getCurrentPosition();

            if(degreeToTurn!=0){
                dir = false;
            } else {
                // what if the distance of pre-final point will not be on the distance of exactly 1 sec. turn distance;
                if((getCurrentPosition().getDirectionDegree() - getAirplaneDirectionChangeSpeed()) > 0) {
                    degreeToTurn = degreeToTurn - getAirplaneDirectionChangeSpeed();
                }
            }

            getFlightEstimatedPointsList().add(newTP);
        } while (dir);


        // horizontal move
        do {
            TemporaryPoint newTP = new TemporaryPoint();



            newTP = getCurrentPosition();

            getFlightEstimatedPointsList().add(newTP);
        } while (getCurrentPosition().getLongitude()!=wp.getLongitude() && getCurrentPosition().getLatitude()!=wp.getLatitude());
    }


    // CALCULATION METHODS //


    private double getVectorLength(TemporaryPoint tp, WayPoint wp) {
        double vectorLength;
        double tpLat = tp.getLatitude();
        double tpLng = tp.getLongitude();

        double wpLat = wp.getLatitude();
        double wpLng = wp.getLongitude();

        vectorLength = Math.sqrt(Math.pow(2, (wpLat-tpLat)) + Math.pow(2, (wpLng-tpLng)));
        return vectorLength;
    }

    private double getNecessaryTurnDegree (TemporaryPoint tp, WayPoint wp) {
        // [WARNING]: this method is supposed to be called once
        // per every initial calculation of the movements
        // from one "WayPoint" to another (not "TemporaryPoint")

        // Curent position
        double currentX = tp.getLatitude();
        double currentY = tp.getLongitude();

        // Target position
        double targetX = wp.getLatitude();
        double targetY = wp.getLongitude();

        // Get the angle between vectors

        // [WARNING]: this SHOULD work in the following way ...
        // - return 0 if points to the NORTH
        // - should return the angle between TARGET VECTOR and CURRENT VECTOR in degrees°

        // [WARNING]: this is CURRENTLY working as follows: ...  !!! //
        //  - returns the angle in degrees°
        //  - returns 0 if TARGET VECTOR is pointing exactly to the EAST (->)
        //  - returns 180.0 if TARGET VERCTOR is pointing exactly to the WEST (<-);

        double theta = 180.0 / Math.PI * Math.atan2(targetY - currentY, targetX - targetY);
        System.out.println("Degree : " + theta);

        // It's not yet working properly.......................................
        return theta;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public List<TemporaryPoint> getFlightEstimatedPointsList() {
        return flightEstimatedPointsList;
    }

    public void setFlightEstimatedPointsList(List<TemporaryPoint> flightEstimatedPointsList) {
        this.flightEstimatedPointsList = flightEstimatedPointsList;
    }

    public List<WayPoint> getRoutePointsList() {
        return routePointsList;
    }

    public void setRoutePointsList(List<WayPoint> routePointsList) {
        this.routePointsList = routePointsList;
    }

    public TemporaryPoint getCurrentPosition(){
        return this.flightEstimatedPointsList.get(this.flightEstimatedPointsList.size()-1);
    }

    public double getAirplaneDirectionChangeSpeed(){
        return this.airplane.getAirplaneCharacteristics().getDirectionChangeSpeed();
    }

    @Override
    public String toString() {
        return "FlightCalculation{" +
                "airplane=" + airplane +
                ", flightEstimatedPointsList=" + flightEstimatedPointsList +
                ", routePointsList=" + routePointsList +
                '}';
    }
}
