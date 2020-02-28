package community.flock.contracttesting.controller;

import community.flock.contracttesting.domain.Mammal;
import community.flock.contracttesting.exception.MammalNotFoundException;
import community.flock.contracttesting.service.MammalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MammalController {

    private MammalService mammalService;

    @RequestMapping("/mammal")
    public List<Mammal> index() {
        return mammalService.all();
    }

    @PutMapping("/mammal/{id}")
    public Mammal update(@PathVariable String id,
                         @RequestBody Mammal inputMammal) throws MammalNotFoundException {
        List<Mammal> allMammals = mammalService.all();
        Mammal foundMammal = allMammals.stream()
                .filter(mammal -> mammal.getId().equals(id))
                .findFirst()
                .orElseThrow(MammalNotFoundException::new);

        foundMammal.setName(inputMammal.getName());
        foundMammal.setSpecies(inputMammal.getSpecies());
        return foundMammal;
    }
}
