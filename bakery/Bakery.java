package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Employee employee){
        if (employees.size() < capacity){
            employees.add(employee);
        }
    }

    public boolean remove(String name){
        int index = -1;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().equals(name)){
                index = i;
            }
        }
        if (index != -1){
            employees.remove(index);
            return true;
        }
        else {
            return false;
        }
    }

    public Employee getOldestEmployee(){
        Employee employee = new Employee();
        int age = -1;
        for (Employee employee1 : employees) {
            if (employee1.getAge() > age){
                age = employee1.getAge();
                employee = employee1;
            }
        }
        return employee;
    }

    public Employee getEmployee(String name){
        Employee employee = new Employee();
        for (Employee employee1 : employees) {
            if (employee1.getName().equals(name)){
                employee = employee1;
            }
        }
        return employee;
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Bakery ");
        sb.append(name);
        sb.append(":");
        sb.append(System.lineSeparator());
        for (Employee employee : employees) {
            sb.append(employee.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }


}
