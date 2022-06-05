package Week2;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<Character, Integer> symbols = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            if (!symbols.containsKey(current)){
                symbols.put(current, 1);
            }
            else {
                symbols.put(current, symbols.get(current) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry: symbols.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }
    }
}
