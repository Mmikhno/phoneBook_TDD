import java.util.HashSet;
import java.util.Set;

public class PhoneBook {
    Set<PhoneNumber> phoneBook = new HashSet<>();

    public int add(String name, String lastName, String number) {
        PhoneNumber phoneNumber = PhoneNumber.newNumber(name, lastName, number);
        if (phoneBook.contains(phoneNumber)) {
            System.out.println(name + " " + lastName + " is already exists in the phone book");
        }
        phoneBook.add(phoneNumber);
        return phoneBook.size();
    }

    public String findByNumber(String number) {
        return null;
    }

}
