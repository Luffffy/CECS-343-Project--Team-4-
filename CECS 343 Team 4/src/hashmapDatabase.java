import java.util.HashMap;
import java.util.Map;
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
    
    Map<String, Integer> professorData = new HashMap<>();
    Map<String, major>     majorData     = new HashMap<>();
    
    public hashmapDatabase() {
        this.major = "major";
        this.department = "department";
        this.location = "location";
        this.professor = "professor";
        this.student = "student";
    }
    void add_professor_Hashmap(professor professor_) {
        professorData.put(professor_.getName(), professor_.getID());
    }
    
    void add_major_Hashmap(major major_) {
        major.put()
    }
}
