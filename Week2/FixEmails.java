package Week2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> names = new LinkedHashMap<>();
        String text = scanner.nextLine();

        while (!text.equals("stop")){
            String mail = scanner.nextLine();
            if (!mail.endsWith("us") && (!mail.endsWith("uk")) && (!mail.endsWith("com"))){
                names.put(text, mail);
            }
            text = scanner.nextLine();
        }
        for (Map.Entry<String, String> entry: names.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
