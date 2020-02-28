package community.flock.contracttesting.service;

import community.flock.contracttesting.domain.Address;
import community.flock.contracttesting.domain.Country;
import community.flock.contracttesting.domain.Zoo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ZooService {

    private MammalService mammalService;

    public List<Zoo> initialize() {
        Address nlAddress = new Address("Plantage Kerklaan", "38-40", "1018 CZ", Country.NL);
        Address beAddress = new Address("Koningin Astridplein", " 20-26", ", 2018", Country.BE);

        Zoo nlZoo = new Zoo(UUID.randomUUID().toString(), nlAddress);
        nlZoo.setMammals(mammalService.initializeNL());

        Zoo beZoo = new Zoo(UUID.randomUUID().toString(), beAddress);
        beZoo.setMammals(mammalService.initializeBE());

        List<Zoo> zoos = new ArrayList<>();
        Collections.addAll(zoos, nlZoo, beZoo);
        return zoos;
    }

}
