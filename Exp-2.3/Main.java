import java.util.*;
import java.util.stream.*;

// Part a: Sorting Employee Objects Using Lambda Expressions
class Employee {
    int id;
    String name;
    int age;
    long salary;
    Employee(int id, String name, int age, long salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
    }
}

// Part b: Filtering and Sorting Students Using Streams
class Student {
    String name;
    int score;
    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String toString() {
        return name + ": " + score;
    }
}

// Part c: Stream Operations on Product Dataset
class Product {
    int id;
    String name;
    double price;
    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        // Part a: Sorting Employee Objects Using Lambda Expressions
        List<Employee> employees = Arrays.asList(
            new Employee(10, "Ramesh", 30, 400000),
            new Employee(20, "Santosh", 29, 350000),
            new Employee(30, "Sanjay", 30, 450000),
            new Employee(40, "Pramod", 29, 500000)
        );
        employees.sort((e1, e2) -> e1.name.compareTo(e2.name));
        System.out.println("Sorted by name ASC: " + employees);
        employees.sort((e1, e2) -> e2.name.compareTo(e1.name));
        System.out.println("Sorted by name DESC: " + employees);
        employees.sort((e1, e2) -> Long.compare(e1.salary, e2.salary));
        System.out.println("Sorted by salary: " + employees);

        // Part b: Filtering and Sorting Students Using Streams
        List<Student> students = Arrays.asList(
            new Student("Ravi", 76),
            new Student("Amit", 84),
            new Student("Sneha", 62),
            new Student("Priya", 89)
        );
        List<Student> filteredSorted = students.stream()
            .filter(s -> s.score >= 70)
            .sorted(Comparator.comparing(s -> s.name))
            .collect(Collectors.toList());
        System.out.println("Filtered & Sorted Students: " + filteredSorted);

        // Part c: Stream Operations on Product Dataset
        List<Product> products = Arrays.asList(
            new Product(1, "Laptop", 80000),
            new Product(2, "Phone", 30000),
            new Product(3, "Tablet", 40000),
            new Product(4, "Monitor", 15000)
        );
        List<Product> expensiveProducts = products.stream()
            .filter(p -> p.price >= 40000)
            .sorted(Comparator.comparingDouble(p -> p.price))
            .collect(Collectors.toList());
        System.out.println("Expensive products: " + expensiveProducts);
        double totalPrice = products.stream()
            .mapToDouble(p -> p.price)
            .sum();
        System.out.println("Total price: " + totalPrice);
        Optional<Product> maxProduct = products.stream()
            .max(Comparator.comparingDouble(p -> p.price));
        System.out.println("Max price product: " + maxProduct.get());
    }
}
