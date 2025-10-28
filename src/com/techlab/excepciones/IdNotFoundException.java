package com.techlab.excepciones;

import java.util.Scanner;

public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException(int id){
        super("No se encontro la id: "+ id);
    }
}
