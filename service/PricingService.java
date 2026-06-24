package service;

import domain.PricingRule;
import domain.Ticket;
import domain.Vehicle;
import domain.Vehicle.VehicleType;
import repository.PricingRuleRepository;
import java.util.Optional;

public class PricingService {
    private PricingRuleRepository pricingRuleRepository;
    public PricingService(PricingRuleRepository pricingRuleRepository){
        this.pricingRuleRepository = pricingRuleRepository;
    }

    public double calculateFee(Ticket ticket){
        System.out.println("[Service] Calculating the see for the ticket : "+ticket);
        Vehicle.VehicleType vehicleType = Vehicle.VehicleType.CAR;

        Optional<PrincingRule> rule = pricingRuleRepository;
        if(rule.isEmpty()){
            throw new IllegalStateException("No pricing Rule found for the vehicle Type: "+vehicleType);
        }

        PricingRule pricingRule = rules.get();

        double flatFee = pricingRule.getFlatRate();
        double hourlyFee = calculateHourlyFee(ticket, pricingRule.getRatePerHour);

        double finalFee = Math.min(flatFee, hourlyFee);

        System.out.println("[Service] Flat fee : "+ flatFee+" HourlyFee : "+hourlyFee + " finalFee :"+finalFee+" for vehicleType: "+ vehicleType);
        return finalFee;
    }
    private double calculateHourlyFee(Ticket ticket, double ratePerHour){
        java.time.Duration duration = java.time.Duration.between(ticket.getEntryTime(), java.time.LocalDateTime.now());
        long hours = duration.toHours();
        if(hours < 1){
            hours = 1;
        }
        return hours * ratePerHour;
    }

    public void addPricingRule(PricingRule rule){
        pricingRuleRepository.save(rule);
    }
    public void updatePricingRule(PricingRule rule){
        pricingRuleRepository.update(rule);
    }
}
