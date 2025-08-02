
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

        EmployeeBook employeeBook = new EmployeeBook(employee);

        System.out.println("Выводим в консоль сотрудников со всеми данными");
        employeeBook.printEmployees();

        System.out.println();
        System.out.println("Расчитываем и выводим затраты за месяц");
        System.out.println("Затраты в месяц: " + employeeBook.amountOfExpensesPerMonth());

        System.out.println();
        System.out.println("Находим сотрудника с минимальной зарплатой");
        System.out.println(employee[employeeBook.minSalary()].toString());

        System.out.println();
        System.out.println("Находим сотрудника с максимальной зарплатой");
        System.out.println(employee[employeeBook.maxSalary()].toString());

        System.out.println();
        System.out.println("Среднее значение зарплат");
        System.out.println(String.format("%.2f", employeeBook.amountOfExpensesPerMonth() / employeeBook.numberOfEmployees()));

        System.out.println();
        System.out.println("ФИО сотрудников");
        employeeBook.printNameEmployees();

//        Повышенная сложность
//        Задача 1
        System.out.println();
        System.out.println("Индексация зарплаты");
        double indexationPercentage = 8.3;
        employeeBook.wageIndexation(indexationPercentage);
        employeeBook.printEmployees();

//        Задача 2.a
        System.out.println();
        int department = 5;
        System.out.println("Найти сотрудника с мин.зарплатой в отделе " + department);
        System.out.println(employee[employeeBook.minSalaryDepartment(department)].toString());

//        Задача 2.b
        System.out.println();
        department = 3;
        System.out.println("Найти сотрудника с макс.зарплатой в отделе " + department);
        System.out.println(employee[employeeBook.maxSalaryDepartment(department)].toString());

//        Задача 2.c
        System.out.println();
        department = 1;
        System.out.println("Сумма затрат на з/п по отделу " + department);
        System.out.println(employeeBook.totalExpensesPerDepartment(department));

//        Задача 2.d
        System.out.println();
        department = 1;
        System.out.println("Средняя з/п по отделу " + department);
        System.out.println(employeeBook.averageDepartmentSalary(department));

//        Задача 2.e
        System.out.println();
        department = 4;
        double percent = 2.2;
        System.out.println("Индексация з/п по отделу " + department + " на " + percent + "%");
        employeeBook.wageIndexationDepartment(department, percent);
        employeeBook.printEmployeesDepartment(department);

//        Задача 2.f
        System.out.println();
        department = 1;
        System.out.println("Сотрудники отдела " + department + " и их данные");
        employeeBook.printEmployeesDepartment(department);

//        Задача 3.a
        System.out.println();
        double number = 99500;
        System.out.println("Сотрудники имеющие зарплату менее: " + number);
        employeeBook.employeesLess(number);

//        Задача 3.b
        System.out.println();
        number = 99500;
        System.out.println("Сотрудники имеющие зарплату более: " + number);
        employeeBook.employeesMore(number);

//        Сложно
//        Задача 4.a
        System.out.println();
        Employee urminovIV = new Employee("Урминов Игнат Валерьевич", 3, 121200);
        System.out.println("Добавляем сотрудника: " + urminovIV.toString());
        employeeBook.newEmployeeIntroduction(urminovIV);

//    Задача 4.b
        System.out.println();
        int deleteId = 34000007;
        System.out.println("Удаляем сотрудника с ID: " + deleteId);
        employeeBook.employeeRemoval(deleteId);

//        Проверка 4.a после удаления сотрудника
        System.out.println();
        System.out.println("Добавляем сотрудника: " + urminovIV.toString());
        employeeBook.newEmployeeIntroduction(urminovIV);
        employeeBook.printEmployees();

//        Задача 5
        System.out.println();
        int findId = 34000011;
        System.out.println("Находим сотрудника с ID: " + findId);
        if (employeeBook.searchById(findId) != -1) {
            System.out.println(employee[employeeBook.searchById(findId)].toString());
        }

    }
}