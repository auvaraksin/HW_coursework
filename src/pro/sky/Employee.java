package pro.sky;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {
    private int employeeId;
    private String employeeName;
    private String departmentId;
    private BigDecimal employeeSalary;
    public static int count = 1;

    public Employee(String employeeName, String departmentId, BigDecimal employeeSalary) {
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

    public BigDecimal getEmployeeSalary() {
        return employeeSalary;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public void setEmployeeSalary(BigDecimal employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return employeeId + " " + employeeName + " (" + departmentId + "), зарплата: " + employeeSalary.setScale(2) + " руб./мес.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId && employeeName.equals(employee.employeeName) && departmentId.equals(employee.departmentId) && employeeSalary.equals(employee.employeeSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeName, employeeId, employeeSalary);
    }
}