package repository;

import domain.ParkingSlot;
import domain.Vehicle;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SlotRepository {
    private Map<UUID, ParkingSlot> slots = new ConcurrentHashMap<>();

    public ParkingSlot save(ParkingSlot)
}
