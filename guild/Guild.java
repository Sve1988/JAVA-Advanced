package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addPlayer(Player player){
        if (roster.size() < capacity){
            roster.add(player);
        }
    }

    public boolean removePlayer(String name){
        int index = -1;
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getName().equals(name)){
                index = i;
            }
        }

        if (index != -1){
            roster.remove(index);
            return true;
        }
        else {
            return false;
        }
    }

    public void promotePlayer(String name){
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getName().equals(name)){
                roster.get(i).setRank("Member");
                break;
            }
        }
    }

    public void demotePlayer(String name){
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getName().equals(name)){
                roster.get(i).setRank("Trial");
                break;
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz){
        int count = 0;
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)){
                count++;
            }
        }

        Player[] arr = new Player[count];
        int index = 0;

        for (Player player : roster) {
            if (player.getClazz().equals(clazz)){
                arr[index++] = player;
            }
        }

        for (Player player : arr) {
            roster.remove(player);
        }
        return arr;
    }

    public int count(){
        return roster.size();
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Players in the guild: ");
        sb.append(name);
        sb.append(":");
        sb.append(System.lineSeparator());
        for (Player player : roster) {
            sb.append(player.toString());
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

}
