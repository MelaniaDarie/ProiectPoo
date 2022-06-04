package com.example.proiectpoo.exceptions;

public class PassNotFoundException extends Exception{

    public PassNotFoundException() {
        super("Password not found!");
    }
}
