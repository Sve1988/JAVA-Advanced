package Week1;

import java.util.Scanner;

public class MultidimensionalArrays02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String [][] matrix = new String[rows][cols];
        char start = 'a';
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String text = "" + start + (char)(start + j) + start;
                matrix[i][j] = text;
            }
            start = (char)(start + 1);
        }
        printMatrix(matrix, rows, cols);
    }

    //fill matrix
    private static void fillMatrix(Scanner scanner, int[][] matrix, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }

    //print matrix
    public static void printMatrix(String [][] matrix, int rows, int cols){
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
