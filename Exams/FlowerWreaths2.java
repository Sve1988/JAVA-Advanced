package Exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wreaths = 0;
        int store = 0;

        ArrayDeque<Integer> lilies = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .forEach(lilies::push);

        ArrayDeque<Integer> roses = Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int first = lilies.peek();
            int second = roses.peek();

            if (first + second == 15) {
                wreaths++;
                lilies.pop();
                roses.poll();
            } else if (first + second > 15) {
                lilies.pop();
                lilies.push(first - 2);
            } else if (first + second < 15) {
                store = store + first + second;
                lilies.pop();
                roses.poll();
            }
        }
        int add = store / 15;
        wreaths = wreaths + add;

        if (wreaths >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n",wreaths);
        }
        else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - wreaths);
        }

    }
}
