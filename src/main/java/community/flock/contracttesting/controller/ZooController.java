package community.flock.contracttesting.controller;

import community.flock.contracttesting.domain.Zoo;
import community.flock.contracttesting.service.ZooService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/zoo")
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
