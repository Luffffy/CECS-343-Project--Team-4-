import java.time.*;



public class Admin_Control {
    
    
    public void timeConflict(Session a, Session b)
    {
        LocalTime aS = a.getStartTime();
        LocalTime aE = a.getEndTime();
        LocalTime bS = b.getStartTime();
        LocalTime bE = b.getEndTime();
        
        if(aS.isBefore(bS) && aE.isAfter(bS))
            System.out.println("Time conflict B starts between A");
        if(bS.isBefore(aS) && bE.isAfter(aS))
            System.out.println("Time conflict A starts between B");
    }
}
