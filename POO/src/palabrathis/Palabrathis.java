package palabrathis;

public class Palabrathis {
    public static void main(String[] args) {
        Persona p = new Persona("Juan");
    }
}

class Persona{
    String nombre;

    Persona(String nombre){
        this.nombre = nombre;

        Imprimir i = new Imprimir();
        i.imprimir(this);
    }
}

class Imprimir{

    public void imprimir(Object objeto){
        System.out.println("Imprimir parameto"+objeto.toString());

        System.out.println("Imprimir objeto actual (this)"+this);
    }

}
