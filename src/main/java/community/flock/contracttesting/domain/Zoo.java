package community.flock.contracttesting.domain;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class Zoo {

    private @NonNull String id;
    private @NonNull Address address;
    private List<Mammal> mammals = new ArrayList<>();

}
