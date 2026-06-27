package service;

import domain.Floor;
import domain.ParkingSlot;
import domain.PricingRule;
import domain.Vehicle;
import repository.FloorRepository;
import repository.PricingRuleRepository;
import repository.SlotRepository;
import java.util.List;
import java.util.Map;


public class AdminService {
    private FloorRepository floorRepository;
    private SlotRepository slotRepository;
    private PricingRuleRepository pricingRuleRepository;

    public AdminService(FloorRepository floorRepository, SlotRepository slotRepository,PricingRuleRepository pricingRuleRepository){
        this.floorRepository = floorRepository;
        this.slotRepository = slotRepository;
        this.pricingRuleRepository = pricingRuleRepository;
        System.out.println("[SERVICE] AdminService initialized");
    }
    public void initializeParkingLot(){
        System.out.println("[SERVICE] Initializing parking lot with default configuration");
        for(int i=0; i<3; i++){
            addFloor(i);
        }
    }
}
