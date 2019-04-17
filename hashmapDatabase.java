import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chealyTahir
 */
public class hashmapDatabase {
    private String major;
    private String department;
    private String professor;
    private String location;
    private String student;
    
    Map<Integer, professor> professorDataMap = new HashMap<>();
    Map<String, major>     majorDataMap     = new HashMap<>();
    Map<String, prerequisiteCourse> prereCourseDataMap = new HashMap<>(); 
    
    public hashmapDatabase() {
        this.major = "major";
        this.department = "department";
        this.location = "location";
        this.professor = "professor";
        this.student = "student";
    }
    void add_professor_Hashmap(professor professorObject) {
        professorDataMap.put(professorObject.getID(), professorObject);
    }
    
    void add_major_Hashmap(major majorObject) {
        majorDataMap.put(majorObject.get_majorName(), majorObject);
    }
    void add_prereCourse_Hashmap(prerequisiteCourse prereObject) {
        prereCourseDataMap.put(prereObject.get_mainCourse(), prereObject);
    }
    void print_professor_Hashmap () {
        Set<Map.Entry<Integer, professor>> entries = professorDataMap.entrySet();
        for(Map.Entry<Integer, professor> proObj : entries) {
            System.out.println(proObj.getKey());
            professor ob = proObj.getValue();
            System.out.println(ob.getName());
        }
    }
    void print_major_Hashmap() {
        Set<Map.Entry<String, major>> entries = majorDataMap.entrySet();
        for(Map.Entry<String, major> majorObj : entries) {
            System.out.println(majorObj.getKey());
            major ob = majorObj.getValue();
            System.out.println(ob.get_majorName());
        }    
    }
    void print_prereCourse_Hashmap() {
        Set<Map.Entry<String, prerequisiteCourse>> entries = prereCourseDataMap.entrySet();
        for(Map.Entry<String, prerequisiteCourse> prereObj : entries) {
            System.out.println(prereObj.getKey());
            prerequisiteCourse ob = prereObj.getValue();
            ob.print_prereCourses(ob.get_mainCourse());
        }
    }
}
