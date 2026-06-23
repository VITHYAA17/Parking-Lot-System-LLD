package service;

import domain.Ticket;
import domain.Vehicle;
import repository.TicketRepository;
import java.util.Optional;
import java.util.UUID;


public class TicketService {
    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;

    }
    public Ticket generateTicket(Vehicle vehicle,UUID slotId){
        System.out.println("[Service] Generating ticket for vehicle: "+vehicle.getLicensePlate());

        Ticket ticket = new Ticket(vehicle.getId(), slotId);
        ticketRepository.save(ticket);

        System.out.println("[Service] Ticket generated successfully : "+ ticket.getId());
        return ticket;
    }
    public Optional<Ticket> getTicket(UUID ticketId){
        System.out.println("[Service] Retriving Ticket : "+ticketId);
        return ticketRepository.findbyId(ticketId);
    }

    public void deactivateTicket(UUID ticketId){
        System.out.println("[Service] Deactivating Ticket : "+ ticketId);
        ticketRepository.deactivateTicket(ticketId);
    }

}
