package Exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text1 = scanner.nextLine();
        List<Integer> first = new ArrayList<>();
        String[] token1 = text1.split(" ");
        for (int i = 0; i < token1.length; i++) {
            int number = Integer.parseInt(token1[i]);
            first.add(number);
        }
        String text2 = scanner.nextLine();
        List<Integer> second = new ArrayList<>();
        String[] token2 = text2.split(" ");
        for (int i = 0; i < token2.length; i++) {
            int number = Integer.parseInt(token2[i]);
            second.add(number);
        }
        int sum = 0;
        while (!first.isEmpty() && !second.isEmpty()){
            int temp = first.get(0) + second.get(second.size()-1);
            if (temp % 2 == 0) {
                sum = sum + temp;
                first.remove(0);
                second.remove(second.size()-1);
            }
            else {
                first.add(temp);
                second.remove(second.size()-1);
            }
        }
        if (first.isEmpty()){
            System.out.println("First lootbox is empty");
        }
        if (second.isEmpty()){
            System.out.println("Second lootbox is empty");
        }
        if (sum >= 100){
            System.out.println("Your loot was epic! Value: " + sum);
        }
        else {
            System.out.println("Your loot was poor... Value: " + sum);
        }
    }
}
