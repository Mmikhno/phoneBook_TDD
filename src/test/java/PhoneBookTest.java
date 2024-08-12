import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {
    PhoneBook phoneBook = new PhoneBook();

    @Test
    void shouldAddNewPhoneNumber() {
        phoneBook.add("Ivan", "Ivanov", "+12345698741");
        phoneBook.add("Petr", "Petrov", "+98765432100");
        int actual = phoneBook.add("Vasya", "Pupkin", "+98745632145");
        int expected = 3;
        assertEquals(expected, actual);
    }
}
