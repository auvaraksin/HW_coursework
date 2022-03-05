package pro.sky;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) {
        Employee[] employeeList = generateEmployeeList();
        printList(employeeList);
        System.out.println("Сумма затрат на зарплату в месяц: " + calculateTotalSumMonthSalary(employeeList).setScale(2) + " руб.");
        System.out.println("Сотрудник с минимальной зарплатой: " + findMinSalary(employeeList));
        System.out.println("Сотрудник с максимальной зарплатой: " + findMaxSalary(employeeList));
        System.out.println("Среднее значение зарплаты: " + calculateAverageMonthSalary(employeeList) + " руб./мес.");
        printListOfEmployee(employeeList);
        setNewSalary(employeeList,0.3);
        printList(employeeList);
        System.out.println("Сумма затрат на зарплату в месяц: " + calculateTotalSumMonthSalary(employeeList).setScale(2) + " руб.");
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

    public static BigDecimal generateRandomSalary() {
        java.util.Random random = new java.util.Random();
        BigDecimal randomSalary = BigDecimal.valueOf(random.nextInt(100_000) + 100_000);
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

    public static BigDecimal calculateTotalSumMonthSalary(Employee[] employeeList) {
        BigDecimal totalSumMonthSalary = new BigDecimal(0);
        for (int i = 0; i < employeeList.length; i++) {
            totalSumMonthSalary = totalSumMonthSalary.add(employeeList[i].getEmployeeSalary());
        }
        return totalSumMonthSalary;
    }

    public static Employee findMinSalary(Employee[] employeesList) {
        int id = 0;
        double minSalary = employeesList[id].getEmployeeSalary().doubleValue();
        for (int i = 1; i < employeesList.length; i++) {
            if (employeesList[i].getEmployeeSalary().doubleValue() < minSalary) {
                id = i;
                minSalary = employeesList[i].getEmployeeSalary().doubleValue();
            }
        }
        return employeesList[id];
    }

//    public static Employee findMinSalaryInDepartment(Employee[] employeeList, int departmentId) {
//
//    }

    public static Employee findMaxSalary(Employee[] employeesList) {
        int id = 0;
        double maxSalary = employeesList[id].getEmployeeSalary().doubleValue();
        for (int i = 1; i < employeesList.length; i++) {
            if (employeesList[i].getEmployeeSalary().doubleValue() > maxSalary) {
                id = i;
                maxSalary = employeesList[i].getEmployeeSalary().doubleValue();
            }
        }
        return employeesList[id];
    }

    public static BigDecimal calculateAverageMonthSalary(Employee[] employeesList) {
        BigDecimal divisor = new BigDecimal(String.valueOf(employeesList.length));
        BigDecimal averageMonthSalary = new BigDecimal(String.valueOf(calculateTotalSumMonthSalary(employeesList).divide(divisor, 2, RoundingMode.CEILING)));
        return averageMonthSalary;
    }

    public static void printListOfEmployee(Employee[] employeeList) {
        System.out.println("Список сотрудников пофамильный");
        for (int i = 0; i < employeeList.length; i++) {
            System.out.println(employeeList[i].getEmployeeName());
        }
    }

    public static Employee[] setNewSalary(Employee[] employeeList, double indexRate) {
        double additionalSalary;
        for (int i = 0; i < employeeList.length; i++) {
           additionalSalary = employeeList[i].getEmployeeSalary().doubleValue() * indexRate / 100;
           BigDecimal newSalary = new BigDecimal(additionalSalary);
           newSalary = newSalary.setScale(2,RoundingMode.CEILING);
           newSalary = newSalary.add(employeeList[i].getEmployeeSalary());
           employeeList[i].setEmployeeSalary(newSalary);
        }
        return employeeList;
    }

}