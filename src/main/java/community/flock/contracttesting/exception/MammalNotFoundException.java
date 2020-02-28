package community.flock.contracttesting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Mammal not found")
public class MammalNotFoundException extends Exception {
}
