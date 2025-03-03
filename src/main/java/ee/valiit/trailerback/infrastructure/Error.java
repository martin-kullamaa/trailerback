package ee.valiit.trailerback.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Wrong username or password", 111),
    ACCOUNT_DEACTIVATED("Account deactivated", 222),


    PRIMARY_KEY_NOT_FOUND("Primary key not found", 888),
    FOREIGN_KEY_NOT_FOUND("Secondary key not found", 999);

    private final String message;
    private final int errorCode;
}
