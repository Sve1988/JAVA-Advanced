package Classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            String name = text.split(" ")[0];
            int age = Integer.parseInt(text.split(" ")[1]);
            if (age > 30) {
                Person person = new Person(name, age);
                people.add(person);
            }
        }

        people.sort(Comparator.comparing(p -> p.getName()));

        for (Person person : people) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}
