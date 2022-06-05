package Exams;

import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int startRow = 0;
        int startCol = 0;
        char[][] matrix = new char[number][number];

        for (int i = 0; i < number; i++) {
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

        int sum = 0;

        String command = scanner.nextLine();

        while (sum < 50){
            if (command.equals("right")){
                matrix[startRow][startCol] = '-';
                if (startCol == number-1){
                    break;
                }
                else {
                    char temp = matrix[startRow][startCol+1];
                    if (Character.isDigit(temp)){
                        int value = Character.getNumericValue(temp);
                        sum = sum + value;

                        startCol = startCol + 1;
                        matrix[startRow][startCol] ='S';
                        if (sum >= 50){
                            break;
                        }
                    }
                    else if (temp == '-'){
                        startCol = startCol + 1;
                        matrix[startRow][startCol] ='S';
                     //    command = scanner.nextLine();
                     //   continue;
                    }
                    else if (temp =='O'){
                        matrix[startRow][startCol+1] = '-';
                        for (int i = 0; i < number; i++) {
                            for (int j = 0; j < number; j++) {
                                if (matrix[i][j] == 'O'){
                                    startRow = i;
                                    startCol = j;
                                    matrix[i][j] = 'S';
                                }
                            }
                        }
                    }
                }
            }
            else if (command.equals("left")){
                matrix[startRow][startCol] = '-';
                if (startCol == 0){
                    break;
                }
                else {
                    char temp = matrix[startRow][startCol-1];
                    if (Character.isDigit(temp)) {
                        int value = Character.getNumericValue(temp);
                        sum = sum + value;

                        startCol = startCol - 1;
                        matrix[startRow][startCol] ='S';
                        if (sum >= 50){
                            break;
                        }
                    }
                    else if (temp == '-'){
                        startCol = startCol - 1;
                        matrix[startRow][startCol] ='S';
                     //   command = scanner.nextLine();
                     //   continue;
                    }
                    else if (temp =='O'){
                        matrix[startRow][startCol-1] = '-';
                        for (int i = 0; i < number; i++) {
                            for (int j = 0; j < number; j++) {
                                if (matrix[i][j] == 'O'){
                                    startRow = i;
                                    startCol = j;
                                    matrix[i][j] = 'S';
                                }
                            }
                        }
                    }
                }
            }
            else if (command.equals("up")){
                matrix[startRow][startCol] = '-';
                if (startRow == 0){
                    break;
                }
                else {
                    char temp = matrix[startRow -1][startCol];
                    if (Character.isDigit(temp)){
                        int value = Character.getNumericValue(temp);
                        sum = sum + value;

                        startRow = startRow-1;
                        matrix[startRow][startCol] ='S';
                        if (sum >= 50){
                            break;
                        }
                    }
                    else if (temp == '-'){
                        startRow = startRow-1;
                        matrix[startRow][startCol] ='S';
                     //   command = scanner.nextLine();
                      //  continue;
                    }
                    else if (temp =='O'){
                        matrix[startRow-1][startCol] = '-';
                        for (int i = 0; i < number; i++) {
                            for (int j = 0; j < number; j++) {
                                if (matrix[i][j] == 'O'){
                                    startRow = i;
                                    startCol = j;
                                    matrix[i][j] = 'S';
                                }
                            }
                        }
                    }
                }
            }
            else if (command.equals("down")){
                matrix[startRow][startCol] = '-';
                if (startRow == number-1){
                    break;
                }
                else {
                    char temp = matrix[startRow +1][startCol];
                    if (Character.isDigit(temp)){
                        int value = Character.getNumericValue(temp);
                        sum = sum + value;

                        startRow = startRow+1;
                        matrix[startRow][startCol] ='S';
                        if (sum >= 50){
                            break;
                        }
                    }
                    else if (temp == '-'){
                        startRow = startRow+1;
                        matrix[startRow][startCol] ='S';
                      //  command = scanner.nextLine();
                     //   continue;
                    }
                    else if (temp =='O'){
                        matrix[startRow+1][startCol] = '-';
                        for (int i = 0; i < number; i++) {
                            for (int j = 0; j < number; j++) {
                                if (matrix[i][j] == 'O'){
                                    startRow = i;
                                    startCol = j;
                                    matrix[i][j] = 'S';
                                }
                            }
                        }
                    }
                    }
                }
            command = scanner.nextLine();
            }

        if (sum >= 50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        else {
            System.out.println("Bad news, you are out of the bakery.");
        }
        System.out.println("Money: " + sum);
        printMatrix(matrix, number);

    }
    public static void printMatrix(char [][] matrix, int number){
        for (int row = 0; row < number; row++) {
            for (int col = 0; col < number; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
