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
        return false;
    }

    static PhoneNumber newNumber(String name, String lastName, String number) {
        return null;
    }

}
