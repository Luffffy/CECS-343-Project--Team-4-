
import java.util.Date;

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
    
    private int profID; 
    private int day;
    private Building building;
    private Room room;
    private int units;
    private boolean semester; //true spring, false fall
    private Date startTime;
    private Date endTime;
    private Course course;
    
    //arraylists of students if this is empty then we can remove
   
    public Session(int profID, int day, boolean semester, int units, Building building, Room room, Date startTime, Date endTime, Course course)
    {
        this.profID = profID;
        this.day = day;
        this.semester = semester;
        this.units = units;
        this.building = building;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
        this.course = course;
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
    
    public void setTime(Date s, Date e)
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
        return getDayName() + " " + getTimeName();
    }
    
    public boolean getSemester() {
        return semester;
    }
    
    public Course getCourse() {
        return course;
    }
}
