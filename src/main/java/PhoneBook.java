import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

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
        if (number.trim() == "") {
            throw new IllegalArgumentException("Please specify phone number");
        }
        Optional<PhoneNumber> phoneNumber = Stream.ofNullable(phoneBook)
                .flatMap(Collection::stream)
                .filter(item -> item.getNumber().equals(number))
                .findFirst();
        if (!phoneNumber.isPresent()) {
            System.out.println("Number not found");
            return "";
        }
        return phoneNumber.get().getName() + " " + phoneNumber.get().getLastName();
    }

    public String findByName(String name, String lastName) {
        if (name.trim() == "" || lastName.trim() == "") {
            throw new IllegalArgumentException("Please specify full name");
        }
        Optional<PhoneNumber> phoneNumber = Stream.ofNullable(phoneBook)
                .flatMap(Collection::stream)
                .filter(item -> item.getName().equals(name) && item.getLastName().equals(lastName))
                .findFirst();
        if (!phoneNumber.isPresent()) {
            System.out.println("Name not found");
            return "";
        }
        return phoneNumber.get().getNumber();
    }

    public void printAllNames() {

    }

}
