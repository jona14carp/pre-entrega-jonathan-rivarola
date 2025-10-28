package com.techlab.pedidos;

import com.techlab.Utilidad;
import com.techlab.productos.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pedido {

   private List<Producto>productos = new ArrayList<>();

   public List<Producto> getProductos() {
      return productos;
   }

   public void setProductos(List<Producto> productos) {
      this.productos = productos;
   }

   public void agregarProducto(Producto producto){

      for (Producto p : productos){
         if(p.getId() == producto.getId()){
            p.setStock(p.getStock()+producto.getStock());
            return;
         }
      }
      productos.add(producto);
   }
}
