package Week1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] tokens = text.split("");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("[") || tokens[i].equals("{") || tokens[i].equals("(")){
                stack.push(tokens[i]);
            }
            else if (tokens[i].equals("]")){
                if (stack.isEmpty()){
                    System.out.println("NO");
                }
                else {
                    String check = stack.pop();
                    if (!check.equals("[")) {
                        break;
                    }
                }
            }
            else if (tokens[i].equals("}")){
                if (stack.isEmpty()){
                    System.out.println("NO");
                }
                else {
                    String check = stack.pop();
                    if (!check.equals("{")) {
                        break;
                    }
                }
            }
            else if (tokens[i].equals(")")){
                if (stack.isEmpty()){
                    System.out.println("NO");
                }
                else {
                    String check = stack.pop();
                    if (!check.equals("(")) {
                        break;
                    }
                }
            }
        }
        if (stack.isEmpty()){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
