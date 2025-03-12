package ee.valiit.trailerback.validation;

import ee.valiit.trailerback.infrastructure.exception.DataNotFoundException;

import java.util.List;

import static ee.valiit.trailerback.infrastructure.Error.*;

public class ValidationService {

    public static DataNotFoundException throwPrimaryKeyNotFoundException(String primaryKeyName, Integer value) {
        return new DataNotFoundException(PRIMARY_KEY_NOT_FOUND.getMessage() + primaryKeyName + " = " + value, PRIMARY_KEY_NOT_FOUND.getErrorCode());
    }

    public static DataNotFoundException throwForeignKeyNotFoundException(String fieldName, Integer value) {
        return new DataNotFoundException(FOREIGN_KEY_NOT_FOUND.getMessage() + fieldName + " = " + value, FOREIGN_KEY_NOT_FOUND.getErrorCode());
    }

}
