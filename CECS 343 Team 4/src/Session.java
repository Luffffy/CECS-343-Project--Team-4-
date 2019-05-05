import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Judy
 */
public class Session {
    
    private String sessionNumber;
    private int profID; 
    private int day;
    private Building building;
    private Room room;
    private int units;
    private boolean semester; //true spring, false fall
    private LocalTime startTime;
    private LocalTime endTime;
    private Course course;
    private ArrayList <Student> students = new ArrayList();
    //arraylists of students if this is empty then we can remove
   
    public Session(String sessionNumber, int profID, int day, boolean semester, Building building, 
            Room room, LocalTime startTime, LocalTime endTime, Course course)
    {
        this.sessionNumber = sessionNumber;
        this.profID = profID;
        this.day = day;
        this.semester = semester;
        this.units = course.getCourseUnits();
        this.building = building;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
        this.course = course;
    }
    
    public String getSessionNumber()
    {
        return sessionNumber;
    }
    
    public int getProf()
    {
        return profID;
    }
    
    public Building getBuilding()
    {
        return building;
    }
    
    public Room getRoom()
    {
        return room;
    }
    
    public int getUnits()
    {
        return units;
    }
    
    public LocalTime getStartTime()
    {
        return startTime;
    }
    
    public LocalTime getEndTime()
    {
        return endTime;
    }
    
    public int getDay()
    {
        return day;
    }
    
    public void setSessionNumber(String s)
    {
        sessionNumber = s;
    }
    
    public void setProf(int pid)
    {
        profID = pid;
    }
    
    public void setBuilding(Building b)
    {
        building = b;
    }
    
    public void setRoom(Room r)
    {
        room = r;
    }
    
    public void setDay(int d)
    {
        day = d;
    }
    
    public void setTime(LocalTime s, LocalTime e)
    {
        startTime= s;
        endTime = e;
    }
    
    public String getBuildingName()
    {
        return building.toString();
    }
    
    public String getRoomName()
    {
        return room.toString();
    }
  
    public String getLocation()
    {
        return getBuildingName() + " " + getRoomName();
    }
    
    public String getDayName(){
        
        switch (day) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                break;
        }
        
        return "";
    }

    public String getTimeName() {        
        return startTime.toString() + " - " + endTime.toString();
    }
    
    public String toString(){
        return getDayName() + ", " + getTimeName();
    }
    
    public boolean getSemester() {
        return semester;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public boolean isEmpty() {
        return students.isEmpty();
    }
    
    public void addStudent(Student s) {
        students.add(s);
    }
    
    public void removeSession(Student s) {
        students.remove(s);
    }
    
    public ArrayList<Student> getStudentList() {
        return students;
    }
}

