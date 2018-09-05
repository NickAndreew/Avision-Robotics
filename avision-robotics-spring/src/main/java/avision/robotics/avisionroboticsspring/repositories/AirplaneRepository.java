package avision.robotics.avisionroboticsspring.repositories;

import avision.robotics.avisionroboticsspring.entities.Airplane;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends MongoRepository<Airplane, String> {

}
