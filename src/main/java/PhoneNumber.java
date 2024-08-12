import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    private String name;
    private String lastName;
    private String number;

    private PhoneNumber(String name, String lastName, String number) {
        this.name = name;
        this.number = number;
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    static boolean isItPhoneNumber(String number) {
        //  Pattern pattern = Pattern.compile("\\+[0-9]{1,3}\\([0-9]{1,3}\\)[0-9]{3}\\-[0-9]{4}");
        Pattern pattern = Pattern.compile("\\+*[0-9]{11,18}");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    static PhoneNumber newNumber(String name, String lastName, String number) {
        if (number == null || number == "") {
            throw new IllegalArgumentException("Number cannot be blank");
        }
        if (!isItPhoneNumber(number)) {
            throw new IllegalArgumentException("Number " + number + " is incorrect");
        }
        if (name == null || name == "" || lastName == null || lastName == "") {
            throw new IllegalArgumentException("Name or lastname cannot be blank");
        }
        return new PhoneNumber(name, lastName, number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        PhoneNumber pn = (PhoneNumber) obj;
        return name.equals(pn.name) && lastName.equals(pn.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName);
    }

}
