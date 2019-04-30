import java.util.ArrayList;

public class University {
    private String universityName;
    private ArrayList <String> colleges = new ArrayList();
    
    public University(String name) {
        universityName = name;
    }
    
    public void addcCollege(String college) {
        colleges.add(college);
    }
    
    public void removeCollege(String college) {
        colleges.remove(college);
    }
    
    public ArrayList<String> getCollegeList() {
        return colleges;
    }
    
    public String getColleges() {
        if(colleges.isEmpty()) {
            return "No Colleges";
        } else {
            String s = "";
            for(String college: colleges){
                s += college + "\n";
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
