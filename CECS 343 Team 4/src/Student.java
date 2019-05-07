import java.util.*;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.time.*;
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
    
    ArrayList<Pair> takenCourses = new ArrayList();
    ArrayList<Session> sessions = new ArrayList();
       
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

    public void addTakenCourse(Session s, char g) { //use this to assign grades, all courses taken should have grades 
        
        Course c = s.getCourse();
        takenCourses.add(new Pair(c, g));
        removeSession(s);
    }
    
    public void removeTakenCourse(Course c) {
        for(Pair pair: takenCourses) {
            if(pair.getCourse() == c) {
                takenCourses.remove(pair);
            }
        }
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
    }
    
    public ArrayList getSessionList() {
        return sessions;
    }
    

    
    public int studentTotalUnits() {
        return totalUnits;
    }
    
    public ArrayList getTakenCoursesList() {
        
        return takenCourses;
    }
    
    public void printTakenCoursesList() {
        int size = takenCourses.size();
        for (int i = 0; i < size; i++) {
            System.out.print(takenCourses.get(i).getCourse().getCourseName() + ": " + takenCourses.get(i).getGrade() +  " | ");
        }
        System.out.println();
    }
    
    public void studentProfile() {
        System.out.println("Name: " + studentName + " ID:" + studentID);
        System.out.println("Major: " + major);
        System.out.println("Register courses:");
        
        if(!sessions.isEmpty())
        {
            int size = sessions.size();
            for (int i = 0; i < size; i++) {
                System.out.print(sessions.get(i).getCourse().getCourseName() + " | ");
            }
        }
        else
        {
            System.out.println("None");
        }
        System.out.println();
        
    }
    
    public boolean isEmpty()
    {
        return sessions.isEmpty();
    }
    
    public String toString()
    {
        return "Name: " + studentName + " ID: " + studentID;
    }
    
    public String getSessions() {
        if(sessions.isEmpty()) {
            return "No Sessions";
        } else {
            String s = "";
            for(Session session: sessions){
                s += session.getSessionNumber() + " " + session.getSemesterString() 
                        + " " + session.getDayName() + " " + session.getStartTime() + " - " + session.getEndTime() + "\n";
            }
            return s;
        }
    }
}
