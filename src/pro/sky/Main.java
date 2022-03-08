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
        System.out.println("============> Индексация 0,3% <============" );
        printList(employeeList);
        System.out.println("Сумма затрат на зарплату в месяц в отделе 2: " + calculateTotalSumMonthSalaryInDepartment(employeeList, 2).setScale(2) + " руь.");
        System.out.println("Сотрудник с минимальной зарплатой в отделе 2: " + findMinSalaryInDepartment(employeeList, 2));
        System.out.println("Сотрудник с максимальной зарплатой в отделе 2: " + findMaxSalaryInDepartment(employeeList, 2));
        System.out.println("Среднее значение зарплаты в отделе 2: " + calculateAverageMonthSalaryInDepartment(employeeList, 2));
        printListOfEmployeeInDepartment(employeeList,2);
        setNewSalaryInDepartment(employeeList, 1.5, 2);
        System.out.println("============> Индексация 1,5% в отделе 2<============" );
        printListOfEmployeeInDepartment(employeeList,2);
        printListOfEmployeeWithSalaryLessThan(employeeList, 150_000);
        printListOfEmployeeWithSalaryMoreThan(employeeList, 150_000);
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

    public static BigDecimal calculateTotalSumMonthSalaryInDepartment(Employee[] employeeList, int departmentId) {
        BigDecimal totalSumMonthSalary = new BigDecimal(0);
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i].getDepartmentId().contains(Integer.toString(departmentId))) {
                totalSumMonthSalary = totalSumMonthSalary.add(employeeList[i].getEmployeeSalary());
            }
        }
        return totalSumMonthSalary;
    }

    public static Employee findMinSalary(Employee[] employeeList) {
        int id = 0;
        double minSalary = employeeList[id].getEmployeeSalary().doubleValue();
        for (int i = 1; i < employeeList.length; i++) {
            if (employeeList[i].getEmployeeSalary().doubleValue() < minSalary) {
                id = i;
                minSalary = employeeList[i].getEmployeeSalary().doubleValue();
            }
        }
        return employeeList[id];
    }

    public static Employee findMinSalaryInDepartment(Employee[] employeeList, int departmentId) {
        int id = 0;
        double minSalary = 200_000;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i].getDepartmentId().contains(Integer.toString(departmentId))) {
                if (employeeList[i].getEmployeeSalary().doubleValue() < minSalary) {
                    id = i;
                    minSalary = employeeList[i].getEmployeeSalary().doubleValue();
                }
            }
        }
        return employeeList[id];
    }

    public static Employee findMaxSalary(Employee[] employeeList) {
        int id = 0;
        double maxSalary = employeeList[id].getEmployeeSalary().doubleValue();
        for (int i = 1; i < employeeList.length; i++) {
            if (employeeList[i].getEmployeeSalary().doubleValue() > maxSalary) {
                id = i;
                maxSalary = employeeList[i].getEmployeeSalary().doubleValue();
            }
        }
        return employeeList[id];
    }

    public static Employee findMaxSalaryInDepartment(Employee[] employeeList, int departmentId) {
        int id = 0;
        double maxSalary = 0;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i].getDepartmentId().contains(Integer.toString(departmentId))) {
                if (employeeList[i].getEmployeeSalary().doubleValue() > maxSalary) {
                    id = i;
                    maxSalary = employeeList[i].getEmployeeSalary().doubleValue();
                }
            }
        }
        return employeeList[id];
    }

    public static BigDecimal calculateAverageMonthSalary(Employee[] employeeList) {
        BigDecimal divisor = new BigDecimal(String.valueOf(employeeList.length));
        BigDecimal averageMonthSalary = new BigDecimal(String.valueOf(calculateTotalSumMonthSalary(employeeList).divide(divisor, 2, RoundingMode.HALF_UP)));
        return averageMonthSalary;
    }

    public static BigDecimal calculateAverageMonthSalaryInDepartment(Employee[] employeeList, int departmentId) {
        int departmentCapacity = 0;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i].getDepartmentId().contains(Integer.toString(departmentId))) {
                departmentCapacity++;
            }
        }
        BigDecimal divisor = new BigDecimal(String.valueOf(departmentCapacity));
        BigDecimal averageMonthSalaryInDepartment = new BigDecimal(String.valueOf(calculateTotalSumMonthSalaryInDepartment(employeeList, departmentId).divide(divisor, 2, RoundingMode.HALF_UP)));
        return averageMonthSalaryInDepartment;
    }

    public static void printListOfEmployee(Employee[] employeeList) {
        System.out.println("Список сотрудников пофамильный");
        for (int i = 0; i < employeeList.length; i++) {
            System.out.println(employeeList[i].getEmployeeName());
        }
    }

    public static void printListOfEmployeeInDepartment(Employee[] employeeList, int departmentId) {
        System.out.println("Список сотрудников пофамильный отдела " + departmentId);
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i].getDepartmentId().contains(Integer.toString(departmentId))) {
                System.out.println(employeeList[i].getEmployeeName() + " " + employeeList[i].getEmployeeSalary());
            }
        }
    }

    public static Employee[] setNewSalary(Employee[] employeeList, double indexRate) {
        double additionalSalary;
        for (int i = 0; i < employeeList.length; i++) {
           additionalSalary = employeeList[i].getEmployeeSalary().doubleValue() * indexRate / 100;
           BigDecimal newSalary = new BigDecimal(additionalSalary);
           newSalary = newSalary.setScale(2,RoundingMode.HALF_UP);
           newSalary = newSalary.add(employeeList[i].getEmployeeSalary());
           employeeList[i].setEmployeeSalary(newSalary);
        }
        return employeeList;
    }

    public static Employee[] setNewSalaryInDepartment(Employee[] employeeList, double indexRate, int departmentId) {
        double additionalSalary;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i].getDepartmentId().contains(Integer.toString(departmentId))) {
                additionalSalary = employeeList[i].getEmployeeSalary().doubleValue() * indexRate / 100;
                BigDecimal newSalary = new BigDecimal(additionalSalary);
                newSalary = newSalary.setScale(2,RoundingMode.HALF_UP);
                newSalary = newSalary.add(employeeList[i].getEmployeeSalary());
                employeeList[i].setEmployeeSalary(newSalary);
            }
        }
        return employeeList;
    }

    public static void printListOfEmployeeWithSalaryLessThan(Employee[] employeeList, double borderOfSalary) {
        System.out.println("Список сотрудников с зарплатой менее " + borderOfSalary + " руб./мес.");
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i].getEmployeeSalary().doubleValue() < borderOfSalary) {
                System.out.println(employeeList[i].getEmployeeName() + " " + employeeList[i].getEmployeeSalary() + " руб.");
            }
        }
    }

    public static void printListOfEmployeeWithSalaryMoreThan(Employee[] employeeList, double borderOfSalary) {
        System.out.println("Список сотрудников с зарплатой более или равно " + borderOfSalary + " руб./мес.");
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i].getEmployeeSalary().doubleValue() >= borderOfSalary) {
                System.out.println(employeeList[i].getEmployeeName() + " " + employeeList[i].getEmployeeSalary() + " руб.");
            }
        }
    }

}