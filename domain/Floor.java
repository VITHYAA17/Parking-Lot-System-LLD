package domain;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class Floor {
    private UUID id;
    private int floorNumber;
    private List<ParkingSlot> slots;

    public Floor(int floorNumber, List<ParkingSlot> parkingSlots){
        this.id = UUID.randomUUID();
        this.floorNumber = floorNumber;
        this.slots = new ArrayList<>();   
    }

    public void addSlot(ParkingSlot slot){
        slots.add(slot);
    }
    
    public List<ParkingSlot>  getSlots(){
        return new ArrayList<>(slots);
    }

    public List<ParkingSlot> getAvailableSlots(Vehicle.VehicleType vehicleType){
        List<ParkingSlot> availableSlot = new ArrayList<>();
        for(ParkingSlot slot : slots){
            if(slot.getSlotType() == vehicleType && !slot.isOccupied()){
                availableSlot.add(slot);
            }
        }
        return availableSlot;
    }
    public UUID getId(){
        return id;
    }

    public int getFloorNumber(){
        return floorNumber;
    }

    public int getTotalslots(){
        return slots.size();
    }

    public int getAvailableSlotsCount(Vehicle.VehicleType vehicleType){
        return getAvailableSlots(vehicleType).size();
    }

    public String toString(){
        return "Floor {" + "id = "+ id + ", floorNumber" + floorNumber + ",totalSlots = "+ slots.size() + "}";
    }

}
