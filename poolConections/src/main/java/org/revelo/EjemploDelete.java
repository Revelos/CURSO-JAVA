package org.revelo;

import org.revelo.modelo.Producto;
import org.revelo.repositorio.ProductoRepositorioImpl;
import org.revelo.repositorio.Repositorio;

public class EjemploDelete {
    public static void main(String[] args) {
        Repositorio<Producto> repositorio = new ProductoRepositorioImpl();

        repositorio.eliminar(4L);
        System.out.println("Eliminado con exito");
    }
}
