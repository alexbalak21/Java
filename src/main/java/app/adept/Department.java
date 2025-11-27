package app.adept;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Department {
    private final int id;
    private final String name;
    private final Employee[] employees;

    public Department (int id, String name){
        this.id = id;
        this.name = name;
        employees = new Employee[10];
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public String addEmployee(Employee employee){
        int length = this.employees.length;
        if (length >= 10) return "Max employees reached";
        else {
            this.employees[length - 1] = employee;
            employee.setDepartment_id(this.id);
            return "Employee " + employee.getName() + " has been added to " + this.getName() + " Department";
        }
    }

    public String[] getEmployeesNames(){
        String[] employees_names = new String[this.employees.length-1];
       for (int i = 0 ; i < this.employees.length ; i++ ){
           employees_names[i] = this.employees[i].getName();
       }
       return employees_names;
    }

    public int getEmployeesNumber(){
        return this.employees.length;
    }

    public Employee getEmployeeById(int id){
        for (Employee employee : this.employees){
            if (id == employee.getId()) return employee;
        }
        return null;
    }

    public double getSalaryTotal(){
        double total = 0;
        for (Employee employee : this.employees){
            total += employee.getSalary();
        }
        return total;
    }

    public double getAverageSalary(){
        int employeesNumber = employees.length;
        double salaryTotal = getSalaryTotal();
        if (employeesNumber == 0 || salaryTotal == 0) return 0;
        return salaryTotal / employeesNumber;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + Arrays.toString(employees) +
                '}';
    }
}
