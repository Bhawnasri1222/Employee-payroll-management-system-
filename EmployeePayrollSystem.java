import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String name;
    private int employeeId;
    private double baseSalary;
    private double bonus;
    private double deductions;

    // Constructor
    public Employee(String name, int employeeId, double baseSalary, double bonus, double deductions) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.deductions = deductions;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public double getDeductions() {
        return deductions;
    }

    // Calculate net salary
    public double calculateNetSalary() {
        return baseSalary + bonus - deductions;
    }

    // Print Employee details and salary report
    public void printSalaryReport() {
        System.out.println("\nEmployee ID: " + employeeId);
        System.out.println("Employee Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Bonus: $" + bonus);
        System.out.println("Deductions: $" + deductions);
        System.out.println("Net Salary: $" + calculateNetSalary());
    }
}

class PayrollManagementSystem {
    private ArrayList<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Add a new employee
    public void addEmployee() {
        System.out.println("\nEnter Employee Details:");
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Employee ID: ");
        int employeeId = scanner.nextInt();
        System.out.print("Base Salary: ");
        double baseSalary = scanner.nextDouble();
        System.out.print("Bonus: ");
        double bonus = scanner.nextDouble();
        System.out.print("Deductions: ");
        double deductions = scanner.nextDouble();

        Employee newEmployee = new Employee(name, employeeId, baseSalary, bonus, deductions);
        employees.add(newEmployee);
        System.out.println("Employee added successfully!\n");
    }

    // Generate payroll report for all employees
    public void generatePayrollReport() {
        if (employees.size() == 0) {
            System.out.println("No employees available to generate payroll report.");
            return;
        }
        System.out.println("\n*** Payroll Report ***");
        for (Employee employee : employees) {
            employee.printSalaryReport();
        }
    }

    // Display menu options
    public void displayMenu() {
        int option;
        do {
            System.out.println("\nEmployee Payroll Management System:");
            System.out.println("1. Add Employee");
            System.out.println("2. Generate Payroll Report");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    generatePayrollReport();
                    break;
                case 3:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 3);
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        PayrollManagementSystem system = new PayrollManagementSystem();
        system.displayMenu();
    }
}