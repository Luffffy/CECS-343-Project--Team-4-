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
public class Employee {
    private String Name;
    private int ID;
    private float Salary; 
    private boolean isProfessor;
    private int index = 0;
    
    ArrayList<Course> coursesTeaching = new ArrayList<>();
    
    public Employee(String name, int id, float salary) {
        this.Name = name;
        this.ID = id;        
        this.Salary = salary;
    }
    public String getName() {
        return Name;
    }
    public int getID() {
        return ID;
    }
    public float getSalary() {
        return Salary;
    }
    public boolean getProfessor(){
        return isProfessor;
    }
    public void isProfessor(){
        if (coursesTeaching.size() >0)
        {
            isProfessor = true;
        }
        else
        {
            isProfessor = false;
        }
    }
    
    public void checkProfessor()
    {
        if(isProfessor)
        {
            System.out.println(Name + " is a professor.");
        }
        else
        {
            System.out.println(Name + " is not a professor.");
        }
    }
    public ArrayList getTeachingSchedule()
    {
        return coursesTeaching;
    }
    
    public void addClass(Course c){
        coursesTeaching.add(c);
    }

    public void printTeachingSchedule(){
        int size = coursesTeaching.size();
        for (int i = 0; i < size; i++) {
            System.out.print(coursesTeaching.get(i).getCourseName() + " ");
            System.out.print(coursesTeaching.get(i).getDay() + " ");
            System.out.print(coursesTeaching.get(i).getTime() + " ");
            //System.out.println(coursesTeaching.get(i).getLocation());
            
        }
        System.out.println();
    }
    
    public String TeachingScheduleString()
    {
        String temp = "";
        for(Course c: coursesTeaching)
        {
            //temp += c.getCourseName() + " " + c.getDay() + " " + c.getTime() + " " + c.getLocation() + "\n";
        }
        
        return temp;
    }
    
    public String toString()
    {
        return "Name: " + Name +  " ID: " + ID; 
    }
    
}