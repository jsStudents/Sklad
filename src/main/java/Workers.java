import java.io.Serializable;

public class Workers implements Serializable {

    private int id;
    private String name;
    private String position;
    private int salary;

    public Workers(int id, String name, String position, int salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String toString() {
        return """
                ======================================
                Id - %d;
                Name - %s;
                Position - %s;
                Salary - %d
                ======================================""".formatted(this.getId(),
                                                                    this.getName(),
                                                                    this.getPosition(),
                                                                    this.getSalary());
    }
}
