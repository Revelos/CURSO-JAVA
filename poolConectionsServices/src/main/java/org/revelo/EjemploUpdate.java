package org.revelo;

import org.revelo.modelo.Producto;
import org.revelo.repositorio.ProductoRepositorioImpl;
import org.revelo.repositorio.Repositorio;

import java.sql.SQLException;
import java.util.Date;

public class EjemploUpdate {

    public static void main(String[] args) {
        Repositorio<Producto> repositorio=null; //= new ProductoRepositorioImpl();

        Producto p = null;
        try {
            p = repositorio.porId(2L);

        p.setNombre("Prueba");
        p.setPrecio(123002);
        repositorio.guardar(p);
        repositorio.listar().forEach(System.out::println);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
