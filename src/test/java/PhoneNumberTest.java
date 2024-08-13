import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneNumberTest {
    @Test
    void shouldCreateNewPhoneNumber() {
        PhoneNumber pn = PhoneNumber.newNumber("Test", "Testov", "+71234567890");
        assertTrue(pn.getName().equals("Test") && pn.getLastName().equals("Testov") &&
                pn.getNumber().equals("+71234567890"));
    }

    @ParameterizedTest
    @CsvSource({
            ",User,+12345678901,Name or lastname cannot be blank",
            "Test,,+79219876543, Name or lastname cannot be blank",
            ",,+79111234567, Name or lastname cannot be blank",
            "Test, User,, Number cannot be blank",
            "Test, User, 123456789, Number 123456789 is incorrect"
    })
    void shouldAddIncorrectPhoneNumber(String name, String lastName, String number, String resultMessage) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PhoneNumber pn = PhoneNumber.newNumber(name, lastName, number);
        });
        String expectedMessage = resultMessage;
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.equals(expectedMessage));
    }


}
