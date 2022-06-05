package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        if (students.size() >= capacity) {
            System.out.println("No seats in the university");
        } else {
            boolean flag = false;
            for (Student student1 : students) {
                if (student1.equals(student)){
                    flag  =true;
                    break;
                }
            }
            if (flag){
                return "Student is already in the university";
            }
            else {
                students.add(student);
            }
        }
        return student.getFirstName() + " " + student.getLastName();
    }

    public String dismissStudent(Student student) {

        for (Student student1 : students) {

            if (student1.equals(student)) {
                String text = student1.getFirstName() + " " + student1.getLastName();
                students.remove(student1);
                return text;

            }

        }
        return "Student not found";
    }

    public Student getStudent(String firstName, String lastName) {
        Student st = new Student();
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                st = student;
            }
        }
        return st;
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < students.size(); i++) {
            sb.append("==Student: First Name = ");
            sb.append(students.get(i).getFirstName());
            sb.append(", Last Name = ");
            sb.append(students.get(i).getLastName());
            sb.append(", Best Subject = ");
            sb.append(students.get(i).getBestSubject());
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

}
