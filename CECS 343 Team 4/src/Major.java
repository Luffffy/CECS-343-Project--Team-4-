/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.util.ArrayList;
import static java.util.Collections.list;
/**
 *
 * @author chealyTahir
 */


public class Major {
    private String majorName;
    private String courseName;
    ArrayList<String> course_Arraylist = new ArrayList();
    
    public Major() {
        //this.majorName = null;
        //this.courseName = null;
    }

    public Major(String majorName) {
        this.majorName = majorName;
    }
    public Major (String majorName, String courseName) {
        this.majorName = majorName;
        this.courseName = courseName;
    }
    public String getMajorName() {
        return majorName;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setMajorName(String name) {
        majorName = name;
    }
    public void set_courseName(String name) {
        courseName = name;
    }
    public void add_MajorCourse(String courseName) {
        this.courseName = courseName; 
        course_Arraylist.add(this.courseName); 
    }
    public void remove_MajorCourse(String courseName) {
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
      if (course_Arraylist.isEmpty()){
          System.out.println("No course added to '" + majorName + "' major yet!");
      }
      else if (this.majorName == majorName) {
          for (String course : course_Arraylist) {
             System.out.print(course + " ");
          } 
        }
        else
            System.out.println("Wrong major name for the major Object");
        System.out.println();
    }
}
