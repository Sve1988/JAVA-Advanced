package Week1;

import java.util.Scanner;

public class MultidimensionalArrays05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] elements = text.split(" ");

        int rows = Integer.parseInt(elements[0]);
        int cols = Integer.parseInt(elements[1]);

        int [][] matrix = new int [rows][cols];
        fillMatrix(scanner, matrix, rows, cols);

        String command = scanner.nextLine();

        while(!command.equals("END")) {
            String[] token = command.split(" ");
            if (!token[0].equals("swap")){
                System.out.println("Invalid input!");
                continue;
            }
            if (token.length != 5){
                System.out.println("Invalid input!");
                continue;
            }
            int row1 = Integer.parseInt(token[1]);
            int col1 = Integer.parseInt(token[2]);
            int row2 = Integer.parseInt(token[3]);
            int col2 = Integer.parseInt(token[4]);

            if ((row1 >= 0 && row1 < rows) || (col1 >= 0 && col1 < cols) || (row2 >= 0 && row2 < rows) || (col2>= 0 && col2 < cols)){
                int temp1 = matrix[row1][col1];
                int temp2 = matrix[row2][col2];
                matrix[row1][col1] = temp2;
                matrix[row2][col2] = temp1;
                printMatrix(matrix, rows,cols);
            }
            else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }

       // printMatrix(matrix, rows, cols);
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        scanner.nextLine();
    }

    public static void printMatrix(int [][] matrix, int rows, int cols){
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
