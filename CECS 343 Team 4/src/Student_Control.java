import java.util.*;
import java.time.LocalTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Judy
 */
public class Student_Control {
      
    public void addSession(Database db, Student student, Session session)
    {
        if(checkTuition(student))
        {
            ArrayList<Session> temp = student.getSessionList();
            boolean conflict = false;
            for(Session s: temp)
            {
                if(timeConflict(s, session))
                {
                    conflict = true;
                }
            }
            
            if(!conflict)
            {
                student.addSession(session);
                System.out.println("Session has been added");
            }
            
        }
    }
    public boolean checkTuition(Student s)
    {
        if(s.getPaid())
        {
            System.out.println("Student has paid their tuition");
            return true;
        }
        else
        {
            System.out.println("Student has not paid their tuition so they cannot add a session");
            return false;
        }
    }
    
    public boolean timeConflict(Session a, Session b)
    {
        LocalTime aS = a.getStartTime();
        LocalTime aE = a.getEndTime();
        LocalTime bS = b.getStartTime();
        LocalTime bE = b.getEndTime();
        
        if(a.getDay() == b.getDay())
        {
            if(aS.isBefore(bS) && aE.isAfter(bS))
            {
            System.out.println("Time conflict B starts between A");
            return true;
            }
            if(bS.isBefore(aS) && bE.isAfter(aS))
            {
               System.out.println("Time conflict A starts between B");
                return true;
            }
        }
        return false;
    }
}
