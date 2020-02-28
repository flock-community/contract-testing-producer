package community.flock.contracttesting.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Mammal {

    private @NonNull String id;
    private @NonNull String name;
    private @NonNull String species;

}
