import java.util.*;
import java.util.ArrayList;
import static java.util.Collections.list;

/**
 *
 * @author
 */
public class Student {
    private String studentName;
    private int studentID;
    private String semester;
    private String major;
    private int totalUnits = 0;
    private int tuition = 0; 
    
    ArrayList<String> takenCourse_Arraylist = new ArrayList();
    ArrayList<String> course_Arraylist = new ArrayList();
       
    public Student () {
        
    }
    public Student (String studentName, int studentID) {
        this.studentName = studentName;
        this.studentID = studentID;
    }  
    public void setStudentName(String name) {
        studentName = name;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentID(int ID) {
        studentID = ID;
    }
    public int getStudentID () {
        return studentID;
    }
    public void selectMajof(String major) {
        this.major = major;
    }
    public String getMajor (int studentID) {
        return major;
    }
    public void payTuition(int tuitionFee) {
        tuition = tuitionFee;
    }
    public boolean IsPayTuition() {
        if (tuition == 0)
            return false;
        return true;
    }
    public void setSemester (String semester) {
        this.semester = semester;
    }
    public void addTakenCourse(String takenCourseName) {
        takenCourse_Arraylist.add(takenCourseName);
    }
    public ArrayList getCourseHistory() {
        return takenCourse_Arraylist;
    }
    public void addCourse(String courseName, int courseUnits) {
        course_Arraylist.add(courseName);
        totalUnits = totalUnits + courseUnits;
    }    
    public ArrayList getCourseList() {
        return course_Arraylist;
    }
    public int studentTotalUnits() {
        return totalUnits;
    }
    public ArrayList takenCoursesList() {
        
        return takenCourse_Arraylist;
    }
    public void printTakenCoursesList() {
        for (String takenCourse : takenCourse_Arraylist) {
            System.out.print(takenCourse + " ");
        }
        System.out.println();
    }
    public void studentProfile() {
        System.out.println(studentName + " ID:" + studentID);
        System.out.print("Register courses:");
        for (String course : course_Arraylist) {
            System.out.print(course + " ");
        }
    }
}
