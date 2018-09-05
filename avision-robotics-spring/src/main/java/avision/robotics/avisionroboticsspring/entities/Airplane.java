package avision.robotics.avisionroboticsspring.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "airplanes")
public class Airplane {

    @Id
    private String mongoId;
    private Long id;
    private AirplaneCharacteristics airplaneCharacteristics;
    private TemporaryPoint position;
    private Flight flight;

    public Airplane() {
        super();
    }

    public Airplane(Long id, AirplaneCharacteristics airplaneCharacteristics, TemporaryPoint position, Flight flight) {
        this.id = id;
        this.airplaneCharacteristics = airplaneCharacteristics;
        this.position = position;
        this.flight = flight;
    }

    public String getMongoId() {
        return mongoId;
    }

    public void setMongoId(String mongoId) {
        this.mongoId = mongoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AirplaneCharacteristics getAirplaneCharacteristics() {
        return airplaneCharacteristics;
    }

    public void setAirplaneCharacteristics(AirplaneCharacteristics airplaneCharacteristics) {
        this.airplaneCharacteristics = airplaneCharacteristics;
    }

    public TemporaryPoint getPosition() {
        return position;
    }

    public void setPosition(TemporaryPoint position) {
        this.position = position;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "mongoId='" + mongoId + '\'' +
                ", id=" + id +
                ", airplaneCharacteristics=" + airplaneCharacteristics +
                ", position=" + position +
                ", flight=" + flight +
                '}';
    }
}
