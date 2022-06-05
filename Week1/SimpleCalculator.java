package Week1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] elements = text.split("\\s+");
        for (int i = elements.length - 1; i >= 0; i--) {
            stack.push(elements[i]);
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            int a = Integer.parseInt(stack.pop());
            String action = stack.pop();
            int b = Integer.parseInt(stack.pop());
            if (action.equals("+")) {
                sum = a + b;
                String sum1 = String.valueOf(sum);
                if (!stack.isEmpty()) {
                    stack.push(sum1);
                }
                else {
                    System.out.println(sum1);
                }
            } else if (action.equals("-")) {
                sum = a - b;
                String sum1 = String.valueOf(sum);

                if (!stack.isEmpty()) {
                    stack.push(sum1);
                }
                else {
                    System.out.println(sum1);
                }
            }
        }
    }
}

