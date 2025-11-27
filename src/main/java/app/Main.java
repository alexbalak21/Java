package app;

import app.adept.Department;
import app.adept.Employee;

public class Main {
    void main(){
        Employee[] employees = new Employee[15];
        for (int i = 0 ; i < 15 ; i++){
            employees[i] = new Employee(i+1, "Employee" + i, (i+1)*1000);
            System.out.println(employees[i]);
        }

        System.out.println("Employees: ");
        for (Employee employee : employees){
            System.out.println(employee);
        }

        Department department1 = new Department(1, "IT");
        Department department2 = new Department(2, "DEVS");
        Department department3 = new Department(3, "HR");

        department1.addEmployee(employees[0]);
        department2.addEmployee(employees[1]);
        department3.addEmployee(employees[2]);
        department1.addEmployee(employees[3]);
        department2.addEmployee(employees[4]);
        department3.addEmployee(employees[5]);
        department1.addEmployee(employees[6]);
        department2.addEmployee(employees[7]);
        department3.addEmployee(employees[8]);
        department1.addEmployee(employees[9]);
        department2.addEmployee(employees[10]);
        department3.addEmployee(employees[11]);
        department1.addEmployee(employees[12]);
        department2.addEmployee(employees[13]);
        department3.addEmployee(employees[14]);

        System.out.println("Department 1: ");
        System.out.println(department1);
        System.out.println(department1.getEmployeesNumber());
        System.out.println("Department 2: ");
        System.out.println(department2);
        System.out.println("Department 3: ");
        System.out.println(department3);
    }
}
