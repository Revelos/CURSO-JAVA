package cpjllaboratoriofinal;

import jdk.swing.interop.SwingInterOpUtils;
import mx.com.gm.peliculas.negocio.CatalogoPeliculas;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;

import java.util.Scanner;

public class CPJLaboratorioFinal {
    private static Integer opcion = -1;
    private static final String nombreArchivo="C:\\pruebaJava\\prueba.txt";
    private static final CatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        do {
            try {
                System.out.println("BIENVENIDO");
                System.out.println("Seleccione una opcion");
                System.out.println("1.Iniciar catalogo peliculas");
                System.out.println("2.Agregar");
                System.out.println("3.Listar");
                System.out.println("4.Buscar");
                //System.out.println("5.Eliminar");
                System.out.println("0. Salir");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        catalogoPeliculas.iniciarArchivo(nombreArchivo);
                        break;
                    case 2:
                        System.out.println("Ingrese el nombre de la pelicula");
                        String nombre = scanner.next();
                        catalogoPeliculas.agregarPelicula(nombre, nombreArchivo);
                        break;
                    case 3:
                        catalogoPeliculas.listarPeliculas(nombreArchivo);
                        break;
                    case 4:
                        System.out.println("Introduce el nombre de la pelicula a buscar");
                        String search = scanner.next();
                        catalogoPeliculas.buscarPelicula(nombreArchivo, search.trim());
                        break;
                    case 0:
                        System.out.println("Hasta pronto");
                    default:
                        System.out.println("\n");
                }
            }catch (NumberFormatException ex){
                System.out.println("Error!! ");
            }
            scanner.nextLine(); //Limpiamos buffer del System.in
            System.out.println("\n\t\tPRESIONE ENTER PARA CONTINUAR..."); //Mensaje en pantalla
            scanner.nextLine();
            System.out.flush();
        }while (opcion!=0);
    }
}
