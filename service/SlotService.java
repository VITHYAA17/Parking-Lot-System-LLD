package service;

import domain.ParkingSlot;
import domain.Vehicle;
import repository.SlotRepository;
import java.util.Optional;
import java.util.UUID;

public class SlotService {
    private SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository){
        this.slotRepository = slotRepository;
    }
    public Optional<ParkingSlot> allocateSlot(Vehicle.VehicleType vehicleType){
        System.out.println("[Service] allocating slot for vehicleType : "+ vehicleType);

        Optional<ParkingSlot> slot = slotRepository.allocateSlot((vehicleType));
        if(slot.isPresent()){
            System.out.println("[Service] Slot allocated successfully :" + slot.get().getId());
        }else{
            System.out.println("[Service] No available slots for the vehicle type : "+ vehicleType);
        }

        return slot;
    }

    public void releaseSlot(UUID slotId){
        System.out.println("[Service] Releasing slot : " + slotId);
        slotRepository.releaseSlot(slotId);
        System.out.println("[Service] slot released sucessfully for the id : "+ slotId);
    }
    public ParkingSlot createSlot(Vehicle.VehicleType slotType, int floorNumber){
        ParkingSlot slot = new ParkingSlot(slotType, false, floorNumber);
        slotRepository.save(slot);
        return slot;
    }

    public long getAvailableSlotCount(Vehicle.VehicleType vehicleType){
        return slotRepository.findAvailableSlots(vehicleType).size();
    }

}
