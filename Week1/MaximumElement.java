package Week1;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String text = scanner.nextLine();
            String[] token = text.split("\\s+");
            if (token[0].equals("1")){
             int digits = Integer.parseInt(token[1]);
                stack.push(digits);
            }
            else if (token[0].equals("2")){
                stack.pop();
            }
            else if (token[0].equals("3")){
                System.out.println(Collections.max(stack));
            }
        }
    }
}
