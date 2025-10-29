import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Products {
    int id;
    String name;
    int price;

    Products(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Employee {
    String name;
    String gender;
    String department;
    String doj;
    String Salary;

    Employee(String name, String gender, String department, String doj, String Salary) {
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.doj = doj;
        this.Salary = Salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", doj='" + doj + '\'' +
                ", Salary='" + Salary + '\'' +
                '}' + "\n";
    }
}

public class StreamMethods {
    public static void main(String[] args) {

        // IDEA -> max || min || sorted || limit || skip || reduce || filter || map ||
        // peek || count || distinct || collect || collectors
        Integer ar[] = { 1, 2, 31, 46, 5 };

        List<Integer> k = new ArrayList<>(Arrays.asList(ar));
        System.out.println(k);

        int answer = k.stream().map(x -> x * 3).filter(x -> x % 2 == 0).reduce(0, (a, b) -> a + b);
        System.out.println(answer);

        int maxOfK = k.stream().max((a, b) -> a - b).get();
        System.out.println(maxOfK);

        List<Integer> result = k.stream().sorted().collect(Collectors.toList());
        System.out.println(result);

        System.out.println(k.stream().filter(x -> x % 2 == 0).count());

        /// IDEA -> Collectors has various methods IDEA -> Collectors.counting() IDEA ->
        /// Collectors.groupingBy() IDEA -> Collectors.max() IDEA -> Collectors.min()
        /// IDEA -> Collectors.toList() IDEA -> Collectors.toSet() IDEA ->
        /// Collectors.toMap( () -> {}, () -> {} )
        /// 
        /// 
        /// IDEA -> Stream Methods Problems
        /// 
        /// 
        /// IDEA -> Given list of integer -> Filter Even ones -> Multiply Each by 100 ->
        /// IDEA -> sort the elements -> get only distinct elements -> skip first element
        /// and get IDEA -> 4 elements -> finally

        Integer arF[] = { 1, 3, 4, 5, 1, 2, 3, 6, 7, 8 };
        System.out.println(Arrays.stream(arF).filter(x -> x % 2 == 0).map(t -> t * 100).sorted().distinct().skip(1)
                .limit(4).collect(Collectors.toList()));

        /// IDEA -> Keep only those products whose price> 200 and get total sum of
        /// prices of above products

        List<Products> products = Arrays.asList(
                new Products(1, "Laptop", 1200),
                new Products(2, "Phone", 800),
                new Products(3, "Tablet", 500),
                new Products(4, "Headphones", 200),
                new Products(5, "Monitor", 300),
                new Products(6, "Keyboard", 100),
                new Products(7, "Mouse", 50),
                new Products(8, "Printer", 250),
                new Products(9, "Camera", 600),
                new Products(10, "Speaker", 150));

        System.out.println(products.stream().filter(x -> x.price > 200).map(r -> r.price).reduce(0, (a, b) -> a + b));

        System.out.println(products.stream().collect(Collectors.toMap(x -> x.id, x -> x.price)));

        List<Employee> employees = Arrays.asList(
                new Employee("John Doe", "Male", "Engineering", "2015", "75000"),
                new Employee("Jane Smith", "Female", "HR", "2020", "65000"),
                new Employee("Bob Wilson", "Male", "Sales", "2010", "70000"),
                new Employee("Alice Brown", "Female", "Engineering", "2022", "78000"),
                new Employee("Charlie Davis", "Male", "Marketing", "2023", "62000"),
                new Employee("Emma Wilson", "Female", "Finance", "2022", "80000"),
                new Employee("David Miller", "Male", "IT", "2023", "72000"),
                new Employee("Sarah Johnson", "Female", "Operations", "2022", "68000"),
                new Employee("Michael Lee", "Male", "Engineering", "2023", "76000"),
                new Employee("Lisa Anderson", "Female", "HR", "2022", "63000"));

        // IDEA -> How many males and females
        System.out.println(employees.stream().collect(Collectors.groupingBy(x -> x.gender, Collectors.counting())));

        // IDEA -> Name of all Departments
        System.out.println(employees.stream().map(x -> x.department).collect(Collectors.toSet()));

        // IDEA -> Highest paid employee
        System.out.println(
                employees.stream().reduce((a, b) -> {
                    if (Integer.valueOf(a.Salary) > Integer.valueOf(b.Salary))
                        return a;
                    else
                        return b;
                }));

        System.out.println();
        System.out.println();
        System.out.println();
        // IDEA -> Employees Joined after 2015
        System.out.println(employees.stream().filter(x -> Integer.valueOf(x.doj) > Integer.valueOf(2015))
                .collect(Collectors.toList()));

        // IDEA -> Average Salary of each department
        System.out.println(
                employees.stream().collect(Collectors.groupingBy(c -> c.department,
                        Collectors.averagingInt(c -> Integer.valueOf(c.Salary)))));

        // IDEA -> Flat map
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(List.of(1, 2, 3, 4)));
        arr.add(new ArrayList<>(List.of(1, 2, 3, 4, 5)));
        arr.add(new ArrayList<>(List.of(5, 6, 7)));

        System.out.println(arr.stream().flatMap(x -> x.stream()).collect(Collectors.toList()));

        // IDEA -> Count Each letter of mississippi
        String mis = "mississippi";
        System.out.println(
                mis.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(x -> x, Collectors.counting())));

    }
}
