import java.util.Arrays;
import java.util.Objects;

public class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook(Employee[] employees) {
        this.employees = employees;
    }

    //    Сложно Задача 4.a
    public boolean newEmployeeIntroduction(Employee employee) {
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getId() == 0) {
                this.employees[i] = employee;
                System.out.println("Сотрудник добавлен");
                return true;
            }
        }
        System.out.println("Сотрудник не добавлен, нет свободных мест.");
        return false;
    }

    //    Сложно Задача 4.b
    public boolean employeeRemoval(int id) {
        int sign = searchById(id);
        if (sign != -1) {
            this.employees[sign].setName("");
            this.employees[sign].setDepartment(0);
            this.employees[sign].setSalary(0);
            this.employees[sign].setId(0);
            System.out.println("Сотрудник удален");
            return true;
        }
        return false;
    }

    //    Сложно Задача 5
    public int searchById(int id) {
        int sign = -1;
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getId() == id) {
                return sign = i;
            }
        }
        System.out.println("Нет сотрудника с таким ID");
        return sign;
    }


    //            Задача 3.b
    public void employeesMore(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Введите положительное число");
        }
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getSalary() > number && this.employees[i].getSalary() != 0) {
                System.out.println("ID: " + this.employees[i].getId()
                        + ", Сотрудник: " + this.employees[i].getName()
                        + ", Зарплата " + this.employees[i].getSalary());
            }
        }
    }

    //            Задача 3.a
    public void employeesLess(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Введите положительное число");
        }
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getSalary() < number && this.employees[i].getSalary() != 0) {
                System.out.println("ID: " + this.employees[i].getId()
                        + ", Сотрудник: " + this.employees[i].getName()
                        + ", Зарплата " + this.employees[i].getSalary());
            }
        }
    }

    //            Задача 2.f
    public void printEmployeesDepartment(int department) {
        if (department <= 0 || department > 5) {
            throw new IllegalArgumentException("Ошибка ввода номера отдела");
        }
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getDepartment() == department) {
                System.out.println("ID: " + this.employees[i].getId()
                        + ", Сотрудник: " + this.employees[i].getName()
                        + ", Зарплата " + this.employees[i].getSalary());
            }
        }
    }

    //            Задача 2.e
    public void wageIndexationDepartment(int department, double index) {
        if (department <= 0 || department > 5) {
            throw new IllegalArgumentException("Ошибка ввода номера отдела");
        }
        if (index <= 0) {
            throw new IllegalArgumentException("Ошибка ввода процента индексации. Введите положительное число.");
        }
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getName() == null || this.employees[i].getName().isEmpty()) {

            } else if (this.employees[i].getDepartment() == department) {
                this.employees[i].setSalary((double) ((int) ((this.employees[i].getSalary() * (1 + index / 100)) * 100)) / 100);
            }
        }
    }

    //            Задача 2.d
    public double averageDepartmentSalary(int department) {
        if (department <= 0 || department > 5) {
            throw new IllegalArgumentException("Ошибка ввода номера отдела");
        }
        int counter = 0;
        double sum = 0;
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getDepartment() == department) {
                sum = sum + this.employees[i].getSalary();
                counter++;
            }
        }
        return (double) ((int) (sum / counter * 100)) / 100;
    }

    //            Задача 2.c
    public double totalExpensesPerDepartment(int department) {
        if (department <= 0 || department > 5) {
            throw new IllegalArgumentException("Ошибка ввода номера отдела");
        }
        double sum = 0;
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getDepartment() == department) {
                sum = sum + this.employees[i].getSalary();
            }
        }
        return sum;
    }

    //            Задача 2.a
    public int minSalaryDepartment(int department) {
        if (department <= 0 || department > 5) {
            throw new IllegalArgumentException("Ошибка ввода номера отдела");
        }
        int label = 0;
        int sign = -1;
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getDepartment() == department
                    && label == 0
                    && this.employees[i].getSalary() != 0) {
                sign = i;
                label = 1;
            }
            if (this.employees[i].getDepartment() == department
                    && this.employees[i].getSalary() < this.employees[sign].getSalary()
                    && this.employees[i].getSalary() != 0) {
                sign = i;
            }
        }
        if (sign == -1) {
            throw new IllegalArgumentException("В отделе нет сотрудников");
        } else return sign;
    }

    //            Задача 2.b
    public int maxSalaryDepartment(int department) {
        if (department <= 0 || department > 5) {
            throw new IllegalArgumentException("Ошибка ввода номера отдела");
        }
        int label = 0;
        int sign = -1;
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getDepartment() == department
                    && label == 0
                    && this.employees[i].getSalary() != 0) {
                sign = i;
                label = 1;
            }
            if (this.employees[i].getDepartment() == department
                    && this.employees[i].getSalary() > this.employees[sign].getSalary()
                    && this.employees[i].getSalary() != 0) {
                sign = i;
            }
        }
        if (sign == -1) {
            throw new IllegalArgumentException("В отделе нет сотрудников");
        } else return sign;
    }

    //        Задача 1
    public void wageIndexation(double index) {
        if (index <= 0) {
            throw new IllegalArgumentException("Ошибка ввода процента индексации. Введите положительное число.");
        }
        int rounding;
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getName() == null || this.employees[i].getName().isEmpty()) {

            } else {
                rounding = (int) ((this.employees[i].getSalary() * (1 + index / 100)) * 100);
                this.employees[i].setSalary((double) rounding / 100);
            }
        }
    }

    public void printNameEmployees() {
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getName() == null || this.employees[i].getName().isEmpty()) {

            } else System.out.println(this.employees[i].getName());
        }
    }

    public int numberOfEmployees() {
        int number = 0;
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getName() == null || this.employees[i].getName().isEmpty()) {

            } else number++;
        }
        return number;
    }

    public int minSalary() {
        double minSalary = this.employees[0].getSalary();
        int sign = 0;
        for (int i = 0; i < this.employees.length; i++) {
            if (minSalary > this.employees[i].getSalary()) {
                minSalary = this.employees[i].getSalary();
                sign = i;
            }
        }
        return sign;
    }

    public int maxSalary() {
        double maxSalary = 0;
        int sign = 0;
        for (int i = 0; i < this.employees.length; i++) {
            if (maxSalary < this.employees[i].getSalary()) {
                maxSalary = this.employees[i].getSalary();
                sign = i;
            }
        }
        return sign;
    }

    public void printEmployees() {
        for (int i = 0; i < this.employees.length; i++) {
            if (this.employees[i].getName() == null || this.employees[i].getName().isEmpty()) {

            } else System.out.println(this.employees[i].toString());
        }
    }

    public double amountOfExpensesPerMonth() {
        double totalSummMonth = 0;
        for (int i = 0; i < this.employees.length; i++) {
            totalSummMonth = totalSummMonth + this.employees[i].getSalary();
        }
        return totalSummMonth;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBook that = (EmployeeBook) o;
        return Objects.deepEquals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(employees);
    }

    @Override
    public String toString() {
        return "EmployeeBook{" +
                "employees=" + Arrays.toString(employees) +
                '}';
    }
}
