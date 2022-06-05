package StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentSystem rep = new StudentSystem();
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        while (!text.equals("Exit")){
            String[] token = text.split(" ");
            if (token[0].equals("Create")){
                String name = token[1];
                int years = Integer.parseInt(token[2]);
                double grade = Double.parseDouble(token[3]);
                Student student = new Student(name,years,grade);
                rep.add(student);
            }
            else if (token[0].equals("Show")){
                String name = token[1];
                rep.show(name);
            }

            text = scanner.nextLine();
        }
    }
}
