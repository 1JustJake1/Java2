public record Room(String type, int bedCount, int roomNumber, String amenities)
        implements Comparable<Room> {

    @Override
    public int compareTo(Room other) {
        return Integer.compare(this.roomNumber, other.roomNumber);
    }
}
