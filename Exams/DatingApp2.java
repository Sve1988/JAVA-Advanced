package Exams;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matches = 0;
        ArrayDeque<Integer> male = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .forEach(male::push);

        ArrayDeque<Integer> female = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        while(!male.isEmpty() && !female.isEmpty()){
            int first = male.peek();
            if (first <= 0){
                male.pop();
                continue;
            }
            if (first % 25 == 0){
                male.pop();
                if (!male.isEmpty()){
                    male.pop();
                    continue;
                }
            }

            int second = female.peek();
            if (second <= 0){
                female.poll();
                continue;
            }
            if (second % 25 == 0){
                female.poll();
                if (!female.isEmpty()){
                    female.poll();
                    continue;
                }
            }

            if (first == second){
                matches++;
                male.pop();
                female.poll();
            }
            else {
                male.pop();
                female.poll();
                male.push(first-2);
            }
        }

        System.out.println("Matches: " + matches);
        if (male.isEmpty()){
            System.out.println("Males left: none");
        }
        else {
            System.out.print("Males left: ");
            System.out.println(String.join(", ", String.valueOf(male).replaceAll("[\\[\\]]", "")));
        }
        if (female.isEmpty()){
            System.out.println("Females left: none");
        }
        else {
            System.out.print("Females left: ");
            System.out.println(String.join(", ", String.valueOf(female).replaceAll("[\\[\\]]", "")));
        }


    }
}
