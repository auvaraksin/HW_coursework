package pro.sky;

public class Employee {
    private int employeeId;
    private String employeeName;
    private String departmentId;
    private int employeeSalary;
    public static int count = 1;

    public Employee(String employeeName, String departmentId, int employeeSalary) {
        this.employeeId = count++;
        this.employeeName = employeeName;
        this.departmentId = departmentId;
        this.employeeSalary = employeeSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return employeeId + " " + employeeName + " (" + departmentId + "), зарплата: " + employeeSalary + " руб./мес.";
    }
}