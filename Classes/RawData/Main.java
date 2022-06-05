package Classes.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> fragile = new ArrayList<>();
        List<Car> flamable = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String text  = scanner.nextLine();
            String [] token = text.split(" ");
            Car car = null;

            String model = token[0];
            int engineSpeed = Integer.parseInt(token[1]);
            int enginePower = Integer.parseInt(token[2]);
            int cargoWeight = Integer.parseInt(token[3]);
            String cargoType = token[4];
            double typePressure1 = Double.parseDouble(token[5]);
            int age1 = Integer.parseInt(token[6]);
            double typePressure2 = Double.parseDouble(token[7]);
            int age2 = Integer.parseInt(token[8]);
            double typePressure3 = Double.parseDouble(token[9]);
            int age3 = Integer.parseInt(token[10]);
            double typePressure4 = Double.parseDouble(token[11]);
            int age4 = Integer.parseInt(token[12]);

            car = new Car(model,engineSpeed,enginePower,cargoWeight,cargoType,typePressure1,age1,typePressure2,age2,typePressure3,age3,typePressure4,age4);
            if (cargoType.equals("fragile")){
                if ((typePressure1 < 1) || (typePressure2 < 1) || (typePressure3 < 1) || (typePressure4 < 1)) {
                    fragile.add(car);
                }
            }
            else if (cargoType.equals("flamable")){
                if (enginePower > 250) {
                    flamable.add(car);
                }
            }
        }

        String text = scanner.nextLine();
        if (text.equals("fragile")){
            for (Car car : fragile) {
                System.out.println(car);
            }
        }
        else if (text.equals("flamable")){
            for (Car car : flamable) {
                System.out.println(car);
            }
        }
    }
}
