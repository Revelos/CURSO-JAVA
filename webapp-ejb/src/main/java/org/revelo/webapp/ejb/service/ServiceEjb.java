package org.revelo.webapp.ejb.service;

import jakarta.ejb.Stateless;
import org.revelo.webapp.ejb.models.Producto;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class ServiceEjb implements ServiceEjbLocal{
    private int contador;

    @Override
    public  String saludar(String nombre){
        System.out.println("Imprimiendo dentro del ejb con instancia: "+ this);
        contador++;
        System.out.println("Valor del contador en metodo saludar "+contador);
        return "Hola que tal "+nombre;
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("peras"));
        productos.add(new Producto("manzanas"));
        productos.add(new Producto("naranjas"));
        productos.add(new Producto("melocotones"));
        productos.add(new Producto("peras"));
        return productos;
    }

    @Override
    public Producto crear(Producto producto) {
        System.out.println("Guardando producto... "+producto);
        Producto p = new Producto();
        p.setNombre(producto.getNombre());
        return p;
    }
}
