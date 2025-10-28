package com.techlab;

import com.techlab.excepciones.InvalidNumberException;
import com.techlab.pedidos.Pedido;
import com.techlab.productos.Producto;
import com.techlab.servicio.ProductoService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int opcion;

        ArrayList<Producto>productos = new ArrayList<>();
        Pedido pedido = new Pedido();
        ProductoService servicio = new ProductoService();

        System.out.println("Hola bienvenido a Mariners coffee☕, ingrese su nombre: ");
        String nombreUsuario = entrada.nextLine();

        do {

            System.out.println("Hola " + nombreUsuario + " elija una opcion");
            System.out.println("""    
                    1- Agregar producto.
                    2- Listar productos.
                    3- Buscar productos.
                    4- Actualizar producto.
                    5- Eliminar producto.
                    6- Crear un pedido.
                    7- Listar un pedido.
                    8- Salir.
                            """);

            while (true) {
                opcion = Utilidad.numEnteroValido(entrada, "Elija una opcion");
                try {
                    if (opcion < 1 || opcion > 8) {
                        throw new InvalidNumberException("Opcion invalida");
                    }

                    break;
                } catch (InvalidNumberException e) {
                    System.out.println("Opcion invalida");
                }
            }

            switch (opcion) {
                case 1:
                    servicio.AgregarProducto(entrada, productos);
                    Utilidad.presioneEnterParaContinuar(entrada);
                    Utilidad.dejarEspacio(5);
                    break;
                case 2:
                    servicio.ListarProducto(productos);
                    Utilidad.presioneEnterParaContinuar(entrada);
                    Utilidad.dejarEspacio(5);
                    break;
                case 3:
                    servicio.buscarProductoPorId(entrada, productos);
                    Utilidad.presioneEnterParaContinuar(entrada);
                    Utilidad.dejarEspacio(5);
                    break;
                case 4:
                    servicio.actualizarProducto(entrada,productos);
                    Utilidad.presioneEnterParaContinuar(entrada);
                    Utilidad.dejarEspacio(5);
                    break;
                case 5:
                    servicio.eliminarProductoPorId(entrada,productos);
                    Utilidad.presioneEnterParaContinuar(entrada);
                    Utilidad.dejarEspacio(5);
                    break;
                case 6:
                    servicio.crearPedido(entrada,productos,pedido);
                    Utilidad.presioneEnterParaContinuar(entrada);
                    Utilidad.dejarEspacio(5);
                    break;
                case 7:
                    servicio.listarPedidos(pedido);
                    Utilidad.presioneEnterParaContinuar(entrada);
                    Utilidad.dejarEspacio(5);
                    break;
                case 8:
                    System.out.println(nombreUsuario + " muchas gracias por visitarnos, hasta pronto!!!");
                    break;
                }

                } while(opcion!=8);
          }
      }
