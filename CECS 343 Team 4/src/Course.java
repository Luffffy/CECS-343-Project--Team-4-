
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chealyTahir
 */
public class Course {
    private String courseName;
    private int courseID;
    private int courseUnits;
    

    
    ArrayList<Course> preReq = new ArrayList();
    
    public Course() {
        
    }
    public Course(String courseName, int courseID, Employee prof) {
        this.courseName = courseName;
        this.courseID = courseID;
        
    }

    
    public void setCourseName (String courseName ) {
        this.courseName = courseName;
    }
    
    public String getCourseName () {
        return this.courseName;
    }
    
    public void setCourseID(int courseID){
        this.courseID = courseID;
    }
    
    public int getCourseID (){
        return this.courseID;
    }
    
    public void setCourseUnits(int courseUnits) {
        this.courseUnits = courseUnits;
    }
    
    public int getCourseUnits(){
        return this.courseUnits;
    }
    
    public void addPrereqCourse (Course prerequisiteCourse) {
        preReq.add(prerequisiteCourse);
    }
    
    public ArrayList getPrerequisiteCourseList() {
        return preReq;
    }
    public boolean courseHasPrerequisite () {
        if (!preReq.isEmpty())
            return true;
        return false;
    }
    
    
}
