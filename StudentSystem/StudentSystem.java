package StudentSystem;

import java.util.ArrayList;
import java.util.List;

public class StudentSystem {
    private List<Student> repository;

    public StudentSystem() {
        this.repository = new ArrayList<>();
    }

    public void add (Student student){
        repository.add(student);
    }

    public void show(String name){
        for (int i = 0; i < repository.size(); i++) {
            if (name.equals(repository.get(i).getName())){
                System.out.print(repository.get(i).getName()+" is " + repository.get(i).getYears() + " years old. ");

                if (repository.get(i).getGrade() >= 5.00) {
                    System.out.println("Excellent student.");
                } else if (repository.get(i).getGrade() < 5.00 && repository.get(i).getGrade() >= 3.50) {
                    System.out.println("Average student.");
                }
                else {
                    System.out.println("Very nice person.");
                }
            }
        }
    }


}
