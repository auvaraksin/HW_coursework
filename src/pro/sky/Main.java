package pro.sky;

public class Main {

    public static void main(String[] args) {
        Employee[] employeeList = generateEmployeeList();
        printList(employeeList);
        System.out.println("Сумма затрат на зарплату в месяц: " + calculateTotalSumMonthSalary(employeeList) + " руб.");
        System.out.println("Сотрудник с минимальной зарплатой: " + findMinSalary(employeeList));
        System.out.println("Сотрудник с максимальной зарплатой: " + findMaxSalary(employeeList));
        System.out.println("Среднее значение зарплаты: " + calculateAverageMonthSalary(employeeList) + " руб./мес.");
        printListOfEmployee(employeeList);
    }

    public static String generateRandomEmployeeName() {
        String[] surnameList = {"Яшин", "Маслаченко", "Кесарев", "Чохели", "Масленкин", "Крутиков",
                "Войнов", "Нетто", "Царев", "Матревели", "Иванов", "Понедельник", "Бубукин", "Ковалев", "Месхи", "Апухтин", "Калоев"};
        String[] nameList = {"Лев", "Владимир", "Гиви", "Анатолий", "Юрий", "Игорь", "Виктор", "Слава", "Валентин", "Юрий",
                "Михаил", "Герман","Заур"};
        String[] patronymicList = {"Иванович", "Никитович", "Петрович", "Дмитриевич", "Евстигнеевич", "Федорович", "Николаевич", "Александрович", "Григорьевич", "Калистратович", "Козьмич", "Владимирович", "Борисович", "Шалвович"};
        int randSurname = (int) (Math.random() * surnameList.length);
        int randName = (int) (Math.random() * nameList.length);
        int randPatronymic = (int) (Math.random() * patronymicList.length);
        String employeeName = surnameList[randSurname] + " " + nameList[randName] + " " + patronymicList[randPatronymic];
        return employeeName;
    }

    public static String generateRandomDepartment() {
        int randomId = (int) (Math.random() * 3) + 1;
        String departmentId = "Отдел " + randomId;
        return departmentId;
    }

    public static int generateRandomSalary() {
        java.util.Random random = new java.util.Random();
        int randomSalary = random.nextInt(100_000) + 100_000;
        return randomSalary;
    }

    public static Employee[] generateEmployeeList() {
        Employee[] employeeList = new Employee[10];
        for (int i = 0; i < employeeList.length; i++) {
            employeeList[i] = new Employee(generateRandomEmployeeName(), generateRandomDepartment(), generateRandomSalary());
        }
        return employeeList;
    }

    public static void printList(Employee[] employeeList) {
        System.out.println("Список сотрудников полный");
        for (int i = 0; i < employeeList.length; i++) {
            System.out.println(employeeList[i]);
        }
    }

    public static int calculateTotalSumMonthSalary(Employee[] employeeList) {
        int totalSumMonthSalary = 0;
        for (int i = 0; i < employeeList.length; i++) {
            totalSumMonthSalary += employeeList[i].getEmployeeSalary();
        }
        return totalSumMonthSalary;
    }

    public static Employee findMinSalary(Employee[] employeesList) {
        int id = 0;
        int minSalary = employeesList[id].getEmployeeSalary();
        for (int i = 1; i < employeesList.length; i++) {
            if (employeesList[i].getEmployeeSalary() < minSalary) {
                id = i;
                minSalary = employeesList[i].getEmployeeSalary();
            }
        }
        return employeesList[id];
    }

    public static Employee findMaxSalary(Employee[] employeesList) {
        int id = 0;
        int maxSalary = employeesList[id].getEmployeeSalary();
        for (int i = 1; i < employeesList.length; i++) {
            if (employeesList[i].getEmployeeSalary() > maxSalary) {
                id = i;
                maxSalary = employeesList[i].getEmployeeSalary();
            }
        }
        return employeesList[id];
    }

    public static float calculateAverageMonthSalary(Employee[] employeesList) {
        float averageMonthSalary = calculateTotalSumMonthSalary(employeesList);
        averageMonthSalary = averageMonthSalary / employeesList.length;
        return averageMonthSalary;
    }

    public static void printListOfEmployee(Employee[] employeeList) {
        System.out.println("Список сотрудников пофамильный");
        for (int i = 0; i < employeeList.length; i++) {
            System.out.println(employeeList[i].getEmployeeName());
        }
    }

}