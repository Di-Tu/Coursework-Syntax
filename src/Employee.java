import java.util.Objects;

public class Employee {
    private String name;
    private int department;
    private double salary;
    private int id;

    public Employee(String name, int department, double salary) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ошибка ввода имени");
        }
        if (department <= 0 || department > 5) {
            throw new IllegalArgumentException("Ошибка ввода департамента");
        }
        if (salary <= 0) {
            throw new IllegalArgumentException("Ошибка ввода зарплаты");
        }
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.id = Main.counterId;
        Main.counterId = Main.counterId + 1;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Сотрудник: " + name +
                ", отдел: " + department +
                ", зарплата: " + salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(salary, employee.salary) == 0 && id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, department, salary, id);
    }

}

