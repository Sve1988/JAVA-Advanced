package Week1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String text = scanner.nextLine();

        while(!text.equals("print")){
            if (!text.equals("cancel")){
                queue.offer(text);
            }
            else {
                if (queue.isEmpty()){
                    System.out.println("Printer is on standby");
                }
                else {
                    System.out.println("Canceled " + queue.poll());
                }
            }
            text = scanner.nextLine();
        }
        for (String s : queue) {
            System.out.println(s);
        }
    }
}
