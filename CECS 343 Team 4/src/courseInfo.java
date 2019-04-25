
import java.util.ArrayList;

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
    
    ArrayList<String> prereCourse_Arraylist = new ArrayList();
    
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
    public void setCourseName (String courseName ) {
        this.courseName = courseName;
    }
    public String getCourseName () {
        return this.courseName;
    }
    public void setCourseID(int courseID){
        this.courseID = courseID;
    }
    public int getCourseID (){
        return this.courseID;
    }
    public void setCourseUnits(int courseUnits) {
        this.courseUnits = courseUnits;
    }
    public int getCourseUnits(){
        return this.courseUnits;
    }
    public void addPrereCourse (String prerequisiteCourse) {
        prereCourse_Arraylist.add(prerequisiteCourse);
    }
    public ArrayList getPrerequisiteCourseList() {
        return prereCourse_Arraylist;
    }
    public boolean courseHasPrerequisite () {
        if (!prereCourse_Arraylist.isEmpty())
            return true;
        return false;
    }
    public void setCourseLocation(String building, String room){
        this.building = building;
        this.room = room;
        this.location = building + room;
    }
    public String getLocation(){
        return location;
    }
    public String getCourseBuiding(){
        return building;
    }
    public String getCourseRoom() {
        return room;
    }
    public void setDay(String day) {
        this.day = day;
    }
    public String getDay(){
        return day;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }
}
