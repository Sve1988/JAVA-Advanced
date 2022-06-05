package Week1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersInStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String [] elements = text.split("\\s+");
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for (String element : elements) {
            int number = Integer.parseInt(element);
            nums.push(number);
        }
        while(!nums.isEmpty()){
            System.out.print(nums.pop() + " ");
        }
    }
}
