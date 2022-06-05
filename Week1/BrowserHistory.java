package Week1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        String text = scanner.nextLine();

        while(!text.equals("Home")){
            if (!text.equals("back")){
                stack.push(text);
                System.out.println(text);
            } else {
                if (stack.isEmpty()){
                    System.out.println("no previous URLs");
                }
                else {
                    if(stack.size() == 1){
                        System.out.println("no previous URLs");
                    }
                    else {
                        stack.pop();
                        System.out.println(stack.peek());
                    }
                }
            }

            text = scanner.nextLine();
        }
    }
}
