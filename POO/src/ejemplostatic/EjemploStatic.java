package ejemplostatic;

public class EjemploStatic {
    public static void main(String[] args) {

        Persona p1 = new Persona("Juan");

        System.out.println("Persona 1 "+p1);

        Persona p2 = new Persona("Karla");
        System.out.println("Persona 2:"+p2);

        System.out.println("No. Personas: "+ Persona.getContadorPersonas());
    }
}
