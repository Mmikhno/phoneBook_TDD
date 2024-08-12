import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    public void shouldFindNameByNumber() {
        phoneBook.add("Test", "Testov", "+12345698741");
        phoneBook.add("User", "Userov", "+79876543210");
        phoneBook.add("Person", "Unknown", "+71234567890");
        String expected = "User Userov";
        String actual = phoneBook.findByNumber("+79876543210");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindNameByEmptyNumber() {
        phoneBook.add("Test", "Testov", "+12345698741");
        phoneBook.add("User", "Userov", "+79876543210");
        phoneBook.add("Person", "Unknown", "+71234567890");
        String expected = "";
        String actual = phoneBook.findByNumber("+147");
        assertEquals(expected, actual);
    }
}
