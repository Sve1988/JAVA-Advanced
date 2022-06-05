package Classes.CompanyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, Department> departments = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            String[] parameters = text.split(" ");
            String name = text.split(" ")[0];
            double salary = Double.parseDouble(text.split(" ")[1]);
            String position = text.split(" ")[2];
            String department = text.split(" ")[3];
            Employee employee = null;
            if (parameters.length == 6) {
                String email = text.split(" ")[4];
                int age = Integer.parseInt(text.split(" ")[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (parameters.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (parameters.length == 5) {
                if (text.split(" ")[4].contains("@")) {
                    String email = text.split(" ")[4];
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(text.split(" ")[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
            }

            if (!departments.containsKey(department)){
                departments.put(department, new Department(department));
            }
            departments.get(department).getEmployees().add(employee);
        }
        Department max = departments.entrySet()
                .stream()
                .max(Comparator.comparing(e -> e.getValue().averageSalary()))
                .get()
                .getValue();
        System.out.println("Highest Average Salary: " + max.getName());
        max.getEmployees()
                .stream()
                .sorted((e1,e2) ->Double.compare(e2.getSalary(),e1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));
    }
}
