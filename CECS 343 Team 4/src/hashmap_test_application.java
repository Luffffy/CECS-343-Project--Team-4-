import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class hashmap_test_application {
 public static void main(String[] args) {  
      
        System.out.println("Print out intitial information in Database: ");
        hashmapDatabase dataObject = new hashmapDatabase();
        dataObject.print_major_Hashmap();
        dataObject.print_prereCourse_Hashmap();
        dataObject.print_professor_Hashmap();
        System.out.println();
        
        System.out.println("Database of major object after add on Chemistry major: ");
        major chem_major = new major("Chemistry");
        chem_major.add_MajorCourse("chem2");
        chem_major.add_MajorCourse("chem3");
        chem_major.add_MajorCourse("chem4");
        chem_major.add_MajorCourse("chem5");
        chem_major.add_MajorCourse("chem6");
        chem_major.add_MajorCourse("chem7");     
        dataObject.add_major_Hashmap(chem_major);
        dataObject.print_major_Hashmap();
        
    }
}
