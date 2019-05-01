import java.util.ArrayList;

public class Department {
    private String departmentName;
    private int chairID;
    private ArrayList <Major> majors = new ArrayList();
    
    public Department(String name, int ID) {
        departmentName = name;
        chairID = ID;
    }
    
    public boolean isEmpty(){
        return majors.isEmpty();
    }
    
    public void addMajor(Major major) {
        majors.add(major);
    }
    
    public void removeMajor(Major major) {
        majors.remove(major);
    }
    
    public ArrayList<Major> getMajorList() {
        return majors;
    }
    
    public String getMajors() {
        if(majors.isEmpty()) {
            return "No Majors";
        } else {
            String s = "";
            for(Major major: majors){
                s += major.getMajorName() + "\n";
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
    
    public Major contains(String m) {
        Major temp = null;
        for(Major major : majors) {
            if(major.getMajorName().equals(m)) {
                temp = major;
            }
        }
        return temp;
    }
}
