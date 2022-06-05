package Exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bouquets = 0;
        int store = 0;

        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .forEach(tulips::push);

        ArrayDeque<Integer> daffodils = Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        while (!tulips.isEmpty() && !daffodils.isEmpty()){
            int stack = tulips.peek();
            int queue = daffodils.peek();

            if (stack + queue == 15){
                bouquets++;
                tulips.pop();
                daffodils.poll();
            }
            else if (stack + queue > 15) {
                tulips.pop();
                tulips.push(stack - 2);
            }
            else if (stack + queue < 15){
                store = store + stack + queue;
                tulips.pop();
                daffodils.poll();
            }
        }

        int additional = store / 15;
        bouquets = bouquets + additional;

        if (bouquets >= 5){
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        }
        else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }
}
