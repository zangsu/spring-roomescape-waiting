package roomescape.domain;

import static roomescape.exception.ExceptionType.INVALID_PASSWORD;

import jakarta.persistence.Embeddable;
import java.util.Objects;
import roomescape.exception.RoomescapeException;

@Embeddable
public class Password {

    private String value;

    public Password() {
    }

    public Password(String value) {
        validateValue(value);
        this.value = value;
    }

    private void validateValue(String value) {
        if (value == null || value.isBlank()) {
            throw new RoomescapeException(INVALID_PASSWORD);
        }
        if (value.length() < 8) {
            throw new RoomescapeException(INVALID_PASSWORD);
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Password password = (Password) o;
        return Objects.equals(value, password.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Password{" +
                "value='" + value + '\'' +
                '}';
    }
}