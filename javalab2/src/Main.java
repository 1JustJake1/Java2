import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Room> rooms = List.of(
                new Room("Делюкс", 3, 11, "Wi-Fi, Кондиціонер, Міні-бар, Телевізор"),
                new Room("Стандарт", 1, 21, "Wi-Fi"),
                new Room("Сімейний", 3, 30, "Wi-Fi, Телевізор, Кондиціонер"),
                new Room("Стандарт", 2, 23, "Wi-Fi, Телевізор")
        );

        List<Customer> customers = List.of(
                new Customer.Builder().setFirstName("Іван").setLastName("Гаць")
                        .setDocumentId("AB123456").setBirthDate(LocalDate.of(2004, 7, 7)).build(),
                new Customer.Builder().setFirstName("Олександр").setLastName("Ахмадитова")
                        .setDocumentId("AB654321").setBirthDate(LocalDate.of(1999, 2, 12)).build(),
                new Customer.Builder().setFirstName("Анна").setLastName("Захарова")
                        .setDocumentId("AB111111").setBirthDate(LocalDate.of(2001, 12, 12)).build()
        );

        HotelService service = new HotelService();

        //Сортування за кількістю ліжок
        List<Room> sortedRooms = service.sortRoomsByBedCount(rooms);
        System.out.println("Відсортовані кімнати за кількістю ліжок:");
        sortedRooms.forEach(System.out::println);

        //Фільтрація за мінімальною кількістю ліжок
        List<Room> filteredRooms = service.filterRoomsByBedCount(rooms, 1);
        System.out.println("\nКімнати з більше ніж 1 ліжком:");
        filteredRooms.forEach(System.out::println);

        //Сортування за прізвищем
        List<Customer> sortedCustomers = service.sortCustomersByLastName(customers);
        System.out.println("\nКлієнти, відсортовані за прізвищем:");
        sortedCustomers.forEach(System.out::println);

        //Пошук найстарішого клієнта
        Optional<Customer> oldestCustomer = service.getOldestCustomer(customers);
        oldestCustomer.ifPresent(customer -> System.out.println("\nНайстаріший клієнт: " + customer));

        //Групування кімнат за типом
        var roomsByType = service.groupRoomsByType(rooms);
        System.out.println("\nГрупування кімнат за типом:");
        roomsByType.forEach((type, roomList) -> {
            System.out.println(type + ":");
            roomList.forEach(System.out::println);
        });
    }
}
