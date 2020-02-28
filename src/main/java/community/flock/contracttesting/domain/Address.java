package community.flock.contracttesting.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Address {

    private @NonNull String streetName;
    private @NonNull String houseNumber;
    private @NonNull String zipCode;
    private @NonNull Country country;

}
