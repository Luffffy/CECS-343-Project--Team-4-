import java.util.*;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.time.*;

public class Employee {
    private String Name;
    private int ID;
    private float Salary; 
    private boolean isProfessor;
    private int index = 0;
    private boolean isAdmin;
    
    ArrayList<Session> sessionsTeaching = new ArrayList<>();
    
    public Employee(String name, int id, float salary) {
        this.Name = name;
        this.ID = id;        
        this.Salary = salary;
        isAdmin = false;
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
    
    public void setName(String name) {
        this.Name = name;
    }
    
    public void setID(int id)
    {
        this.ID = id;
    }
    public void setSalary(float salary) {
        this.Salary = salary;
    }
    
    public boolean getProfessor(){
        isProfessor();
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
        isProfessor();
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
            System.out.println(sessionsTeaching.get(i).getLocation());
            
        }
        System.out.println();
    }
    
    public String toString()
    {
        return "Name: " + Name +  " ID: " + ID; 
    }
    
    public boolean getAdmin() {
        return isAdmin;
    }
    
    public void setAdmin(boolean value) {
        isAdmin = value;
    }
    
    public boolean isEmpty()
    {
        return sessionsTeaching.isEmpty();
    }
    
    public String getSessions() {
        if(sessionsTeaching.isEmpty()) {
            return "No Sessions";
        } else {
            String s = "";
            for(Session session: sessionsTeaching){
                s += session.getSessionNumber() + " " + session.getSemesterString() 
                        + " " + session.getDayName() + " " + session.getStartTime() + " - " + session.getEndTime() + "\n";
            }
            return s;
        }
    }
}