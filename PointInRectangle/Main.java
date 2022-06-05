package PointInRectangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String[] token = text.split(" ");
        Point first = new Point(Integer.parseInt(token[0]), Integer.parseInt(token[1]));
        Point second = new Point(Integer.parseInt(token[2]), Integer.parseInt(token[3]));

        Rectangle rectangle = new Rectangle(first, second);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            String text1 = scanner.nextLine();
            String[] tokens = text1.split(" ");
            int hor = Integer.parseInt(tokens[0]);
            int ver = Integer.parseInt(tokens[1]);

            Point point = new Point(hor,ver);
            System.out.println(rectangle.contains(point));
        }

    }
}
