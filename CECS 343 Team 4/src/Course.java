import java.util.ArrayList;
import java.util.Date;
import java.time.*;

public class Course {
    private String courseName;
    private int courseUnits;
    private ArrayList<Course> preReq = new ArrayList();
    private ArrayList <Session> sessions = new ArrayList();
    

    public Course(String courseName, int units) {
        this.courseName = courseName;
        courseUnits = units;
    }
    
    public void setCourseName (String courseName ) {
        this.courseName = courseName;
    }
    
    public String getCourseName () {
        return this.courseName;
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
    
    public void removePreReqCourse(Course c) {
        preReq.remove(c);
    }
    
    public ArrayList getPrerequisiteCourseList() {
        return preReq;
    }
    public boolean courseHasPrerequisite () {
        return !preReq.isEmpty();
    }
    
    public boolean isEmpty() {
        return sessions.isEmpty();
    }
    
    public void addSession(Session session) {
        sessions.add(session);
    }
    
    public void removeSession(Session session) {
        sessions.remove(session);
    }
    
    public ArrayList<Session> getSessionList() {
        return sessions;
    }
    
    public Session contains(String s) {
        Session temp = null;
        for(Session session : sessions) {
            if(session.getSessionNumber().equals(s)) {
                temp = session;
            }
        }
        return temp;
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
