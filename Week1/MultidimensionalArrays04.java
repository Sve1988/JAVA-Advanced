package Week1;

import java.util.Scanner;

public class MultidimensionalArrays04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int [][] matrix = new int[rows][cols];
        fillMatrix(scanner, matrix, rows,cols);

        int max = 0;
        int[][] temp = new int [3][3];

        for (int row = 0; row <= rows - 3; row++) {
            int sum = 0;
            for (int col = 0; col <= cols - 3; col++) {
                sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] + matrix[row + 2][col] + matrix[row+2][col+1] + matrix[row+2][col+2];
                if (sum > max){
                    max = sum;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            temp[i][j] = matrix[row+i][col+j];
                        }
                    }
                }
            }

        }
        System.out.println("Sum = " + max);
        printMatrix(temp,3, 3);
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }

    //print matrix
    public static void printMatrix(int [][] matrix, int rows, int cols){
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
