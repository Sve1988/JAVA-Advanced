package Week1;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.nextLine();
        String text2 = scanner.nextLine();
        String[] commands = text1.split("\\s+");
        int elements = Integer.parseInt(commands[0]);
        int deleted = Integer.parseInt(commands[1]);
        int find = Integer.parseInt(commands[2]);
        String[] numbers = text2.split("\\s+");
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for (String number : numbers) {
            int digit = Integer.parseInt(number);
            nums.push(digit);
        }
        for (int i = 0; i < deleted; i++) {
            nums.pop();
        }
        if(nums.contains(find)){
            System.out.println("true");
        }
        else {
            if (!nums.isEmpty()) {
                System.out.println(Collections.min(nums));
            }
            else {
                System.out.println(0);
            }
        }
    }
}
