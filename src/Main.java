
public class Main {
    public static int counterId = 34000001;

    public static void main(String[] args) {

        Employee[] employee = {new Employee("Коршунов Игорь Олегович", 1, 130290),
                new Employee("Логрова Инна Алексеевна", 3, 92450),
                new Employee("Филимонова Ольга Владимировна", 3, 102500),
                new Employee("Кравец Иван Алексеевич", 5, 83200),
                new Employee("Марунев Тимур Вашхатович", 2, 101000),
                new Employee("Пирогов Александр Натанович", 2, 123500),
                new Employee("Ливов Лев Юрьевич", 4, 91300),
                new Employee("Фирсов Александр Александрович", 4, 87000),
                new Employee("Рогова Ирина Михайловна", 5, 78000),
                new Employee("Гаев Лука Тарасович", 1, 143000)
        };

        System.out.println("Выводим в консоль сотрудников со всеми данными");
        printEmployees(employee);

        System.out.println();
        System.out.println("Расчитываем и выводим затраты за месяц");
        System.out.println("Затраты в месяц: " + amountOfExpensesPerMonth(employee));

        System.out.println();
        System.out.println("Находим сотрудника с минимальной зарплатой");
        System.out.println(employee[minSalary(employee)].toString());

        System.out.println();
        System.out.println("Находим сотрудника с максимальной зарплатой");
        System.out.println(employee[maxSalary(employee)].toString());

        System.out.println();
        System.out.println("Среднее значение зарплат");
        System.out.println(String.format("%.2f", amountOfExpensesPerMonth(employee) / numberOfEmployees(employee)));

        System.out.println();
        System.out.println("ФИО сотрудников");
        printNameEmployees(employee);

//        Повышенная сложность
//        Задача 1
        System.out.println();
        System.out.println("Индексация зарплаты");
        double indexationPercentage = 8.3;
        wageIndexation(employee, indexationPercentage);
        printEmployees(employee);

//        Задача 2.a
        System.out.println();
        int department = 2;
        System.out.println("Найти сотрудника с мин.зарплатой в отделе " + department);
        int sign = -1;
        sign = minSalaryDepartment(employee, department);
        System.out.println(employee[sign].toString());

//        Задача 2.b
        System.out.println();
        department = 3;
        System.out.println("Найти сотрудника с макс.зарплатой в отделе " + department);
        sign = maxSalaryDepartment(employee, department);
        System.out.println(employee[sign].toString());

//        Задача 2.c
        System.out.println();
        department = 1;
        System.out.println("Сумма затрат на з/п по отделу " + department);
        System.out.println(totalExpensesPerDepartment(employee, department));

//        Задача 2.d
        System.out.println();
        department = 1;
        System.out.println("Средняя з/п по отделу " + department);
        System.out.println(averageDepartmentSalary(employee, department));

//        Задача 2.e
        System.out.println();
        department = 4;
        double percent = 2.2;
        System.out.println("Индексация з/п по отделу " + department + " на " + percent + "%");
        wageIndexationDepartment(employee, department, percent);
        printEmployeesDepartment(employee, department);

//        Задача 2.f
        System.out.println();
        department = 1;
        System.out.println("Сотрудники отдела " + department + " и их данные");
        printEmployeesDepartment(employee, department);

//        Задача 3.a
        System.out.println();
        double number = 99500;
        System.out.println("Сотрудники имеющие зарплату менее: " + number);
        employeesLess(employee, number);

//        Задача 3.b
        System.out.println();
        number = 99500;
        System.out.println("Сотрудники имеющие зарплату более: " + number);
        employeesMore(employee, number);

    }

