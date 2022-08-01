package personas;

public class Persona {
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;

    public Persona(){
        nombre="Cristian";
        apellidoPaterno="Lopez";
        apellidoMaterno="Revelo";
    }

    public void desplegarNombre(){
        System.out.println("Nombre :"+nombre);
        System.out.println("Apellido Paterno: "+apellidoPaterno);
        System.out.println("Apellido Materno: "+apellidoMaterno);
    }
}
