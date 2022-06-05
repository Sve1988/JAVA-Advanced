package Exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int datura = 0;
        int cherry = 0;
        int smoke = 0;

        ArrayDeque<Integer> queue = Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .forEach(stack::push);

        while (!queue.isEmpty() && !stack.isEmpty()){
            int first = queue.peek();
            int second = stack.peek();

            if (first + second == 40){
                datura++;
                queue.poll();
                stack.pop();
            }
            else if (first + second == 60){
                cherry++;
                queue.poll();
                stack.pop();
            }
            else if (first + second == 120){
                smoke++;
                queue.poll();
                stack.pop();
            }
            else {
                stack.pop();
                stack.push(second - 5);
            }

            if (datura >=3 && smoke >= 3 && cherry >= 3){
                break;
            }
        }

        if (datura >=3 && smoke >= 3 && cherry >= 3){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }
        else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (queue.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }
        else {
            System.out.print("Bomb Effects: ");
            System.out.println(String.join(", ", String.valueOf(queue).replaceAll("[\\[\\]]", "")));
        }
        if (stack.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }
        else {
            System.out.print("Bomb Casings: ");
            System.out.println(String.join(", ", String.valueOf(stack).replaceAll("[\\[\\]]", "")));
        }
        System.out.println("Cherry Bombs: " + cherry);
        System.out.println("Datura Bombs: " + datura);
        System.out.println("Smoke Decoy Bombs: " + smoke);
    }
}
