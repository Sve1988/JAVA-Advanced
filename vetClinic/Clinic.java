package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
        Pet pet = new Pet();

        for (Pet datum : data) {
            if ((datum.getName().equals(name)) && (datum.getOwner().equals(owner))){
                pet = datum;
                return pet;
            }
            else {
                pet = null;
            }
        }
        return pet;
    }

    public Pet getOldestPet(){
        Pet pet = new Pet();
        int age = -1;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getAge() > age){
                age = data.get(i).getAge();
                pet = data.get(i);
            }
        }
        return pet;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:");
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
