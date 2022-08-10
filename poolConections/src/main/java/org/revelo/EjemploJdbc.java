package org.revelo;

import org.revelo.modelo.Categoria;
import org.revelo.modelo.Producto;
import org.revelo.repositorio.ProductoRepositorioImpl;
import org.revelo.repositorio.Repositorio;

import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {
        Repositorio<Producto> repositorio = new ProductoRepositorioImpl();

        System.out.println("======== listar ===========");
        repositorio.listar().forEach(producto -> System.out.println(producto));

        System.out.println("====== obtener por ID =========");
        System.out.println(repositorio.porId(1L));

        System.out.println("====== insertar nuevo producto ========");
        Producto producto = new Producto();
        producto.setNombre("Notebook Omen HP");
        producto.setPrecio(2900);
        producto.setFechaRegistro(new Date());
        Categoria categoria = new Categoria();
        categoria.setId(3L);
        producto.setCategoria(categoria);
        repositorio.guardar(producto);
        System.out.println("Producto guardado con exito");
        repositorio.listar().forEach(System.out::println);
    }
}
