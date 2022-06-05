package StudentSystem;

public class Student {
    private String name;
    private int years;
    private double grade;

    public Student(String name, int years, double grade) {
        this.name = name;
        this.years = years;
        this.grade = grade;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        String text = String.format("%s is %d years old.", name,years);
        return text + avGrade();
    }

    private String avGrade(){
        String result = " Very nice person.";
        if (this.getGrade() >= 5.00) {
            result = " Excellent student.";
        } else if (this.getGrade() < 5.00 && this.getGrade() >= 3.50) {
            result = " Average student.";
        }
        return result;
    }
}
