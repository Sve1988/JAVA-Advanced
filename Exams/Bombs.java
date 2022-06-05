package Exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int datura = 0;
        int cherry = 0;
        int smoke = 0;
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
            int sum = first.get(0) + second.get(second.size() - 1);
            if (sum == 40){
                datura++;
                first.remove(0);
                second.remove(second.size() - 1);
            }
            else if (sum == 60){
                cherry++;
                first.remove(0);
                second.remove(second.size() - 1);
            }
            else if (sum == 120){
                smoke++;
                first.remove(0);
                second.remove(second.size() - 1);
            }
            else {
                int temp = second.get(second.size() - 1) - 5;
                second.remove(second.size()-1);
                second.add(temp);
            }
            if (datura >=3 && cherry >= 3 && smoke >=3){
                break;
            }
        }
        if (datura >= 3 && cherry >=3 && smoke >=3){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }
        else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (first.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }
        else {
            System.out.print("Bomb Effects: ");
            for (int i = 0; i < first.size() - 1; i++) {
                System.out.print(first.get(i) + ", ");
            }
            System.out.println(first.get(first.size() - 1));
        }
        if (second.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }
        else {
            System.out.print("Bomb Casings: ");
            for (int i = 0; i < second.size() - 1; i++) {
                System.out.print(second.get(i) + ", ");
            }
            System.out.println(second.get(second.size() - 1));
        }
        System.out.println("Cherry Bombs: " + cherry);
        System.out.println("Datura Bombs: " + datura);
        System.out.println("Smoke Decoy Bombs: " + smoke);
    }
}
