package avision.robotics.avisionroboticsspring.entities;

public class AirplaneCharacteristics {

    private double topSpeed;
    private double acceleration;
    private double altitudeChangeSpeed;
    private double directionChangeSpeed;

    public AirplaneCharacteristics(){
        super();
    }

    public AirplaneCharacteristics(double topSpeed, double acceleration, double altitudeChangeSpeed, double directionChangeSpeed) {
        this.topSpeed = topSpeed;
        this.acceleration = acceleration;
        this.altitudeChangeSpeed = altitudeChangeSpeed;
        this.directionChangeSpeed = directionChangeSpeed;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getAltitudeChangeSpeed() {
        return altitudeChangeSpeed;
    }

    public void setAltitudeChangeSpeed(double altitudeChangeSpeed) {
        this.altitudeChangeSpeed = altitudeChangeSpeed;
    }

    public double getDirectionChangeSpeed() {
        return directionChangeSpeed;
    }

    public void setDirectionChangeSpeed(double directionChangeSpeed) {
        this.directionChangeSpeed = directionChangeSpeed;
    }

    @Override
    public String toString() {
        return "AirplaneCharacteristics{" +
                "topSpeed=" + topSpeed +
                ", acceleration=" + acceleration +
                ", altitudeChangeSpeed=" + altitudeChangeSpeed +
                ", directionChangeSpeed=" + directionChangeSpeed +
                '}';
    }
}
