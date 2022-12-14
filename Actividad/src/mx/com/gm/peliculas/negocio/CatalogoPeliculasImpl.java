package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.datos.*;
import mx.com.gm.peliculas.domain.*;
import mx.com.gm.peliculas.excepciones.*;


import java.util.List;

public class CatalogoPeliculasImpl implements CatalogoPeliculas{

    private final AccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos=new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(nombreArchivo);
            datos.escribir(pelicula, nombreArchivo, anexar);
        }catch (AccesoDatosEx ex){
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        try {
            List<Pelicula> peliculas = datos.listar(nombreArchivo);
            for(Pelicula pelicula:peliculas){
                System.out.println("Pelicula: "+pelicula);
            }
        }catch (AccesoDatosEx ex){
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }

    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
        String resultado = null;
        try{
            resultado = datos.buscar(nombreArchivo, buscar);
        }catch (LecturaDatosEx ex){
            System.out.println("Error al buscar la pelicula");
            ex.printStackTrace();
        }
        System.out.println("Resultado de busqueda: "+ resultado);
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try{
            if(datos.existe(nombreArchivo)){
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            }else{
                datos.crear(nombreArchivo);
            }
        }catch (AccesoDatosEx ex){
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }
}
