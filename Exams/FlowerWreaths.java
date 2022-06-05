package Exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wreath = 0;
        int counter = 0;
        String text1 = scanner.nextLine();
        List<Integer> first = new ArrayList<>();
        String[] token1 = text1.split(", ");
        for (int i = 0; i < token1.length; i++) {
            int number = Integer.parseInt(token1[i]);
            first.add(number);
        }
        String text2 = scanner.nextLine();
        List<Integer> second = new ArrayList<>();
        String[] token2 = text2.split(", ");
        for (int i = 0; i < token2.length; i++) {
            int number = Integer.parseInt(token2[i]);
            second.add(number);
        }
        while(!first.isEmpty() && !second.isEmpty()){

            int sum = first.get(first.size()-1) + second.get(0);
            if (sum == 15){
                wreath++;
                first.remove(first.size()-1);
                second.remove(0);
            }
            else if (sum < 15){
                counter = counter + sum;
                first.remove(first.size()-1);
                second.remove(0);
            }
            else {
                int temp = first.get(first.size()-1) - 2;
                first.remove(first.size()-1);
                first.add(temp);
            }
        }
        int count = counter / 15;
        int total = wreath + count;
        if (total >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", total);
        }
        else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", (5 - total));
        }
    }
}
