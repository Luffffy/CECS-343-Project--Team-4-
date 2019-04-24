/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Judy
 */
public class Department {
    private String departmentName;
    private int chairID;
    
    Department(String name, int ID) {
        departmentName = name;
        chairID = ID;
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
