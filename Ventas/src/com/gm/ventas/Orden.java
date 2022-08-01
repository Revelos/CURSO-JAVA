package com.gm.ventas;

import java.util.Arrays;

public class Orden {
    private int idOrden;
    private Producto[] productos;
    private static int contadorOrden;
    private static int contadorProducto;

    private static final int maxProductos = 10;

    public Orden() {
        this.idOrden=++Orden.contadorOrden;
        this.productos= new Producto[maxProductos];
    }

    public boolean agregarProducto(Producto producto){
        if(contadorProducto<maxProductos){
            productos[contadorProducto]=producto;
            ++Orden.contadorProducto;
            return true;
        }else{
            System.out.println("Se ha superado el maximo de productos");
        }
     return false;
    }

    public double calcularTotal(){
        double total = 0;
        for(Producto producto: productos){
            if(producto==null)break;
            total += producto.getPrecio();
        }
        return total;
    }

    public void mostrarOrden(){
        System.out.println("ORDEN # "+this.idOrden+"\n");
        for(Producto producto: productos){
            if(producto==null)break;
            System.out.println(producto);
        }
        
        System.out.println("TOTAL: "+ calcularTotal());
    }


}
