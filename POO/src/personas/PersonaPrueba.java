package personas;

public class PersonaPrueba {
    public static void main(String[] args) {
        Persona p1 = new Persona();

        System.out.println("Valores por default del objeto Persona");
        p1.desplegarNombre();

        p1.nombre = "Juan";
        p1.apellidoPaterno = "Esparza";
        p1.apellidoMaterno = "Lara";

        System.out.println("\nNuevos valores del objeto Persona");
        p1.desplegarNombre();
    }
}
