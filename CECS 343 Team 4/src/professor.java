/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.util.ArrayList;
import static java.util.Collections.list;
/**
 *
 * @author chealyTahir
 */
public class professor {
    private String proName;
    private int proID;
    private int index = 0;
    
    ArrayList<String> courseTaught = new ArrayList<>();
    ArrayList<courseInfo> courseTaught_info = new ArrayList<courseInfo>();
    
    public professor(String proName, int proID) {
        this.proName = proName;
        this.proID = proID;        
    }
    String getName() {
        return proName;
    }
    int getID() {
        return proID;
    }
    void set_proSchedule(String course, String day, String time, String location) {
        courseTaught.add(course);
        courseInfo info = new courseInfo(course, day, time, location);
        courseTaught_info.add(info);
        index++;
    }
    void print_proSchedule() {
        int i = index-1;
        while ((i==0)||(i>0)) {
            System.out.print(courseTaught.get(i) + ": ");
            System.out.print(courseTaught_info.get(i).getDay()+ "_");
            System.out.print(courseTaught_info.get(i).getTime()+ "_");
            System.out.print(courseTaught_info.get(i).getLocation());
            i--;
        }
    }
    String get_courseSchedule(String courseName){
        int i = 0;
        String str = null;
        courseInfo courseInfoo;
        for (courseInfo schedule: courseTaught_info){
            courseInfoo = schedule;
            if (schedule.getCourse() == courseName){
                System.out.print(schedule.getDay() + "_");
                System.out.print(schedule.getTime() + "_");
                System.out.println(schedule.getLocation());
                str = schedule.getDay() + "_" + schedule.getTime() +
                      "_" + schedule.getLocation();
            }
            i++;    
        }
        return str;
    }
    String get_courseName(String courseTime ){
        int i = 0;
        String name = null;
        courseInfo courseInfoo;
        for (courseInfo schedule: courseTaught_info){
            courseInfoo = schedule;
            if (schedule.getTime() == courseTime){
                System.out.print(schedule.getCourse() + "_");
                System.out.print(schedule.getDay() + "_");
                System.out.println(schedule.getLocation());
                name = schedule.getTime();
            }
            i++;    
        }
        return name;
    }
}