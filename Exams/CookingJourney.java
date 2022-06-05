package Exams;

import java.util.Scanner;

public class CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int startRow = 0;
        int startCol = 0;
        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            String text = scanner.nextLine();
            for (int j = 0; j < text.length(); j++) {
                char symbol = text.charAt(j);
                matrix[i][j] = symbol;
                if (symbol == 'S') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        String text = scanner.nextLine();

        while (sum < 50) {
            if (text.equals("right")) {
                matrix[startRow][startCol] = '-';
                if (startCol == size - 1) {
                    break;
                }
                else {
                    startCol = startCol+1;
                    char symbol = matrix[startRow][startCol];
                    if (Character.isDigit(symbol)){
                        matrix[startRow][startCol] = 'S';
                        int number = Character.getNumericValue(symbol);
                        sum = sum + number;
                        if (sum >= 50){
                            break;
                        }
                    }
                    else if (symbol == 'P'){
                        matrix[startRow][startCol] = '-';
                        for (int i = 0; i < size; i++) {
                            for (int j = 0; j < size; j++) {
                                if (matrix[i][j] == 'P'){
                                    startRow = i;
                                    startCol = j;
                                    matrix[i][j] = 'S';
                                }
                            }
                        }
                    }
                    else if (symbol =='-'){
                        matrix[startRow][startCol] = 'S';
                    }
                }
            }
            else if (text.equals("left")){
                matrix[startRow][startCol] = '-';
                if (startCol == 0) {
                    break;
                }
                else {
                    startCol = startCol-1;
                    char symbol = matrix[startRow][startCol];
                    if (Character.isDigit(symbol)){
                        matrix[startRow][startCol] = 'S';
                        int number = Character.getNumericValue(symbol);
                        sum = sum + number;
                        if (sum >= 50){
                            break;
                        }
                    }
                    else if (symbol == 'P'){
                        matrix[startRow][startCol] = '-';
                        for (int i = 0; i < size; i++) {
                            for (int j = 0; j < size; j++) {
                                if (matrix[i][j] == 'P'){
                                    startRow = i;
                                    startCol = j;
                                    matrix[i][j] = 'S';
                                }
                            }
                        }
                    }
                    else if (symbol =='-'){
                        matrix[startRow][startCol] = 'S';
                    }
                }
            }
            else if (text.equals("up")){
                matrix[startRow][startCol] = '-';
                if (startRow == 0) {
                    break;
                }
                else {
                    startRow = startRow-1;
                    char symbol = matrix[startRow][startCol];
                    if (Character.isDigit(symbol)){
                        matrix[startRow][startCol] = 'S';
                        int number = Character.getNumericValue(symbol);
                        sum = sum + number;
                        if (sum >= 50){
                            break;
                        }
                    }
                    else if (symbol == 'P'){
                        matrix[startRow][startCol] = '-';
                        for (int i = 0; i < size; i++) {
                            for (int j = 0; j < size; j++) {
                                if (matrix[i][j] == 'P'){
                                    startRow = i;
                                    startCol = j;
                                    matrix[i][j] = 'S';
                                }
                            }
                        }
                    }
                    else if (symbol =='-'){
                        matrix[startRow][startCol] = 'S';
                    }
                }
            }
            else if (text.equals("down")){
                matrix[startRow][startCol] = '-';
                if (startRow == size - 1) {
                    break;
                }
                else {
                    startRow = startRow+1;
                    char symbol = matrix[startRow][startCol];
                    if (Character.isDigit(symbol)){
                        matrix[startRow][startCol] = 'S';
                        int number = Character.getNumericValue(symbol);
                        sum = sum + number;
                        if (sum >= 50){
                            break;
                        }
                    }
                    else if (symbol == 'P'){
                        matrix[startRow][startCol] = '-';
                        for (int i = 0; i < size; i++) {
                            for (int j = 0; j < size; j++) {
                                if (matrix[i][j] == 'P'){
                                    startRow = i;
                                    startCol = j;
                                    matrix[i][j] = 'S';
                                }
                            }
                        }
                    }
                    else if (symbol =='-'){
                        matrix[startRow][startCol] = 'S';
                    }
                }
            }

            text = scanner.nextLine();
        }
        if (sum >= 50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        else {
            System.out.println("Bad news! You are out of the pastry shop.");
        }
        System.out.println("Money: " + sum);
        printMatrix(matrix, size);
    }
    public static void printMatrix(char [][] matrix, int size){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
