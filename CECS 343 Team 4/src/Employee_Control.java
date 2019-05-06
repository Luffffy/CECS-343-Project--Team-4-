
import java.time.LocalTime;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Judy
 */
public class Employee_Control {
    
    //Session temp = new Session( "tempName", -1, day, semester, building, room, startTime, endTIme, course);
    //if(!ec.checkClassConflict(e, temp))
    //{
    //    Session add = new Session ( "real Name" , profID, day, semester, building, room, startTime, endTIme, course);
    //    dbc.addSession(db, ....., add);
    //{
    //else
    //{
    //      System.out.println("Cannot add this session because it conflicts with the profs teaching schedule");
    //}
    
    public boolean checkClassConflict(Employee e, Session s)
    {
        //boolean canTeach = true;
        ArrayList<Session> temp = e.getSessionList();
        for(int i = 0; i < temp.size(); i++)
        {
            if(timeConflict(temp.get(i), s))
            {
                System.out.println("Cannot add session because it has a time conflict with another session");
                return true; //canTeach = false;
            }
        }
        return false;
        /*
        if(canTeach){
            e.addSession(s);
            System.out.println("Session has been added");
        }
*/
        
        
    }
    public boolean timeConflict(Session a, Session b)
    {
        LocalTime aS = a.getStartTime();
        LocalTime aE = a.getEndTime();
        LocalTime bS = b.getStartTime();
        LocalTime bE = b.getEndTime();
        
        if(a.getBuildingName().equals(b.getBuildingName()))
        {
            if(a.getRoomName().equals(b.getRoomName()))
            {
                if(a.getDay() == b.getDay())
                {
                    if(aS.isBefore(bS) && aE.isAfter(bS))
                    {
                        //System.out.println("Time conflict B starts between A");
                        return true;
                    }
                    if(bS.isBefore(aS) && bE.isAfter(aS))
                    {
                       //System.out.println("Time conflict A starts between B");
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
