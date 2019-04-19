/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package major;
import java.util.*;
import java.util.ArrayList;
import static java.util.Collections.list;
/**
 *
 * @author chealyTahir
 */


public class major {
    private String majorName;
    private String courseName;
    ArrayList<String> course_Arraylist = new ArrayList();
    ArrayList<String> preCourse_Arraylist = new ArrayList();
    public major(String majorName) {
        this.majorName = majorName;
    }
    public major (String majorName, String courseName) {
        this.majorName = majorName;
        this.courseName = courseName;
    }
    public String get_majorName() {
        return majorName;
    }
    public String get_courseName() {
        return courseName;
    }
    public void set_majorName(String name) {
        majorName = name;
    }
    public void set_courseName(String name) {
        courseName = name;
    }
    public void add_MajorCourse(String majorName, String courseName) {
        course_Arraylist.add(courseName); 
    }
    public void remove_MajorCourse(String majorName, String courseName) {
        int index = 0; 
        String variable;
        //Traversing list through for-each loop  
        for(String obj:course_Arraylist) { 
          variable = obj;
          if (variable == obj)
              course_Arraylist.remove(index);
          index++;
       }  
    }
    public void print_MajorCourses(String majorName) {
      // let us print all the elements available in list
      for (String course : course_Arraylist) {
         System.out.println(course);
      } 
    }
    public void print_PrereCourse(String majorName){
        // let us print all the elements available in list
        for (String prere_course : preCourse_Arraylist) {
           System.out.println(prere_course);
        }         
    }
}