    //        Задача 3.b
    public static void employeesMore(Employee[] employees, double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Введите положительное число");
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > number && employees[i].getSalary() != 0) {
                System.out.println("ID: " + employees[i].getId()
                        + ", Сотрудник: " + employees[i].getName()
                        + ", Зарплата " + employees[i].getSalary());
            }
        }
    }

    //        Задача 3.a
    public static void employeesLess(Employee[] employees, double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Введите положительное число");
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < number && employees[i].getSalary() != 0) {
                System.out.println("ID: " + employees[i].getId()
                        + ", Сотрудник: " + employees[i].getName()
                        + ", Зарплата " + employees[i].getSalary());
            }
        }
    }

    //        Задача 2.f
    public static void printEmployeesDepartment(Employee[] employees, int department) {
        if (department <= 0 || department > 5) {
            throw new IllegalArgumentException("Ошибка ввода номера отдела");
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                System.out.println("ID: " + employees[i].getId()
                        + ", Сотрудник: " + employees[i].getName()
                        + ", Зарплата " + employees[i].getSalary());
            }
        }
    }

    //        Задача 2.e
    public static void wageIndexationDepartment(Employee[] employees, int department, double index) {
        if (department <= 0 || department > 5) {
            throw new IllegalArgumentException("Ошибка ввода номера отдела");
        }
        if (index <= 0) {
            throw new IllegalArgumentException("Ошибка ввода процента индексации. Введите положительное число.");
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getName() == null || employees[i].getName().isEmpty()) {

            } else if (employees[i].getDepartment() == department) {
                employees[i].setSalary((double) ((int) ((employees[i].getSalary() * (1 + index / 100)) * 100)) / 100);
            }
        }
    }

    //        Задача 2.d
    public static double averageDepartmentSalary(Employee[] employees, int department) {
        if (department <= 0 || department > 5) {
            throw new IllegalArgumentException("Ошибка ввода номера отдела");
        }
        int counter = 0;
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                sum = sum + employees[i].getSalary();
                counter++;
            }
        }
        return (double) ((int) (sum / counter * 100)) / 100;
    }

    //        Задача 2.c
    public static double totalExpensesPerDepartment(Employee[] employees, int department) {
        if (department <= 0 || department > 5) {
            throw new IllegalArgumentException("Ошибка ввода номера отдела");
        }
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department) {
                sum = sum + employees[i].getSalary();
            }
        }
        return sum;
    }

    //        Задача 2.a
    public static int minSalaryDepartment(Employee[] employees, int department) {
        if (department <= 0 || department > 5) {
            throw new IllegalArgumentException("Ошибка ввода номера отдела");
        }
        int label = 0;
        int sign = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department
                    && label == 0
                    && employees[i].getSalary() != 0) {
                sign = i;
                label = 1;
            }
            if (employees[i].getDepartment() == department
                    && employees[i].getSalary() < employees[sign].getSalary()
                    && employees[i].getSalary() != 0) {
                sign = i;
            }
        }
        if (sign == -1) {
            throw new IllegalArgumentException("В отделе нет сотрудников");
        } else return sign;
    }

    //        Задача 2.b
    public static int maxSalaryDepartment(Employee[] employees, int department) {
        if (department <= 0 || department > 5) {
            throw new IllegalArgumentException("Ошибка ввода номера отдела");
        }
        int label = 0;
        int sign = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment() == department
                    && label == 0
                    && employees[i].getSalary() != 0) {
                sign = i;
                label = 1;
            }
            if (employees[i].getDepartment() == department
                    && employees[i].getSalary() > employees[sign].getSalary()
                    && employees[i].getSalary() != 0) {
                sign = i;
            }
        }
        if (sign == -1) {
            throw new IllegalArgumentException("В отделе нет сотрудников");
        } else return sign;
    }

    //        Задача 1
    public static void wageIndexation(Employee[] employees, double index) {
        if (index <= 0) {
            throw new IllegalArgumentException("Ошибка ввода процента индексации. Введите положительное число.");
        }
        int rounding;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getName() == null || employees[i].getName().isEmpty()) {

            } else {
                rounding = (int) ((employees[i].getSalary() * (1 + index / 100)) * 100);
                employees[i].setSalary((double) rounding / 100);
            }
        }
    }

    public static void printNameEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getName() == null || employees[i].getName().isEmpty()) {

            } else System.out.println(employees[i].getName());
        }
    }

    public static int numberOfEmployees(Employee[] employees) {
        int number = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getName() == null || employees[i].getName().isEmpty()) {

            } else number++;
        }
        return number;
    }

    public static int minSalary(Employee[] employees) {
        double minSalary = employees[maxSalary(employees)].getSalary();
        int sign = 0;
        for (int i = 0; i < employees.length; i++) {
            if (minSalary > employees[i].getSalary()) {
                minSalary = employees[i].getSalary();
                sign = i;
            }
        }
        return sign;
    }

    public static int maxSalary(Employee[] employees) {
        double maxSalary = 0;
        int sign = 0;
        for (int i = 0; i < employees.length; i++) {
            if (maxSalary < employees[i].getSalary()) {
                maxSalary = employees[i].getSalary();
                sign = i;
            }
        }
        return sign;
    }

    public static void printEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getName() == null || employees[i].getName().isEmpty()) {

            } else System.out.println(employees[i].toString());
        }
    }

    public static double amountOfExpensesPerMonth(Employee[] employees) {
        double totalSummMonth = 0;
        for (int i = 0; i < employees.length; i++) {
            totalSummMonth = totalSummMonth + employees[i].getSalary();
        }
        return totalSummMonth;
    }

}