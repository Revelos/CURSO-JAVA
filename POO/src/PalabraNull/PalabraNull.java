package PalabraNull;

public class PalabraNull {
    public static void main(String[] args) {
        Persona p1 = new Persona("Juan");

        System.out.println(p1.obtenerNombre());

    }
}

class Persona{
    private String nombre;
    public Persona(String nombre){
        this.nombre = nombre;
    }

    public String obtenerNombre(){
        return this.nombre;
    }
}
