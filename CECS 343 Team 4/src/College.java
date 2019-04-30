import java.util.ArrayList;

public class College {
    private String collegeName;
    private int deanID;
    private ArrayList <String> departments = new ArrayList();
    
    public College(String name, int ID) {
        collegeName = name;
        deanID = ID;
    }
    
    public void addDepartment(String department) {
        departments.add(department);
    }
    
    public void removeDepartment(String department) {
        departments.remove(department);
    }
    
    public ArrayList<String> getDepartmentList() {
        return departments;
    }
    
    public String getDepartments() {
        if(departments.isEmpty()) {
            return "No Departments";
        } else {
            String s = "";
            for(String department: departments){
                s += department + "\n";
            }
            return s;
        }
    }
    
    public void setCollegeName(String name) {
        collegeName = name;
    }
    
    public String getCollegeName() {
        return collegeName;
    }
    
    public void setDeanID(int ID) {
        deanID = ID;
    }
    
    public int getDeanID() {
        return deanID;
    }
}
