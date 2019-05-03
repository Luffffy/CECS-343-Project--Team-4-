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
    private boolean paidTuition = false;
    
    ArrayList<Course> takenCourses = new ArrayList();
    ArrayList<Session> sessions = new ArrayList();
       
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

    public void addTakenCourse(Course c) {
        takenCourses.add(c);
    }
    
    public void removeTakenCourse(Course c) {
        takenCourses.remove(c);
    }
    
    public void setTuition(boolean paid)
    {
        paidTuition = paid;
    }
//    public ArrayList getCourseHistory() {
//        return takenCourses;
//    }
    
    public void addSession(Session c) {
        sessions.add(c);
        totalUnits += c.getCourse().getCourseUnits();
    }    
    
    public void removeSession(Session s) {
        sessions.remove(s);
        totalUnits -= s.getCourse().getCourseUnits();
    }
    
    public ArrayList getSessionList() {
        return sessions;
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
        int size = sessions.size();
        for (int i = 0; i < size; i++) {
            System.out.print(sessions.get(i).getCourse().getCourseName() + " | ");
        }
    }
}
