import java.util.ArrayList;

public class Department {
    private String departmentName;
    private int chairID;
    private ArrayList <String> majors = new ArrayList();
    
    public Department(String name, int ID) {
        departmentName = name;
        chairID = ID;
    }
    
    public void addMajor(String major) {
        majors.add(major);
    }
    
    public void removeMajor(String major) {
        majors.remove(major);
    }
    
    public ArrayList<String> getMajorList() {
        return majors;
    }
    
    public String getMajors() {
        if(majors.isEmpty()) {
            return "No Majors";
        } else {
            String s = "";
            for(String major: majors){
                s += major + "\n";
            }
            return s;
        }
    }
    
    public String getDepartmentName() {
        return departmentName;
    }
    
    public void setDepartmentName(String name) {
        departmentName = name;
    }
    
    public int getChairID() {
        return chairID;
    }
    
    public void setChairID(int ID) {
        chairID = ID;
    }
}
