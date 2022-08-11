package org.revelo;

import org.revelo.jdbc.ConexionBaseDatos;
import org.revelo.modelo.Categoria;
import org.revelo.modelo.Producto;
import org.revelo.repositorio.CategoriaRepositorioImpl;
import org.revelo.repositorio.ProductoRepositorioImpl;
import org.revelo.repositorio.Repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {

        try(Connection conn = ConexionBaseDatos.getConnection()) {
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }

            try {
                Repositorio<Producto> repositorio = new ProductoRepositorioImpl(conn);
                Repositorio<Categoria> repositorio1 = new CategoriaRepositorioImpl(conn);
                Categoria categoria = new Categoria();
                categoria.setNombre("Vehiculos");
                Categoria nuevaCategoria = repositorio1.guardar(categoria);
                //conn.commit();
                System.out.println("======== listar ===========");

                repositorio.listar().forEach(producto -> System.out.println(producto));


                System.out.println("====== obtener por ID =========");
                System.out.println(repositorio.porId(1L));

                System.out.println("====== insertar nuevo producto ========");
                Producto producto = new Producto();
                producto.setNombre("Notebook Omen HP");
                producto.setPrecio(2900);
                producto.setFechaRegistro(new Date());
                producto.setSku("prueba123");

                /*Categoria categoria = new Categoria();
                categoria.setId(3L);*/
                producto.setCategoria(nuevaCategoria);
                repositorio.guardar(producto);
                System.out.println("Producto guardado con exito");
                repositorio.listar().forEach(System.out::println);
                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        }
    }
}
