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
    private String courseName;
    private int units;
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
    public void addCourse(String courseName) {
        course_Arraylist.add(courseName);
    }
    public int studentTotalUnits() {
        int count = 0;
        int totalUnits = 0;
        for (String course : course_Arraylist) {
           count++;
        } 
        totalUnits = 3 * count;
        return totalUnits;
    }
    public void printStudentCourses() {
        for (String course : course_Arraylist) {
            System.out.println(course + ": " + 3 + " units");
        }
    }
    public void studentProfile() {
        System.out.println(studentName + " ID:" + studentID);
        System.out.print("All course takent:");
        for (String course : course_Arraylist) {
            System.out.print(course + " ");
        }
    }
}
