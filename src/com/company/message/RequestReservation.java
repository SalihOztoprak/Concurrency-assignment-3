package com.company.message;

public class RequestReservation {
    private String location;
    private int rooms;

    public RequestReservation(String location, int rooms) {
        this.location = location;
        this.rooms = rooms;
    }

    public String getLocation() {
        return location;
    }

    public int getRooms() {
        return rooms;
    }
}
