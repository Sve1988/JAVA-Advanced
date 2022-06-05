package Week1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (number > 0){
            int num = number % 2;
            number = number / 2;
            stack.push(num);
        }
        if (stack.isEmpty()){
            System.out.println(0);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
