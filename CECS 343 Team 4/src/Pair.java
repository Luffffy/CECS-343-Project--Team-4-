
public class Pair {
    private Course course;
    private char grade;
    
    public Pair(Course c, char g) {
        course = c;
        grade = g;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public void setCourse(Course c) {
        course = c;
    }
    
    public char getGrade() {
        return grade;
    }
    
    public void setGrade(char g) {
        grade = g;
    }
}
