package Week2;

import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> elements = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            String[] tokens = text.split(" ");
            for (int j = 0; j < tokens.length; j++) {
                elements.add(tokens[j]);
            }
        }
        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
