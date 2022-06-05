package Classes.Company2;

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
            String[] tokens = text.split(" ");
            Employee employee = null;
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            if (tokens.length == 6){
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                employee = new Employee(name,salary,position, department,email,age);
            }
            else if (tokens.length == 4){
                employee = new Employee(name,salary,position,department);
            }
            else if (tokens.length == 5){
                if (tokens[4].contains("@")){
                    String email = tokens[4];
                    employee = new Employee(name,salary,position,department,email);
                }
                else {
                    int age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name,salary,position,department,age);
                }
            }
            if (!departments.containsKey(department)){
                departments.put(department, new Department(department));
            }
            departments.get(department).getEmployees().add(employee);
        }

        Department maxSalary = departments.entrySet()
                .stream()
                .max(Comparator.comparing(e -> e.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxSalary.getName());
        maxSalary.getEmployees()
                .stream()
                .sorted((e1,e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee));
    }
}
