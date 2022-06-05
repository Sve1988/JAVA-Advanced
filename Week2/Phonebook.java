package Week2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<String, String> phonebook = new HashMap<>();
        while(!text.equals("search")){
            String[] token = text.split("-");
            String name = token[0];
            String phone = token[1];
            phonebook.put(name, phone);
            text = scanner.nextLine();
        }
        String input = scanner.nextLine();
        while(!input.equals("stop")){
            if (phonebook.containsKey(input)){
                System.out.println(input + " -> " + phonebook.get(input));
            }
            else {
                System.out.printf("Contact %s does not exist.%n", input);
            }

            input = scanner.nextLine();
        }
    }
}
