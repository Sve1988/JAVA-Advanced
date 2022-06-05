package Week1;

import java.util.Scanner;

public class MultidimensionalArrays01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input  = scanner.nextLine();
        int size = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1];

        int[][] matrix = new int[size][size];

        if (pattern.equals("A")){
            fillPatternA(matrix, size);
        }
        else if (pattern.equals("B")){
            fillPatternB(matrix, size);
        }
        printMatrix(matrix, size, size);
    }

    private static void fillPatternB(int[][] matrix, int size) {
        int start = 1;
        for (int cols = 0; cols < size; cols++) {
            if (cols % 2 == 0){
                for (int rows = 0; rows < size; rows++) {
                    matrix[rows][cols] = start++;
                }
            }
            else {
                for (int rows = size-1; rows >= 0 ; rows--) {
                    matrix[rows][cols] = start++;
                }
            }
        }
    }

    private static void fillPatternA(int[][] matrix, int size) {
        int start = 1;
        for (int col = 0; col < size; col++) {
            for (int rows = 0; rows < size; rows++) {
                matrix[rows][col] = start++;
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
