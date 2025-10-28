package com.techlab.excepciones;

public class InvalidNumberException extends RuntimeException{

    public InvalidNumberException(String mensaje){
        super(mensaje);
    }
}
