package Exams;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int commands = Integer.parseInt(scanner.nextLine());
        int startRow = 0;
        int startCol = 0;
        boolean flag = false;
        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            String text = scanner.nextLine();
            for (int j = 0; j < text.length(); j++) {
                char symbol = text.charAt(j);
                matrix[i][j] = symbol;
                if (symbol == 'f') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        for (int i = 0; i < commands; i++) {
            String text = scanner.nextLine();
            if (text.equals("right")){
                if (startCol == size - 1){
                    matrix[startRow][startCol] = '-';
                    if (matrix[startRow][0] == 'F'){
                        matrix[startRow][0] = 'f';
                        System.out.println("Player won!");
                        flag = true;
                        break;
                    }
                    else if (matrix[startRow][0] == 'B'){
                        startCol = 1;
                        matrix[startRow][1] = 'f';
                    }
                    else if (matrix[startRow][0] =='T'){
                        matrix[startRow][startCol] = 'f';
                    }
                    else if (matrix[startRow][startCol] == '-'){
                        startCol = 0;
                        matrix[startRow][0] ='f';
                    }
                }
                else {
                    matrix[startRow][startCol] = '-';
                    if (matrix[startRow][startCol+1] == 'F'){
                        matrix[startRow][startCol+1] = 'f';
                        System.out.println("Player won!");
                        flag = true;
                        break;
                    }
                    else if (matrix[startRow][startCol+1] == 'B'){
                        if (startCol+2 > size-1){
                            startCol = 0;
                            matrix[startRow][startCol] = 'f';
                        }
                        else {
                            startCol = startCol + 2;
                            matrix[startRow][startCol] = 'f';
                        }
                    }
                    else if (matrix[startRow][startCol+1] == 'T'){
                        matrix[startRow][startCol] = 'f';
                    }
                    else if (matrix[startRow][startCol+1] == '-'){
                        startCol = startCol+1;
                        matrix[startRow][startCol] ='f';
                    }
                }
            }
            else if (text.equals("left")){
                if (startCol == 0){
                    matrix[startRow][0] = '-';
                    if (matrix[startRow][size-1] == 'F'){
                        matrix[startRow][size-1] = 'f';
                        System.out.println("Player won!");
                        flag = true;
                        break;
                    }
                    else if (matrix[startRow][size-1] == 'B'){
                        startCol = size -2;
                        matrix[startRow][size-2] = 'f';
                    }
                    else if (matrix[startRow][size-1] =='T'){
                        matrix[startRow][0] = 'f';
                    }
                    else if (matrix[startRow][size-1] == '-'){
                        startCol = size-1;
                        matrix[startRow][size-1] ='f';
                    }
                }
                else {
                    matrix[startRow][startCol] = '-';
                    if (matrix[startRow][startCol-1] == 'F'){
                        matrix[startRow][startCol-1] = 'f';
                        System.out.println("Player won!");
                        flag = true;
                        break;
                    }
                    else if (matrix[startRow][startCol-1] == 'B'){
                        if (startCol-2 < 0){
                            startCol = size-1;
                            if (matrix[startRow][startCol] =='F'){
                                matrix[startRow][startCol] ='f';
                                System.out.println("Player won!");
                                flag = true;
                                break;
                            }
                            matrix[startRow][startCol]='f';
                        }
                        else {
                            startCol = startCol-2;
                            matrix[startRow][startCol] = 'f';
                        }
                    }
                    else if (matrix[startRow][startCol-1] == 'T'){
                        matrix[startRow][startCol] = 'f';
                    }
                    else if (matrix[startRow][startCol-1] == '-'){
                        startCol = startCol-1;
                        matrix[startRow][startCol] ='f';
                    }
                }
            }
            else if (text.equals("up")){
                if (startRow == 0){
                    matrix[0][startCol] = '-';
                    if (matrix[size-1][startCol] == 'F'){
                        matrix[size-1][startCol] = 'f';
                        System.out.println("Player won!");
                        flag = true;
                        break;
                    }
                    else if (matrix[size-1][startCol] == 'B'){
                        startRow = startRow-2;
                        matrix[startRow][startCol] = 'f';
                    }
                    else if (matrix[size-1][startCol] =='T'){
                        matrix[startRow][startCol] = 'f';
                    }
                    else if (matrix[size-1][startCol] == '-'){
                        startRow = size-1;
                        matrix[size-1][startCol] ='f';
                    }
                }
                else {
                    matrix[startRow][startCol] = '-';
                    if (matrix[startRow-1][startCol] == 'F'){
                        matrix[startRow-1][startCol] = 'f';
                        System.out.println("Player won!");
                        flag = true;
                        break;
                    }
                    else if (matrix[startRow-1][startCol] == 'B'){
                        if (startRow-2 < 0){
                            startRow = size - 1;
                            matrix[startRow][startCol]='f';
                        }
                        else {
                            startRow = startRow-2;
                            matrix[startRow-2][startCol] = 'f';
                        }

                    }
                    else if (matrix[startRow-1][startCol] == 'T'){
                        matrix[startRow][startCol] = 'f';
                    }
                    else if (matrix[startRow-1][startCol] == '-'){
                        startRow = startRow-1;
                        matrix[startRow][startCol] ='f';
                    }
                }
            }
            else if (text.equals("down")){
                if (startRow == size - 1){
                    matrix[startRow][startCol] = '-';
                    if (matrix[0][startCol] == 'F'){
                        matrix[0][startCol] = 'f';
                        System.out.println("Player won!");
                        flag = true;
                        break;
                    }
                    else if (matrix[0][startCol] == 'B'){
                        startRow=1;
                        matrix[1][startCol] = 'f';
                    }
                    else if (matrix[0][startCol] =='T'){
                        matrix[startRow][startCol] = 'f';
                    }
                    else if (matrix[0][startCol] == '-'){
                        startRow=0;
                        matrix[0][startCol] ='f';
                    }
                }
                else {
                    matrix[startRow][startCol] = '-';
                    if (matrix[startRow+1][startCol] == 'F'){
                        matrix[startRow+1][startCol] = 'f';
                        System.out.println("Player won!");
                        flag = true;
                        break;
                    }
                    else if (matrix[startRow+1][startCol] == 'B'){
                        if (startRow +2 > size-1){
                            startRow = 0;
                            matrix[startRow][startCol] = 'f';
                        }
                        else {
                            startRow = startRow+2;
                            matrix[startRow][startCol] = 'f';
                        }

                    }
                    else if (matrix[startRow+1][startCol] == 'T'){
                        matrix[startRow][startCol] = 'f';
                    }
                    else if (matrix[startRow+1][startCol] == '-'){
                        startRow = startRow+1;
                        matrix[startRow][startCol] ='f';
                    }
                }
            }
        }
        if (!flag){
            System.out.println("Player lost!");
        }
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
