import java.util.*;
import java.util.ArrayList;
import static java.util.Collections.list;

public class Employee {
    private String Name;
    private int ID;
    private float Salary; 
    private boolean isProfessor;
    private int index = 0;
    
    ArrayList<Session> sessionsTeaching = new ArrayList<>();
    
    public Employee(String name, int id, float salary) {
        this.Name = name;
        this.ID = id;        
        this.Salary = salary;
    }
    public String getName() {
        return Name;
    }
    
    public void setName(String name) {
        this.Name = name;
    }
    
    public int getID() {
        return ID;
    }
    
    public float getSalary() {
        return Salary;
    }
    
    public void setSalary(float salary) {
        this.Salary = salary;
    }
    
    public boolean getProfessor(){
        return isProfessor;
    }
    
    public void isProfessor(){
        if (sessionsTeaching.size() >0)
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
    public ArrayList getSessionList()
    {
        return sessionsTeaching;
    }
    
    public void addSession(Session c){
        sessionsTeaching.add(c);
    }
    
    public void removeSession(Session s) {
        sessionsTeaching.remove(s);
    }

    public void printTeachingSchedule(){
        int size = sessionsTeaching.size();
        for (int i = 0; i < size; i++) {
            System.out.print(sessionsTeaching.get(i).getCourse().getCourseName() + " ");
            System.out.print(sessionsTeaching.get(i).getDayName() + " ");
            System.out.print(sessionsTeaching.get(i).getTimeName() + " ");
            //System.out.println(coursesTeaching.get(i).getLocation());
            
        }
        System.out.println();
    }
    
//    public String TeachingScheduleString()
//    {
//        String temp = "";
//        for(Course c: coursesTeaching)
//        {
//            //temp += c.getCourseName() + " " + c.getDay() + " " + c.getTime() + " " + c.getLocation() + "\n";
//        }
//        
//        return temp;
//    }
    
    public String toString()
    {
        return "Name: " + Name +  " ID: " + ID; 
    }
    
}