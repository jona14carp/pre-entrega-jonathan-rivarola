package com.techlab.servicio;

import com.techlab.Utilidad;
import com.techlab.excepciones.IdNotFoundException;
import com.techlab.pedidos.Pedido;
import com.techlab.productos.Producto;

import java.util.List;
import java.util.Scanner;

import static com.techlab.Utilidad.positionId;

public class ProductoService {

    String nombre;
    double precio;
    int stock;
    int id;

    //AGREGAR PRODUCTOS
    public void AgregarProducto(Scanner entrada, List<Producto>productos){


        Utilidad.dejarEspacio(5);
        System.out.println("***************AGREGAR PRODUCTO********************\n");

        System.out.println("Ingrese nombre del producto");
        System.out.println("Nombre: ");
        nombre = entrada.nextLine();

        precio = Utilidad.numeroDoublePostivo(entrada, "Precio: ");

        stock = Utilidad.numeroEnteroPositivo(entrada, "Stock: ");

        Producto producto = new Producto(nombre, precio, stock);

        productos.add(producto);
    }


    //LISTAR PRODUCTO
    public void ListarProducto(List<Producto>productos){
        Utilidad.dejarEspacio(5);
        System.out.println("*****************LISTA DE PRODUCTOS*****************");
        for (Producto p:productos){
            System.out.println(p.toString());
        }
    }

    //BUSCAR PRODUCTO
    public void buscarProductoPorId(Scanner entrada, List<Producto>productos){
        Utilidad.dejarEspacio(5);
        System.out.println("***************** BUSCAR PRODUCTO POR ID******************");

        int posicion = positionId(entrada,productos);

        if (posicion>=0){
            System.out.println(productos.get(posicion).toString());
        }
    }

    //ACTUALIZAR PRODUCTO
    public void actualizarProducto(Scanner entrada, List<Producto>productos){
        Utilidad.dejarEspacio(5);
        System.out.println("**************ACTUALIZAR PRODUCTOS****************");

        int posicion = positionId(entrada,productos);

        if (posicion>=0){
            System.out.println("Esta por actualizar el producto");
            System.out.println(productos.get(posicion).toString());
            System.out.println("Ingrese los nuevos valores\n");
            System.out.println("Nombre: ");
            nombre = entrada.nextLine();

            precio = Utilidad.numeroDoublePostivo(entrada, "Precio: ");

            stock = Utilidad.numeroEnteroPositivo(entrada, "Stock: ");

            productos.get(posicion).setNombre(nombre);
            productos.get(posicion).setPrecio(precio);
            productos.get(posicion).setStock(stock);
        }
    }

    //ELIMINAR PRODUCTO
    public void eliminarProductoPorId(Scanner entrada, List<Producto>productos){
        Utilidad.dejarEspacio(5);
        System.out.println("**************ELIMINAR PRODUCTOS****************");

        int posicion = positionId(entrada,productos);
        String opcion;

        if (posicion>=0){
            System.out.println("Esta por eliminar el producto:");
            System.out.println(productos.get(posicion).toString());
            System.out.println("Confirmar si/no");
            opcion = entrada.nextLine();

            if (opcion.equalsIgnoreCase("si")){
                productos.remove(posicion);
            } else if(opcion.equalsIgnoreCase("no")){
                System.out.println("Se ha cancelado la eliminacion del producto");
            }else{
                System.out.println("La opcion ingresada no es valida");
            }
        }
    }

    //CREAR PEDIDO
    public void crearPedido(Scanner entrada, List<Producto>productos, Pedido pedido){
        Utilidad.dejarEspacio(5);
        System.out.println("**************CREAR PEDIDO****************");

        int posicion = positionId(entrada,productos);
        if (posicion==0){

            System.out.println("Producto solicitado: ");
            System.out.println(productos.get(posicion).toString());

            stock = Utilidad.numeroEnteroPositivo(entrada," Stock solicitado: ");
            if (stock==0){
                System.out.println("No se puede solicitar el stock del pedido porque es 0");
                return;
            }

            if (stock>productos.get(posicion).getStock()){
                System.out.println("No hay stock suficiente");
                return;
            }

            productos.get(posicion).reducirStock(stock);

            int id = productos.get(posicion).getId();
            String nombre = productos.get(posicion).getNombre();
            double precio = productos.get(posicion).getPrecio();


            Producto producto = new Producto(id,nombre,precio,stock);

            pedido.agregarProducto(producto);
        }

    }

    //LISTAR PEDIDOS
    public void listarPedidos(Pedido pedido){
        Utilidad.dejarEspacio(5);
        System.out.println("**************LISTA DE PEDIDOS****************");

        if (pedido.getProductos().isEmpty()){
            System.out.println("La lista de pedidos esta vacia");
        return;
        }

        double total = 0;

        for (Producto p:pedido.getProductos()){
            System.out.println(p.toString());

            total += p.precioTotal();
        }

        System.out.printf("%nPrecio final: $%.2f%n", total);
    }

}
