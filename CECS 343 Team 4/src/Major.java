import java.util.*;
import java.util.ArrayList;
import static java.util.Collections.list;

public class Major {
    private String majorName;
    ArrayList<Course> courses = new ArrayList();
    
    public Major(String majorName) {
        this.majorName = majorName;
    }

    public boolean isEmpty() {
        return courses.isEmpty();
    }
    public void addCourse(Course course) {
        courses.add(course);
    }
    
    public void removeCourse(Course course) {
        courses.remove(course);
    }
    
    public ArrayList<Course> getCourseList() {
        return courses;
    }
    
    public String getCourses() {
        if(courses.isEmpty()) {
            return "No Courses";
        } else {
            String s = "";
            for(Course course: courses){
                s += course.getCourseName() + "\n";
            }
            return s;
        }
    }
    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String name) {
        majorName = name;
    }
}
