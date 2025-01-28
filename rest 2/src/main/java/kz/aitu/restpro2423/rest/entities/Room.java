package kz.aitu.restpro2423.rest.entities;

 public class Room {
     /// default constructor
     public Room() {}

     /// main constructor
     public Room(int roomNumber, int pricePerNight) {
         this.roomNumber = roomNumber;
         this.pricePerNight = pricePerNight;
     }
     /// attributes of class
     private int roomNumber;
     private int pricePerNight;

     ///getters
     public int getRoomNumber() {
         return this.roomNumber;
     }
     public int getPricePerNight() {
         return this.pricePerNight;
     }
     ///setters
     public void setRoomNumber(int roomNumber) {
         this.roomNumber = roomNumber;
     }

     public void setPricePerNight(int pricePerNight) {
         this.pricePerNight = pricePerNight;
     }

     /// Overriding toString()
     @Override
     public String toString(){
         return "Room Number: " + roomNumber + " , pricePerNight: " + pricePerNight;
     }
     /// Overriding equals()
     @Override
     public boolean equals(Object obj) {
         if (this == obj) return true;
         if (obj == null || getClass() != obj.getClass()) return false;
         Room room = (Room) obj;
         return roomNumber == room.roomNumber && pricePerNight == room.pricePerNight;
     }
     /// Overriding hashCode()
     @Override
     public int hashCode(){
         return roomNumber * 31 + pricePerNight;
     }
 }
