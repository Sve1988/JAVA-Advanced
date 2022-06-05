package Exams;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int flower = 0;
        int startRow = 0;
        int startCol = 0;
        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            String text = scanner.nextLine();
            for (int j = 0; j < text.length(); j++) {
                char symbol = text.charAt(j);
                matrix[i][j] = symbol;
                if (symbol == 'B') {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("End")){
            if (command.equals("right")){
                matrix[startRow][startCol] = '.';
                if (startCol == size-1){
                    System.out.println("The bee got lost!");
                    break;
                }
                else {
                    if (matrix[startRow][startCol+1] =='f'){
                        flower++;
                        startCol = startCol+1;
                        matrix[startRow][startCol] ='B';
                    }
                    else if (matrix[startRow][startCol+1] == '.'){
                        startCol = startCol + 1;
                        matrix[startRow][startCol] ='B';
                      //  command = scanner.nextLine();
                      //  continue;
                    }
                    else if (matrix[startRow][startCol+1] == 'O'){
                        matrix[startRow][startCol+1] ='.';
                        startCol = startCol + 2;
                            if (matrix[startRow][startCol] =='f'){
                                flower++;
                            }
                            matrix[startRow][startCol] = 'B';
                    }
                }
            }

            else if (command.equals("left")){
                matrix[startRow][startCol] = '.';
                if (startCol == 0){
                    System.out.println("The bee got lost!");
                    break;
                }
                else {
                    char temp = matrix[startRow][startCol-1];
                    if (matrix[startRow][startCol-1] =='f'){
                        flower++;
                        startCol = startCol-1;
                        matrix[startRow][startCol] ='B';
                    }
                    else if (matrix[startRow][startCol-1] == '.'){
                        startCol = startCol - 1;
                        matrix[startRow][startCol] ='B';
                       // command = scanner.nextLine();
                     //   continue;
                    }
                    else if (matrix[startRow][startCol-1] == 'O'){
                        matrix[startRow][startCol-1] ='.';
                        startCol = startCol - 2;
                            if (matrix[startRow][startCol] =='f'){
                                flower++;
                            }
                            matrix[startRow][startCol] = 'B';

                    }
                }
            }

            else if (command.equals("up")){
                matrix[startRow][startCol] = '.';
                if (startRow == 0){
                    System.out.println("The bee got lost!");
                    break;
                }
                else {
                    char temp = matrix[startRow-1][startCol];
                    if (matrix[startRow-1][startCol] =='f'){
                        flower++;
                        startRow = startRow-1;
                        matrix[startRow][startCol] ='B';
                    }
                    else if (matrix[startRow-1][startCol] == '.'){
                        startRow = startRow - 1;
                        matrix[startRow][startCol] ='B';
                     //   command = scanner.nextLine();
                      //  continue;
                    }
                    else if (matrix[startRow-1][startCol] == 'O'){
                        matrix[startRow-1][startCol] ='.';
                            startRow = startRow - 2;
                            if (matrix[startRow][startCol] =='f'){
                                flower++;
                            }

                            matrix[startRow][startCol] = 'B';

                    }
                }
            }

            else if (command.equals("down")){
                matrix[startRow][startCol] = '.';
                if (startRow == size-1){
                    System.out.println("The bee got lost!");
                    break;
                }
                else {
                    char temp = matrix[startRow+1][startCol];
                    if (matrix[startRow+1][startCol] =='f'){
                        flower++;
                        startRow = startRow+1;
                        matrix[startRow][startCol] ='B';
                    }
                    else if (matrix[startRow+1][startCol] == '.'){
                        startRow = startRow + 1;
                        matrix[startRow][startCol] ='B';
                      //  command = scanner.nextLine();
                      //  continue;
                    }
                    else if (matrix[startRow+1][startCol] == 'O'){
                        matrix[startRow+1][startCol] ='.';

                            startRow = startRow + 2;
                            if (matrix[startRow][startCol] =='f'){
                                flower++;
                            }

                            matrix[startRow][startCol] = 'B';

                    }
                }
            }

            command = scanner.nextLine();
        }

        if (flower >= 5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flower);
        }
        else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 -flower);
        }

        printMatrix(matrix,size);
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
