package com.company.message;

public class ResponseReservation {
    private boolean succes;

    public ResponseReservation(boolean succes) {
        this.succes = succes;
    }

    public boolean isSucces() {
        return succes;
    }
}
