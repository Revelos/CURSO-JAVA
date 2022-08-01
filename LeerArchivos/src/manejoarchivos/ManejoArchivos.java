package manejoarchivos;

import utileria.Archivos;

public class ManejoArchivos {

    private static final String NOMBRE_ARCHIVO = "C:\\pruebaJava\\prueba.txt";

    public static void main(String[] args) {


        Archivos.crearArchivo(NOMBRE_ARCHIVO);

        Archivos.escribirArchivo(NOMBRE_ARCHIVO);

        Archivos.leerArchivo(NOMBRE_ARCHIVO);

        Archivos.anexarArchivo(NOMBRE_ARCHIVO);

        Archivos.leerArchivo(NOMBRE_ARCHIVO);
    }
}
