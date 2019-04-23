import java.util.*;
import java.util.ArrayList;
import static java.util.Collections.list;

/**
 *
 * @author chealyTahir
 */
public class prerequisiteCourse {
    private String courseName;
    
    ArrayList<String> arraylist = new ArrayList<>();
    
    public prerequisiteCourse(String courseName) {
        this.courseName = courseName;
    }
    //get the course that need the prerequisite course
    public String get_mainCourse() {
        return courseName;
    }
    public void add_prerequisiteCourse(String course) {
        arraylist.add(course);
    }
    public void print_prereCourses(String majorName) {
      // let us print all the elements available in list
      for (String preCourse: arraylist) {
         System.out.print(preCourse + " ");
      } 
      System.out.println();
    }
}
