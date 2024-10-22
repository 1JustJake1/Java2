import java.util.*;
import java.util.stream.Collectors;

public class HotelService {

    public List<Room> sortRoomsByBedCount(List<Room> rooms) {
        return rooms.stream()
                .sorted(Comparator.comparingInt(Room::bedCount))
                .collect(Collectors.toList());
    }

    public List<Room> filterRoomsByBedCount(List<Room> rooms, int bedCount) {
        return rooms.stream()
                .filter(room -> room.bedCount() > bedCount)
                .collect(Collectors.toList());
    }

    public List<Customer> sortCustomersByLastName(List<Customer> customers) {
        return customers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public Optional<Customer> getOldestCustomer(List<Customer> customers) {
        return customers.stream()
                .min(Comparator.comparing(Customer::getBirthDate));
    }

    public Map<String, List<Room>> groupRoomsByType(List<Room> rooms) {
        return rooms.stream()
                .collect(Collectors.groupingBy(Room::type));
    }
}
