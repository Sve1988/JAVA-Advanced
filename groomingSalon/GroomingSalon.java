package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if (data.size() < capacity){
            data.add(pet);
        }
    }

    public boolean remove(String name){
        int index = -1;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)){
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

    public Pet getPet(String name, String owner){
        Pet pet = null;
        for (Pet datum : data) {
            if (datum.getName().equals(name)&&datum.getOwner().equals(owner)){
                pet = datum;
            }
        }
        return pet;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:");
        sb.append(System.lineSeparator());
        for (Pet datum : data) {
            sb.append(datum.getName());
            sb.append(" ");
            sb.append(datum.getOwner());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }



}
