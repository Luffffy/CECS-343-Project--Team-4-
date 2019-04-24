/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Judy
 */
public class Building {
    private String buildingName;
    private int occupancyLimit;
    
    public Building(String name, int limit) {
        occupancyLimit = limit;
        buildingName = name;
    }
    
    public int getOccupancyLimit() {
        return occupancyLimit;
    }
    
    public void setOccupancyLimit(int limit) {
        occupancyLimit = limit;
    }
    
    public String getBuildingName() { 
        return buildingName;
    }
    
    public void setBuildingName(String name) {
        buildingName = name;
    }
}
