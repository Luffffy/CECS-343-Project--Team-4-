import java.util.ArrayList;

public class University {
    private String universityName;
    private ArrayList <College> colleges = new ArrayList();
    
    public University(String name) {
        universityName = name;
    }
    
    public void addCollege(College college) {
        colleges.add(college);
    }
    
    public void removeCollege(College college) {
        colleges.remove(college);
    }
    
    public ArrayList<College> getCollegeList() {
        return colleges;
    }
    
    public String getColleges() {
        if(colleges.isEmpty()) {
            return "No Colleges";
        } else {
            String s = "";
            for(College college: colleges){
                s += college.getCollegeName() + "\n";
            }
            return s;
        }
    }
    
    public String getUniversityName() {
        return universityName;
    }
    
    public void setUniversityName(String name) {
        universityName = name;
    }
}
