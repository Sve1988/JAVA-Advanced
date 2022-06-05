package Exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int match = 0;
        String text1 = scanner.nextLine();
        List<Integer> male = new ArrayList<>();
        String[] token1 = text1.split("\\s+");
        for (int i = 0; i < token1.length; i++) {
            int number = Integer.parseInt(token1[i]);
            male.add(number);
        }
        String text2 = scanner.nextLine();
        List<Integer> female = new ArrayList<>();
        String[] token2 = text2.split("\\s+");
        for (int i = 0; i < token2.length; i++) {
            int number = Integer.parseInt(token2[i]);
            female.add(number);
        }

        while(male.size() > 0 && female.size() > 0){
            int man = male.get(male.size() - 1);
            int woman = female.get(0);
            if ((man <= 0) || (woman <= 0)){
                if (man <= 0){
                    male.remove(male.size()-1);
                }
                if (woman <= 0){
                    female.remove(0);
                }
                continue;
            }

            if ((man % 25 == 0) || (woman % 25 == 0)){
                if (man % 25 == 0){
                    if (male.size() > 1) {
                        male.remove(male.size() - 1);
                        male.remove(male.size() - 1);
                    }
                    else {
                        male.remove(male.size() - 1);
                    }
                }
                if (woman % 25 == 0){
                    if(female.size() > 1){
                        female.remove(0);
                        female.remove(0);
                    }
                    else {
                        female.remove(0);
                    }
                }
                continue;
            }

            if (man == woman){
                match++;
                male.remove(male.size()-1);
                female.remove(0);
            }
            else {
                female.remove(0);
                int temp = male.remove(male.size() - 1) - 2;
                if (temp > 0) {
                    male.add(temp);
                }
            }
        }
        System.out.println("Matches: " + match);
        if (male.size() == 0){
            System.out.println("Males left: none");
        }
        else {
            System.out.print("Males left: ");
            for (int i = male.size()-1; i > 0; i--) {
                System.out.print(male.get(i) + ", ");
            }
            System.out.println(male.get(0));
        }
        if (female.size() == 0){
            System.out.println("Females left: none");
        }
        else {
            System.out.print("Females left: ");
            for (int i = 0; i < female.size()-1; i++) {
                System.out.print(female.get(i) + ", ");
            }
            System.out.println(female.get(female.size()-1));
        }
    }
}
