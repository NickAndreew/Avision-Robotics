package avision.robotics.avisionroboticsspring;

import avision.robotics.avisionroboticsspring.entities.*;
import avision.robotics.avisionroboticsspring.repositories.AirplaneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {

    private AirplaneRepository airplaneRepository;

    public DBSeeder (AirplaneRepository airplaneRepository){
        this.airplaneRepository = airplaneRepository;
    }

    public void run(String... strings) throws Exception {
        AirplaneCharacteristics airplaneCharacteristics1 = new AirplaneCharacteristics(
                16.6667,
                2.5,
                1.2,
                1.3
        );

        List<WayPoint> route = new ArrayList<WayPoint>();

        WayPoint wayPoint1 = new WayPoint(41.3851, 2.1734, 400.0, 13.1234 );
        WayPoint wayPoint2 = new WayPoint(41.4034, 2.1823, 388.0, 13.4321 );
        WayPoint wayPoint3 = new WayPoint(41.4135, 2.2253, 221.0, 14.0011 );
        WayPoint wayPoint4 = new WayPoint(41.3602, 2.1754, 0, 0 );

        route.add(wayPoint1);
        route.add(wayPoint2);
        route.add(wayPoint3);
        route.add(wayPoint4);

        List<TemporaryPoint> passedRoute = new ArrayList<TemporaryPoint>();

        Flight flight = new Flight((long)1, route, passedRoute);

        TemporaryPoint position = new TemporaryPoint(41.3631, 2.1652, 0, 0, 0);

        Airplane airplane = new Airplane((long)1,airplaneCharacteristics1, position, flight);

        airplaneRepository.deleteAll();

        airplaneRepository.save(airplane);
    }
}
