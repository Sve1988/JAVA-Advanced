package Exams;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int food = 0;
        int size = Integer.parseInt(scanner.nextLine());
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

        String command = scanner.nextLine();

        while (food < 10) {
            if (command.equals("right")) {
                matrix[startRow][startCol] = '.';
                if (startCol == size - 1) {
                    System.out.println("Game over!");
                    break;
                } else {
                    if (matrix[startRow][startCol + 1] == '*') {
                        food++;
                        startCol = startCol + 1;
                        matrix[startRow][startCol] = 'S';
                        if (food == 10){
                            break;
                        }
                    } else if (matrix[startRow][startCol + 1] == '-') {
                        startCol = startCol + 1;
                        matrix[startRow][startCol] = 'S';
                    } else if (matrix[startRow][startCol + 1] == 'B') {
                        matrix[startRow][startCol + 1] = '.';
                        for (int i = 0; i < size; i++) {
                            for (int j = 0; j < size; j++) {
                                if (matrix[i][j] == 'B') {
                                    startRow = i;
                                    startCol = j;
                                    matrix[i][j] = 'S';
                                    break;
                                }
                            }
                        }
                    }
                }
            } else if (command.equals("left")) {
                matrix[startRow][startCol] = '.';
                if (startCol == 0) {
                    System.out.println("Game over!");
                    break;
                } else {
                    if (matrix[startRow][startCol - 1] == '*') {
                        food++;
                        startCol = startCol - 1;
                        matrix[startRow][startCol] = 'S';
                        if (food == 10){
                            break;
                        }
                    } else if (matrix[startRow][startCol - 1] == '-') {
                        startCol = startCol - 1;
                        matrix[startRow][startCol] = 'S';
                    } else if (matrix[startRow][startCol - 1] == 'B') {
                        matrix[startRow][startCol - 1] = '.';
                        for (int i = 0; i < size; i++) {
                            for (int j = 0; j < size; j++) {
                                if (matrix[i][j] == 'B') {
                                    startRow = i;
                                    startCol = j;
                                    matrix[i][j] = 'S';
                                    break;
                                }
                            }
                        }
                    }
                }
            } else if (command.equals("up")) {
                matrix[startRow][startCol] = '.';
                if (startRow == 0) {
                    System.out.println("Game over!");
                    break;
                } else {
                    if (matrix[startRow - 1][startCol] == '*') {
                        food++;
                        startRow = startRow - 1;
                        matrix[startRow][startCol] = 'S';
                        if (food == 10){
                            break;
                        }
                    } else if (matrix[startRow - 1][startCol] == '-') {
                        startRow = startRow - 1;
                        matrix[startRow][startCol] = 'S';
                    } else if (matrix[startRow - 1][startCol] == 'B') {
                        matrix[startRow - 1][startCol] = '.';
                        for (int i = 0; i < size; i++) {
                            for (int j = 0; j < size; j++) {
                                if (matrix[i][j] == 'B') {
                                    startRow = i;
                                    startCol = j;
                                    matrix[i][j] = 'S';
                                    break;
                                }
                            }
                        }
                    }
                }
            } else if (command.equals("down")) {
                matrix[startRow][startCol] = '.';
                if (startRow == size - 1) {
                    System.out.println("Game over!");
                    break;
                } else {
                    if (matrix[startRow + 1][startCol] == '*') {
                        food++;
                        startRow = startRow + 1;
                        matrix[startRow][startCol] = 'S';
                        if (food == 10){
                            break;
                        }
                    } else if (matrix[startRow + 1][startCol] == '-') {
                        startRow = startRow + 1;
                        matrix[startRow + 1][startCol] = 'S';
                    } else if (matrix[startRow + 1][startCol] == 'B') {
                        matrix[startRow + 1][startCol] = '.';
                        for (int i = 0; i < size; i++) {
                            for (int j = 0; j < size; j++) {
                                if (matrix[i][j] == 'B') {
                                    startRow = i;
                                    startCol = j;
                                    matrix[i][j] = 'S';
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            command = scanner.nextLine();
        }

        if (food >= 10) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d%n", food);
        printMatrix(matrix, size);

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
