package app.adept;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class DepartmentTest {
    private Department itDepartment;
    private Department hrDepartment;
    private Department financeDepartment;
    private Employee[] employees;

    @BeforeEach
    void setUp() {
        // Create 3 departments
        itDepartment = new Department(1, "IT");
        hrDepartment = new Department(2, "Human Resources");
        financeDepartment = new Department(3, "Finance");

        // Create 15 employees
        employees = new Employee[15];
        for (int i = 0; i < 15; i++) {
            employees[i] = new Employee(i + 1, "Employee " + (i + 1), 50000 + (i * 1000));
        }

        // Assign employees to departments (5 per department)
        for (int i = 0; i < 5; i++) {
            itDepartment.addEmployee(employees[i]);
            hrDepartment.addEmployee(employees[i + 5]);
            financeDepartment.addEmployee(employees[i + 10]);
        }
    }

    @Test
    void testDepartmentCreation() {
        assertNotNull(itDepartment);
        assertNotNull(hrDepartment);
        assertNotNull(financeDepartment);
        
        assertEquals("IT", itDepartment.getName());
        assertEquals(1, itDepartment.getId());
        
        assertEquals("Human Resources", hrDepartment.getName());
        assertEquals(2, hrDepartment.getId());
        
        assertEquals("Finance", financeDepartment.getName());
        assertEquals(3, financeDepartment.getId());
    }

    @Test
    void testAddEmployee() {
        // Test adding employees to departments
        assertEquals(5, itDepartment.getEmployeesNumber());
        assertEquals(5, hrDepartment.getEmployeesNumber());
        assertEquals(5, financeDepartment.getEmployeesNumber());

        // Test employee assignment to correct department
        for (int i = 0; i < 5; i++) {
            assertEquals(1, itDepartment.getEmployees()[i].getDepartment_id());
            assertEquals(2, hrDepartment.getEmployees()[i].getDepartment_id());
            assertEquals(3, financeDepartment.getEmployees()[i].getDepartment_id());
        }
    }

    @Test
    void testGetEmployeeById() {
        // Test getting employees by ID
        Employee emp = itDepartment.getEmployeeById(1);
        assertNotNull(emp);
        assertEquals("Employee 1", emp.getName());
        
        emp = hrDepartment.getEmployeeById(6);
        assertNotNull(emp);
        assertEquals("Employee 6", emp.getName());
        
        emp = financeDepartment.getEmployeeById(11);
        assertNotNull(emp);
        assertEquals("Employee 11", emp.getName());
    }

    @Test
    void testGetSalaryTotal() {
        // Test salary calculation
        double itTotal = itDepartment.getSalaryTotal();
        double hrTotal = hrDepartment.getSalaryTotal();
        double financeTotal = financeDepartment.getSalaryTotal();
        
        // Expected: 5 employees with salaries 50000, 51000, 52000, 53000, 54000
        double expectedItTotal = 50000 + 51000 + 52000 + 53000 + 54000;
        assertEquals(expectedItTotal, itTotal, 0.001);
        
        // Expected: 5 employees with salaries 55000, 56000, 57000, 58000, 59000
        double expectedHrTotal = 55000 + 56000 + 57000 + 58000 + 59000;
        assertEquals(expectedHrTotal, hrTotal, 0.001);
        
        // Expected: 5 employees with salaries 60000, 61000, 62000, 63000, 64000
        double expectedFinanceTotal = 60000 + 61000 + 62000 + 63000 + 64000;
        assertEquals(expectedFinanceTotal, financeTotal, 0.001);
    }

    @Test
    void testGetAverageSalary() {
        // Test average salary calculation
        double itAvg = itDepartment.getAverageSalary();
        double hrAvg = hrDepartment.getAverageSalary();
        double financeAvg = financeDepartment.getAverageSalary();
        
        assertEquals(52000.0, itAvg, 0.001);    // (50000+51000+52000+53000+54000)/5
        assertEquals(57000.0, hrAvg, 0.001);     // (55000+56000+57000+58000+59000)/5
        assertEquals(62000.0, financeAvg, 0.001); // (60000+61000+62000+63000+64000)/5
    }

    @Test
    void testGetEmployeesNames() {
        // Test getting employee names
        String[] itNames = itDepartment.getEmployeesNames();
        String[] hrNames = hrDepartment.getEmployeesNames();
        String[] financeNames = financeDepartment.getEmployeesNames();
        
        assertEquals(5, itNames.length);
        assertEquals(5, hrNames.length);
        assertEquals(5, financeNames.length);
        
        // Verify some names
        assertArrayEquals(
            new String[]{"Employee 1", "Employee 2", "Employee 3", "Employee 4", "Employee 5"}, 
            itNames
        );
    }
}
