package community.flock.contracttesting;

import community.flock.contracttesting.controller.ZooController;
import community.flock.contracttesting.domain.Address;
import community.flock.contracttesting.domain.Country;
import community.flock.contracttesting.domain.Mammal;
import community.flock.contracttesting.domain.Zoo;
import community.flock.contracttesting.service.MammalService;
import community.flock.contracttesting.service.ZooService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ZooBase {

    @Before
    public void setup() {
        MammalService mammalService =
                new MammalService(Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
        ZooService zooService = new ZooService(mammalService);

        Mammal elephant = new Mammal("1", "Elephant", "Chorda");
        Mammal crocodile = new Mammal("2", "Crocodile", "Reptile");
        Mammal lama = new Mammal("3", "Lama", "Camel");
        List<Mammal> mammalsNl = Arrays.asList(elephant, crocodile);
        List<Mammal> mammalsBe = Collections.singletonList(lama);
        Address addressNl = new Address("Street-1", "1-a", "1000 AB", Country.NL);
        Address addressBe = new Address("Street-2", "2-a", "1001 BC", Country.BE);
        Zoo zooNl = new Zoo("12345", addressNl);
        zooNl.setMammals(mammalsNl);
        Zoo zooBe = new Zoo("23456", addressBe);
        zooBe.setMammals(mammalsBe);

        List<Zoo> zoos = Arrays.asList(zooNl, zooBe);

        RestAssuredMockMvc.standaloneSetup(new ZooController(zooService, zoos));
    }
}
