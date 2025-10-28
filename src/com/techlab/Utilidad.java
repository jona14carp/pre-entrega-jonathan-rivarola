package com.techlab;

import com.techlab.excepciones.IdNotFoundException;
import com.techlab.excepciones.InvalidNumberException;
import com.techlab.productos.Producto;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Utilidad {

    public static int numEnteroValido(Scanner entrada, String mensaje){

        int opcion;

        while (true){
            try{
                System.out.println(mensaje);
                opcion = entrada.nextInt();
                entrada.nextLine();

                break;
            } catch (InputMismatchException e){
                System.out.println("⛔⛔La opcion ingresada es invalido⛔⛔");
                entrada.nextLine();
            }
        }
        return opcion;
    }

    public static double numDecimalValido(Scanner entrada, String mensaje){
        double opcion;
        while (true){
            try {
                System.out.println(mensaje);
                opcion = entrada.nextDouble();
                entrada.nextLine();
                break;
            }catch (InputMismatchException e){
                System.out.println("El numero ingresado no es valido");
                entrada.nextLine();
            }
        }
        return opcion;
    }

    public static int numeroEnteroPositivo(Scanner entrada, String mensaje){
        int opcion;
        while(true){
            try{
                opcion = numEnteroValido(entrada, mensaje);
                if (opcion < 0){
                    throw new InvalidNumberException("El numero no puede ser negativo");
                }
                break;
            }catch (InvalidNumberException e){
                System.out.println("Ingrese un numero positivo");
            }
        }
        return opcion;
    }

    public static double numeroDoublePostivo(Scanner entrada, String mensaje){
        double opcion;

        while(true){
            try {
                opcion = numDecimalValido(entrada,mensaje);

                if (opcion<0){
                    throw new InvalidNumberException("El numero no puede ser negativo");
                }
                break;
            }catch (InvalidNumberException e){
                System.out.println("Ingrese el numero positivo");
            }
        }
        return opcion;
    }

    public static void dejarEspacio(int cantidad){
        for (int i = 0; i < cantidad; i++){
            System.out.println();
        }
    }

    public static void presioneEnterParaContinuar(Scanner entrada){
        System.out.println("\nPresione ❗ENTER❗ para continuar.....");
        String enter = entrada.nextLine();
    }

    public static int posicionProductoExistente(int id, List<Producto>productos){
        int posicion = -1;

        if (productos.isEmpty()){
            System.out.println("La lista de productos esta vacia");
            return posicion;
        }

        if (id == 0 ){
            return -1;
        }

        for (int i = 0; i < productos.size(); i++){
            if (productos.get(i).getId() == id){
            return i;
            }
        }
        return -1;
    }

    public static int positionId(Scanner entrada, List<Producto>productos){
        if (productos.isEmpty()){
            System.out.println("La lista de productos se encuentra vacia");
            return -2;
        }
        int id = Utilidad.numeroEnteroPositivo(entrada, "Ingrese la id solicitada: ");

        if (Utilidad.posicionProductoExistente(id, productos)==-1){
            System.out.println("No existe producto con la id solicitada");
            return -1;
        }

        return Utilidad.posicionProductoExistente(id, productos);
    }
}
