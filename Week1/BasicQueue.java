package Week1;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.nextLine();
        String text2 = scanner.nextLine();
        String[] tokens = text1.split("\\s+");
        int elements = Integer.parseInt(tokens[0]);
        int deleted = Integer.parseInt(tokens[1]);
        int find = Integer.parseInt(tokens[2]);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        String[] numbers = text2.split("\\s+");
        for (String number : numbers) {
            queue.offer(Integer.parseInt(number));
        }
        for (int i = 0; i < deleted; i++) {
            queue.poll();
        }
        if (queue.contains(find)){
            System.out.println("true");
        }
        else {
            if (!queue.isEmpty()){
                System.out.println(Collections.min(queue));
            }
            else {
                System.out.println(0);
            }
        }
    }
}
