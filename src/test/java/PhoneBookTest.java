import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {
    PhoneBook phoneBook = new PhoneBook();
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        phoneBook.add("Test", "Testov", "+12345698741");
        phoneBook.add("User", "Userov", "+79876543210");
        phoneBook.add("Person", "Unknown", "+71234567890");
    }

    @Test
    void shouldAddNewPhoneNumber() {
        int actual = phoneBook.add("Vasya", "Pupkin", "+98745632145");
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindNameByNumber() {
        String expected = "User Userov";
        String actual = phoneBook.findByNumber("+79876543210");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindNameByNumber() {
        System.setOut(new PrintStream(new PrintStream(output)));
        String expectedMessage = "Number not found";
        String expected = "";
        String actual = phoneBook.findByNumber("+147");
        assertEquals(expected, actual);
        assertEquals(expectedMessage, output.toString());
    }

    @Test
    public void shouldThrowExceptionWhenNumberIsBlank() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.findByNumber("");
        });
        String expectedMessage = "Please specify phone number";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void shouldFindNumberByName() {
        String expected = "+71234567890";
        String actual = phoneBook.findByName("Person", "Unknown");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindNumberByName() {
        System.setOut(new PrintStream(new PrintStream(output)));
        String expectedMessage = "Name not found";
        String expected = "";
        String actual = phoneBook.findByName("Some", "Person");
        assertEquals(expectedMessage, output.toString());
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Person,",
            ",Userov",
            ","
    })
    public void shouldThrowExceptionWhenNameIsBlank(String name, String lastName) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            phoneBook.findByName(name, lastName);
        });
        String expectedMessage = "Please specify full name";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void shouldPrintAllNames() {
        System.setOut(new PrintStream(new PrintStream(output)));
        String expected = "Person Unknown\nTest Testov\nUser Userov\n";
        phoneBook.printAllNames();
        assertEquals(expected, output.toString());
    }

    @AfterEach
    void tearDown() {
        phoneBook.phoneBook.clear();
    }
}
