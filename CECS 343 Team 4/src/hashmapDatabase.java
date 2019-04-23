import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author chealyTahir
 */
public class hashmapDatabase {
    professor pObject = new professor("John Smith", 12345);
    major     mObject = new major ("Biology", "Bio101");
    prerequisiteCourse prereObject = new prerequisiteCourse("GE100");
    
      
    Map<Integer, professor> professorHashMap = new HashMap<>();
    Map<String, major>     majorHashMap     = new HashMap<>();
    Map<String, prerequisiteCourse> prereCourseHashMap = new HashMap<>(); 
       
    public hashmapDatabase() {
        professorHashMap.put(12345, pObject);
        majorHashMap.put("Biology", mObject);
        prereCourseHashMap.put("Bio101", prereObject);
        
        mObject.add_MajorCourse("Bio201");
        mObject.add_MajorCourse("Bio301");
        prereObject.add_prerequisiteCourse("GE100");
        prereObject.add_prerequisiteCourse("GE101");
        
    }
    void add_professor_Hashmap(professor professorObject) {
        professorHashMap.put(professorObject.getID(), professorObject);
    }
    
    void add_major_Hashmap(major majorObject) {
        majorHashMap.put(majorObject.get_majorName(), majorObject);
    }
    void add_prereCourse_Hashmap(prerequisiteCourse prereObject) {
        prereCourseHashMap.put(prereObject.get_mainCourse(), prereObject);
    }
    void print_professor_Hashmap () {
        Set<Map.Entry<Integer, professor>> entries = professorHashMap.entrySet();
        for(Map.Entry<Integer, professor> proObj : entries) {
            System.out.print(proObj.getKey() + ": ");
            professor ob = proObj.getValue();
            System.out.println(ob.getName());
        }
    }
    void print_major_Hashmap() {
        Set<Map.Entry<String, major>> entries = majorHashMap.entrySet();
        for(Map.Entry<String, major> majorObj : entries) {
            System.out.print("'" + majorObj.getKey() + "' major contain courses: ");
            major ob = majorObj.getValue();
            ob.print_MajorCourses(ob.get_majorName());           
        }    
    }
    void print_prereCourse_Hashmap() {
        Set<Map.Entry<String, prerequisiteCourse>> entries = prereCourseHashMap.entrySet();
        for(Map.Entry<String, prerequisiteCourse> prereObj : entries) {
            System.out.print("'" + prereObj.getKey() + "' prerequisite courses: ");
            prerequisiteCourse ob = prereObj.getValue();
            ob.print_prereCourses(ob.get_mainCourse());
        }
    }
}
