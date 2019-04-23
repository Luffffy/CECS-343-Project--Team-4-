/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chealyTahir
 */
public class courseInfo {
    private String courseName;
    private int courseID;
    private int courseUnits;
    private String day;
    private String time;
    private String location;
    private String building;
    private String room;
    
    public courseInfo() {
        
    }
    public courseInfo(String courseName, int courseID) {
        this.courseName = courseName;
        this.courseID = courseID;
    }
    public courseInfo (String courseName, String day, String time, String location){
        this.courseName = courseName;
        this.day = day;
        this.time = time;
        this.location = location;
    }
    public void setCourseLocation(String building, String room){
        this.building = building;
        this.room = room;
    }
    public void setCourseUnits(String courseName) {
        courseUnits = 3;
    }
    public String getCourse(){
        return courseName;
    }
    public String getDay(){
        return day;
    }
    public String getTime() {
        return time;
    }
    public String getLocation() {
        return building + room;
    }
}
