package kz.aitu.restpro2423.rest.entities;

public class Booking {

    /// default constructor
    public Booking() {
    }
    /// main constructor
    public Booking(Guest guest, Room room, int numberOfNights) {
        this.guest = guest;
        this.room = room;
        this.numberOfNights = numberOfNights;
    }
    /// attributes of class
    private Guest guest;
    private Room room;
    private int numberOfNights;

    /// getters
    public Guest getGuest() {
        return this.guest;
    }
    public Room getRoom() {
        return this.room;
    }
    public int getNumberOfNights() {
        return this.numberOfNights;
    }
    /// setters
    public void setGuest(Guest guest) {
        this.guest = guest;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    /// Method to calculate total cost
    public int calculateTotalCost(){
        return this.numberOfNights * room.getPricePerNight();
    }
    /// Overriding toString()
    @Override
    public String toString(){
        return "Booking Details: \n" +
                "Guest: " + guest + "\n" +
                "Room: " + room + "\n" +
                "Number of Nights: " + numberOfNights + "\n" +
                "Total Cost: " + calculateTotalCost();
    }
    
}
