package community.flock.contracttesting.service;

import community.flock.contracttesting.domain.Mammal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MammalService {

    private List<Mammal> allMammals;
    private List<Mammal> nlMammals;
    private List<Mammal> beMammals;

    public List<Mammal> initializeNL() {
        nlMammals = Collections.singletonList(new Mammal(UUID.randomUUID().toString(), "Lama", "Kameelachtigen"));
        return nlMammals;
    }

    public List<Mammal> initializeBE() {
        beMammals.add(new Mammal(UUID.randomUUID().toString(), "Zwijn", "Varkens"));
        beMammals.add(new Mammal(UUID.randomUUID().toString(), "Olifant", "Chordadieren"));
        return beMammals;
    }

    public List<Mammal> all() {
        if (allMammals.isEmpty()) {
            allMammals.addAll(nlMammals);
            allMammals.addAll(beMammals);
        }
        return allMammals;
    }
}
