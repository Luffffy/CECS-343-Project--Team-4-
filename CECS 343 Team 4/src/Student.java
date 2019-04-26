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
    private String major;
    private int totalUnits = 0;
    private boolean paidTuition;
    
    ArrayList<Course> takenCourses = new ArrayList();
    ArrayList<Course> courses = new ArrayList();
       
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
    public void changeMajor(String major) {
        this.major = major;
    }
    public String getMajor (int studentID) {
        return major;
    }
    
    public boolean getPaid()
    {
        return paidTuition;
    }

    public void addTakenCourse(Course takenCourse) {
        takenCourses.add(takenCourse);
    }
    
    public void setTuition(boolean paid)
    {
        this.paidTuition = paid;
    }
    public ArrayList getCourseHistory() {
        return takenCourses;
    }
    
    public void addCourse(Course c) {
        courses.add(c);
        totalUnits += c.getCourseUnits();
    }    
    
    public ArrayList getCourseList() {
        return courses;
    }
    
    public int studentTotalUnits() {
        return totalUnits;
    }
    
    public ArrayList takenCoursesList() {
        
        return takenCourses;
    }
    
    public void printTakenCoursesList() {
        int size = takenCourses.size();
        for (int i = 0; i < size; i++) {
            System.out.print(takenCourses.get(i).getCourseName() + " | ");
        }
        System.out.println();
    }
    public void studentProfile() {
        System.out.println(studentName + " ID:" + studentID);
        System.out.print("Register courses:");
        int size = courses.size();
        for (int i = 0; i < size; i++) {
            System.out.print(courses.get(i).getCourseName() + " | ");
        }
    }
}
