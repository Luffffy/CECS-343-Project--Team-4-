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
    private String day;
    private String time;
    private String location;
    
    public courseInfo (String courseName, String day, String time, String location){
        this.courseName = courseName;
        this.day = day;
        this.time = time;
        this.location = location;
    }
    String getCourse(){
        return courseName;
    }
    String getDay(){
        return day;
    }
    String getTime() {
        return time;
    }
    String getLocation() {
        return location;
    }
}
