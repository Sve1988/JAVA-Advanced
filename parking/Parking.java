package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if (data.size() < capacity){
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model){
        int index = -1;
        for (int i = 0; i < data.size(); i++) {
            if ((data.get(i).getManufacturer().equals(manufacturer)) && (data.get(i).getModel().equals(model))){
                index = i;
            }
        }

        if (index != -1){
            data.remove(index);
            return true;
        }
        else {
            return false;
        }
    }

    public Car getLatestCar(){
        if (data.isEmpty()){
            return null;
        }
        else {
            Car car = new Car();
            int year = -1;
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).getYear() > year) {
                    year = data.get(i).getYear();
                    car = data.get(i);
                }
            }
            return car;
        }
    }

    public Car getCar(String manufacturer, String model){
        Car car = new Car();
        int index = -1;
        for (int i = 0; i < data.size(); i++) {
            if ((data.get(i).getManufacturer().equals(manufacturer))&&(data.get(i).getModel().equals(model))){
                index = i;
                car = data.get(i);
            }
        }
        if (index != -1){
            return car;
        }
        else {
            return null;
        }
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are parked in ");
        sb.append(type);
        sb.append(":");
        sb.append(System.lineSeparator());
        for (Car datum : data) {
            sb.append(datum.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
