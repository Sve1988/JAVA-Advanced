package Exams;

import java.util.Scanner;

public class BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int size = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder(text);
        char[][] matrix = new char[size][size];
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < size; i++) {
            String text1 = scanner.nextLine();
            for (int j = 0; j < text1.length(); j++) {
                char symbol = text1.charAt(j);
                matrix[i][j] = symbol;
                if (symbol == 'P') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        String command  = scanner.nextLine();
        while(!command.equals("end")){
            if (command.equals("right")){
                if (startCol == size - 1){
                    if (sb.length() == 0){
                        break;
                    }
                    else {
                        sb.deleteCharAt(sb.length()-1);
                        break;
                    }
                }
                else {
                    matrix[startRow][startCol] ='-';
                    char temp = matrix[startRow][startCol+1];
                    if (Character.isLetter(temp)){
                        sb.append(temp);
                        startCol = startCol+1;
                        matrix[startRow][startCol] = 'P';
                    }
                    else if (temp =='-'){
                        startCol = startCol+1;
                        matrix[startRow][startCol] = 'P';
                    }
                }
            }
            else if (command.equals("left")){
                if (startCol == 0){
                    if (sb.length() == 0){
                        break;
                    }
                    else {
                        sb.deleteCharAt(sb.length()-1);
                        break;
                    }
                }
                else {
                    matrix[startRow][startCol] ='-';
                    char temp = matrix[startRow][startCol-1];
                    if (Character.isLetter(temp)){
                        sb.append(temp);
                        startCol = startCol-1;
                        matrix[startRow][startCol] = 'P';
                    }
                    else if (temp =='-') {
                        startCol = startCol-1;
                        matrix[startRow][startCol] = 'P';
                    }
                }
            }
            else if (command.equals("up")){
                if (startRow == 0){
                    if (sb.length() == 0){
                        break;
                    }
                    else {
                        sb.deleteCharAt(sb.length()-1);
                        break;
                    }
                }
                else {
                    matrix[startRow][startCol] ='-';
                    char temp = matrix[startRow-1][startCol];
                    if (Character.isLetter(temp)){
                        sb.append(temp);
                        startRow = startRow-1;
                        matrix[startRow][startCol] = 'P';
                    }
                    else if (temp =='-') {
                        startRow = startRow-1;
                        matrix[startRow][startCol] = 'P';
                    }
                }
            }
            else if (command.equals("down")){
                if (startRow == size-1){
                    if (sb.length() == 0){
                        break;
                    }
                    else {
                        sb.deleteCharAt(sb.length()-1);
                        break;
                    }
                }
                else {
                    matrix[startRow][startCol] ='-';
                    char temp = matrix[startRow+1][startCol];
                    if (Character.isLetter(temp)){
                        sb.append(temp);
                        startRow = startRow+1;
                        matrix[startRow][startCol] = 'P';
                    }
                    else if (temp =='-') {
                        startRow = startRow+1;
                        matrix[startRow][startCol] = 'P';
                    }
                }
            }

            command = scanner.nextLine();
        }


        System.out.println(sb.toString());

        printMatrix(matrix,size);
    }

    public static void printMatrix(char[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
