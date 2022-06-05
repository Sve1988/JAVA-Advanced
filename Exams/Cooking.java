package Exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruit = 0;
        String text1 = scanner.nextLine();
        List<Integer> liquids = new ArrayList<>();
        String[] token1 = text1.split("\\s+");
        for (int i = 0; i < token1.length; i++) {
            int number = Integer.parseInt(token1[i]);
            liquids.add(number);
        }
        String text2 = scanner.nextLine();
        List<Integer> ingredients = new ArrayList<>();
        String[] token2 = text2.split("\\s+");
        for (int i = 0; i < token2.length; i++) {
            int number = Integer.parseInt(token2[i]);
            ingredients.add(number);
        }
        while (liquids.size() > 0 && ingredients.size() > 0) {
            int first = liquids.get(0);
            int second = ingredients.get(ingredients.size() - 1);
            int sum = first + second;
            if (sum == 25) {
                bread++;
                liquids.remove(0);
                ingredients.remove(ingredients.size()-1);
            }
            else if (sum == 50){
                cake++;
                liquids.remove(0);
                ingredients.remove(ingredients.size()-1);
            }
            else if (sum == 75){
                pastry++;
                liquids.remove(0);
                ingredients.remove(ingredients.size()-1);
            }
            else if (sum == 100){
                fruit++;
                liquids.remove(0);
                ingredients.remove(ingredients.size()-1);
            }
            else {
                liquids.remove(0);
                int temp = ingredients.remove(ingredients.size() - 1) + 3;
                ingredients.add(temp);
            }
        }
        if (bread > 0 && cake > 0 && pastry > 0 && fruit > 0){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }
        else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }
        if (liquids.size() == 0){
            System.out.println("Liquids left: none");
        }
        else {
            System.out.print("Liquids left: ");
            for (int i = 0; i < liquids.size()-1; i++) {
                System.out.print(liquids.get(i) +", ");
            }
            System.out.println(liquids.get(liquids.size()-1));
        }
        if (ingredients.size() == 0){
            System.out.println("Ingredients left: none");
        }
        else {
            System.out.print("Ingredients left: ");
            for (int i = ingredients.size()-1; i > 0; i--) {
                System.out.print(ingredients.get(i) + ", ");
            }
            System.out.println(ingredients.get(0));
        }
        System.out.println("Bread: " + bread);
        System.out.println("Cake: " + cake);
        System.out.println("Fruit Pie: " + fruit);
        System.out.println("Pastry: " + pastry);
    }
}
