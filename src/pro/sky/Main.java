package pro.sky;

public class Main {

    public static void main(String[] args) {
        Employee[] employeeList = new Employee[10];
        employeeList[0] = new Employee("Андреев Андрей Андреевич", "Отдел 001", generateRandomSalary());
        employeeList[1] = new Employee("Борисов Борис Борисович", "Отдел 002", generateRandomSalary());
        employeeList[2] = new Employee("Васильев Василий Васильевич", "Отдел 003", generateRandomSalary());
        employeeList[3] = new Employee("Гвидонов Гвидон Гвидонович", "Отдел 001", generateRandomSalary());
        employeeList[4] = new Employee("Дмитриев Дмитрий Дмитриевич", "Отдел 002", generateRandomSalary());
        employeeList[5] = new Employee("Егоров Егор Егорович", "Отдел 003", generateRandomSalary());
        employeeList[6] = new Employee("Жан Жан Жанович", "Отдел 001", generateRandomSalary());
        employeeList[7] = new Employee("Захаров Захар Захарович", "Отдел 002", generateRandomSalary());
        employeeList[8] = new Employee("Исмаилов Исмаил Исмаилович", "Отдел 003", generateRandomSalary());
        employeeList[9] = new Employee("Кириллов Кирилл Кириллович", "Отдел 001", generateRandomSalary());
        //code
        printList(employeeList);
        System.out.println("Сумма затрат на зарплату в месяц: " + calculateTotalSumMonthSalary(employeeList) + " руб.");
        System.out.println("Сотрудник с минимальной зарплатой: " + employeeList[findMinSalary(employeeList)]);
        System.out.println("Сотрудник с максимальной зарплатой: " + employeeList[findMaxSalary(employeeList)]);
        System.out.println("Среднее значение зарплаты: " + calculateAverageMonthSalary(employeeList) + " руб./мес.");
        printListOfEmployee(employeeList);
    }

    public static int generateRandomSalary() {
        java.util.Random random = new java.util.Random();
        int randomSalary = random.nextInt(100_000);
        return randomSalary;
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

    public static int findMinSalary(Employee[] employeesList) {
        int id = 0;
        int minSalary = employeesList[id].getEmployeeSalary();
        for (int i = 1; i < employeesList.length; i++) {
            if (employeesList[i].getEmployeeSalary() < minSalary) {
                id = i;
                minSalary = employeesList[i].getEmployeeSalary();
            }
        }
        return id;
    }

    public static int findMaxSalary(Employee[] employeesList) {
        int id = 0;
        int maxSalary = employeesList[id].getEmployeeSalary();
        for (int i = 1; i < employeesList.length; i++) {
            if (employeesList[i].getEmployeeSalary() > maxSalary) {
                id = i;
                maxSalary = employeesList[i].getEmployeeSalary();
            }
        }
        return id;
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