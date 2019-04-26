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
    private boolean paidTuition;
    
    ArrayList<Course> takenCourse_Arraylist = new ArrayList();
    ArrayList<Course> course_Arraylist = new ArrayList();
       
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
    public void selectMajor(String major) {
        this.major = major;
    }
    public String getMajor (int studentID) {
        return major;
    }
    
    public boolean getPaid()
    {
        return paidTuition;
    }
    
    public void setSemester (String semester) {
        this.semester = semester;
    }
    public void addTakenCourse(Course takenCourse) {
        takenCourse_Arraylist.add(takenCourse);
    }
    
    public void setTuition(boolean paid)
    {
        this.paidTuition = paid;
    }
    public ArrayList getCourseHistory() {
        return takenCourse_Arraylist;
    }
    public void addCourse(Course c) {
        course_Arraylist.add(c);
        totalUnits += c.getCourseUnits();
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
        int size = takenCourse_Arraylist.size();
        for (int i = 0; i < size; i++) {
            System.out.print(takenCourse_Arraylist.get(i).getCourseName() + " | ");
        }
        System.out.println();
    }
    public void studentProfile() {
        System.out.println(studentName + " ID:" + studentID);
        System.out.print("Register courses:");
        int size = course_Arraylist.size();
        for (int i = 0; i < size; i++) {
            System.out.print(course_Arraylist.get(i).getCourseName() + " | ");
        }
    }
}
