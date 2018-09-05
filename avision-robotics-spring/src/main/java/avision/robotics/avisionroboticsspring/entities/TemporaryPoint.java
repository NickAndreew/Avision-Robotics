package avision.robotics.avisionroboticsspring.entities;

public class TemporaryPoint {

    private double latitude;
    private double longitude;
    private double altitude;
    private double speed;
    private double directionDegree;

    public TemporaryPoint(){
        super();
    }

    public TemporaryPoint(double latitude, double longitude, double altitude, double speed, double directionDegree) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.speed = speed;
        this.directionDegree = directionDegree;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirectionDegree() {
        return directionDegree;
    }

    public void setDirectionDegree(double directionDegree) {
        this.directionDegree = directionDegree;
    }

    @Override
    public String toString() {
        return "TemporaryPoint{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", speed=" + speed +
                ", directionDegree=" + directionDegree +
                '}';
    }
}
