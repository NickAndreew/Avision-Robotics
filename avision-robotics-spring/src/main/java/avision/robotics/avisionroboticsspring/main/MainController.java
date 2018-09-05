package avision.robotics.avisionroboticsspring.main;


import avision.robotics.avisionroboticsspring.entities.Airplane;
import avision.robotics.avisionroboticsspring.repositories.AirplaneRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/airplanes")
public class MainController {

    private AirplaneRepository airplaneRepository;

    public MainController(AirplaneRepository airplaneRepository){
        this.airplaneRepository = airplaneRepository;
    }

    @CrossOrigin("*")
    @GetMapping("/all")
    public List<Airplane> getAll(){
        List<Airplane> airplanes = this.airplaneRepository.findAll();

        return airplanes;
    }

    @CrossOrigin("*")
    @PutMapping
    public void insert(@RequestBody Airplane airplane){
        this.airplaneRepository.insert(airplane);
    }

    @CrossOrigin("*")
    @PostMapping
    public void update(@RequestBody Airplane airplane){
        this.airplaneRepository.save(airplane);
    }

    @CrossOrigin("*")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.airplaneRepository.deleteById(id);
    }
}
