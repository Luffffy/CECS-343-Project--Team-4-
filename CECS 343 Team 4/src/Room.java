
public class Room {
    private String roomName;
    private int occupancyLimit;
    
    public Room(String name, int limit) {
        roomName = name;
        occupancyLimit = limit;
    }
    
    public String getRoomName() {
        return roomName;
    }
    
    public void setRoomName(String name) {
        roomName = name;
    }
    
    public int getOccupancyLimit() {
        return occupancyLimit;
    }
    
    public void setOccupancyLimit(int limit) {
        occupancyLimit = limit;
    }
}
