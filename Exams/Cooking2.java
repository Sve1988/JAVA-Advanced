package Exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cooking2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queue = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stack::push);

        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruit = 0;

        while (!queue.isEmpty() && !stack.isEmpty()){
            int first = queue.poll();
            int second = stack.pop();

            if (first+second == 25){
                bread++;

            }
            else if (first+second == 50){
                cake++;

            }
            else if (first+second == 75){
                pastry++;
            }
            else if (first+second == 100){
                fruit++;
            }
            else {

                stack.push(second+3);
            }
        }

        if (bread > 0 && cake > 0 && pastry > 0 && fruit > 0){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }
        else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        if (queue.isEmpty()){
            System.out.println("Liquids left: none");
        }
        else {
            System.out.print("Liquids left: ");
            System.out.println(String.join(", ", String.valueOf(queue).replaceAll("[\\[\\]]", "")));
        }
        if (stack.isEmpty()){
            System.out.println("Ingredients left: none");
        }
        else {
            System.out.print("Ingredients left: ");
            System.out.println(String.join(", ", String.valueOf(stack).replaceAll("[\\[\\]]", "")));
        }
        System.out.println("Bread: " + bread);
        System.out.println("Cake: " + cake);
        System.out.println("Fruit Pie: " + fruit);
        System.out.println("Pastry: " + pastry);
    }
}
