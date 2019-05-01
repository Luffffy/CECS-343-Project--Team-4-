import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author chealyTahir
 */
public class hashmapDatabase {
    Employee pObject = new Employee("John Smith", 12345, 500);
    Major     mObject = new Major ("Biology", "Bio101");
    prerequisiteCourse prereObject = new prerequisiteCourse("GE100");
    
      
    Map<Integer, Employee> professorHashMap = new HashMap<>();
    Map<String, Major>     majorHashMap     = new HashMap<>();
    Map<String, prerequisiteCourse> prereCourseHashMap = new HashMap<>(); 
       
    public hashmapDatabase() {
        professorHashMap.put(12345, pObject);
        majorHashMap.put("Biology", mObject);
        prereCourseHashMap.put("Bio101", prereObject);
        
        mObject.addCourse("Bio201");
        mObject.addCourse("Bio301");
        prereObject.add_prerequisiteCourse("GE100");
        prereObject.add_prerequisiteCourse("GE101");
        
    }
    void add_professor_Hashmap(Employee professorObject) {
        professorHashMap.put(professorObject.getID(), professorObject);
    }
    
    void add_major_Hashmap(Major majorObject) {
        majorHashMap.put(majorObject.get_majorName(), majorObject);
    }
    void add_prereCourse_Hashmap(prerequisiteCourse prereObject) {
        prereCourseHashMap.put(prereObject.get_mainCourse(), prereObject);
    }
    void print_professor_Hashmap () {
        Set<Map.Entry<Integer, Employee>> entries = professorHashMap.entrySet();
        for(Map.Entry<Integer, Employee> proObj : entries) {
            System.out.print(proObj.getKey() + ": ");
            Employee ob = proObj.getValue();
            System.out.println(ob.getName());
        }
    }
    void print_major_Hashmap() {
        Set<Map.Entry<String, Major>> entries = majorHashMap.entrySet();
        for(Map.Entry<String, Major> majorObj : entries) {
            System.out.print("'" + majorObj.getKey() + "' major contain courses: ");
            Major ob = majorObj.getValue();
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
