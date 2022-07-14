import java.io.Serializable;

public class Workers implements Serializable {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String position;
    private int salary;

    public Workers(String firstName, String lastName, String phoneNumber, String position, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.salary = salary;
    }


    public String toString() {
        return """
                ======================================
                First name - %s;
                Last name - %s;
                Phone - %s;
                Position - %s;
                """.formatted(this.getFirstName(),
                this.getLastName(),
                this.getPhoneNumber(),
                this.getPosition());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
