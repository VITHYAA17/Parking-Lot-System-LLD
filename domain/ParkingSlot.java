package domain;
import java.util.UUID;

public class ParkingSlot {
    private UUID id;
    private Vehicle.VehicleType slotType;
    private boolean isOccupied;
    private int floorNumber;

    public ParkingSlot(Vehicle.VehicleType slotType, boolean isOccupied, int floorNumber){
        this.id = UUID.randomUUID();
        this.slotType = slotType;
        this.isOccupied = false;
        this.floorNumber = floorNumber;
    }
    public UUID getId(){
        return id;
    }

    public Vehicle.VehicleType getSlotType(){
        return slotType;
    }

    public boolean isOccupied(){
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied){
        isOccupied = false;
    }

    public int getFloorNumber(){
        return floorNumber;
    }

    @Override
    public String toString(){
        return "ParkingSlot{" + "id = " + id + "slotType = "+ slotType + "isoccupied =" + isOccupied + ", floor number = "+ floorNumber + "}";
    }

}
