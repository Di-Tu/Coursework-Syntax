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
        double minSalary = employees[0].getSalary();
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