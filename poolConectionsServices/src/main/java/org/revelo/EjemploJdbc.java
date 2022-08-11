package org.revelo;

import org.revelo.jdbc.ConexionBaseDatos;
import org.revelo.modelo.Categoria;
import org.revelo.modelo.Producto;
import org.revelo.repositorio.CategoriaRepositorioImpl;
import org.revelo.repositorio.ProductoRepositorioImpl;
import org.revelo.repositorio.Repositorio;
import org.revelo.servicio.CatalogoServicio;
import org.revelo.servicio.Servicio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {

        Servicio servicio = new CatalogoServicio();
        System.out.println("============== LISTAR ===============");
        servicio.listar().forEach(System.out::println);
        Categoria categoria = new Categoria();
        categoria.setNombre("Iluminacion");

        Producto producto = new Producto();
        producto.setNombre("Lampara led escritorio");
        producto.setPrecio(990);
        producto.setFechaRegistro(new Date());
        producto.setSku("asdfghjklñ123");
        servicio.guardarProductoConCategoria(producto,categoria);
        System.out.println("Producto guardado con exito: "+ producto.getId());
        servicio.listar().forEach(System.out::println);
    }
}
