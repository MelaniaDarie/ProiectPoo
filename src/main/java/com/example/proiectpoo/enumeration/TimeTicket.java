package com.example.proiectpoo.enumeration;

public enum TimeTicket {
    ONE("One hour"),
    THREE("Three hours"),
    DAY("A whole day");

    private String label;

    TimeTicket(String label){
        this.label=label;
    }

    @Override
    public String toString() {
        return label;
    }
}
