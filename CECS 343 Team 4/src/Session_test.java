
import java.time.*;
import java.util.*;
public class Session_test {
    
    public static void main(String[] arg)
    {
        System.out.println("enter as");
        Scanner input = new Scanner (System.in);
        String asString = input.nextLine();
        LocalTime aS = LocalTime.parse(asString);
        LocalTime aE = LocalTime.parse("12:00:00");
        LocalTime bS = LocalTime.parse("11:00:00");
        LocalTime bE = LocalTime.parse("13:00:00");
        
        if(aS.isBefore(bS) && aE.isAfter(bS))
            System.out.println("Time conflict B starts between A");
        if(bS.isBefore(aS) && bE.isAfter(aS))
            System.out.println("Time conflict A starts between B");
        
        System.out.println("aS: " + aS + " aE: " + aE);
        System.out.println("bS: " + bS + " bE: " + bE );
        
        aS = LocalTime.parse("15:00");
        aE = LocalTime.parse("16:00");
        bS = LocalTime.parse("13:00");
        bE = LocalTime.parse("17:00");
        
        if(aS.isBefore(bS) && aE.isAfter(bS))
            System.out.println("Time conflict B starts between A");
        if(bS.isBefore(aS) && bE.isAfter(aS))
            System.out.println("Time conflict A starts between B");
        
        System.out.println("aS: " + aS + " aE: " + aE);
        System.out.println("bS: " + bS + " bE: " + bE );
        
    }
}
