package ee.valiit.trailerback.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    ACTIVE("A"),
    DEACTIVEATED("D");

    private final String code;
}
