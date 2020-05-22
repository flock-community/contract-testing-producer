package community.flock.contracttesting.controller;

import community.flock.contracttesting.domain.Address;
import community.flock.contracttesting.domain.Country;
import community.flock.contracttesting.domain.Zoo;
import community.flock.contracttesting.service.ZooService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ZooController {

    private ZooService zooService;
    private List<Zoo> zoos;

    @RequestMapping("/zoo")
    public List<Zoo> index() {
        return zoos;
    }

    @RequestMapping("/zoo/{id}")
    public ResponseEntity<Zoo> get(@PathVariable("id") String id) {
        Zoo zoo = zoos.stream()
                .filter(z -> z.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (zoo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(zoo, HttpStatus.OK);
    }

    @PostMapping("/zoo")
    @ResponseStatus()
    public Zoo save(@RequestBody Zoo zoo) {
        zoos.add(zoo);
        return zoo;
    }

    @GetMapping("/initialize")
    public String initalize() {
        zoos.clear();
        zoos.addAll(zooService.initialize());
        return "Initialize OK...";
    }
}
