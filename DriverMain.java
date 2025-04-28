import java.util.Scanner;

//  Interface
interface Taxable {
    double salesTax = 0.07;   // 7%
    double incomeTax = 0.105; // 10.5%

    void calcTax(); // abstract method
}

//  Employee class
class Employee implements Taxable {
    private int empId;
    private String name;
    private double salary; // monthly salary

    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void calcTax() {
        double yearlySalary = salary * 12;
        double tax = yearlySalary * incomeTax;
        System.out.println("Income Tax for employee " + name + " (ID: " + empId + "): Rs." + tax);
    }
}

//  Product class
class Product implements Taxable {
    private int pid;
    private double price;
    private int quantity;

    public Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public void calcTax() {
        double tax = price * salesTax;
        System.out.println("Sales Tax for product ID " + pid + " (Unit Price Rs." + price + "): Rs." + tax);
    }
}

//  Main class
public class DriverMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept Employee Info
        System.out.println("--- Enter Employee Details ---");
        System.out.print("Enter Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Employee Monthly Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(empId, name, salary);
        emp.calcTax();

        // Accept Product Info
        System.out.println("\n--- Enter Product Details ---");
        System.out.print("Enter Product ID: ");
        int pid = sc.nextInt();
        System.out.print("Enter Product Unit Price: ");
        double price = sc.nextDouble();
        System.out.print("Enter Product Quantity: ");
        int quantity = sc.nextInt();

        Product prod = new Product(pid, price, quantity);
        prod.calcTax();

        sc.close();
    }
}
