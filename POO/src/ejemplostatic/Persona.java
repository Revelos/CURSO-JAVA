package ejemplostatic;

public class Persona {
    private String nombre;
    private int idPersona;
    private static int contadorPersonas;

    public Persona(String nombre){
        contadorPersonas++;
        idPersona = contadorPersonas;

        this.nombre=nombre;
    }

    public Persona() {

    }

    public static int getContadorPersonas(){
        return Persona.contadorPersonas;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", idPersona=" + idPersona +
                '}';
    }
}
