package palabrareturnclases;

public class PalabraReturnClases {
    public static void main(String[] args) {
        Suma s = crearObjetoSuma();
        int resultado = s.a + s.b;
        System.out.println("Resultado: "+resultado);
    }

    public  static Suma crearObjetoSuma(){
        Suma s = new Suma(3,4);
        return s;
    }
}

class Suma{
    int a;
    int b;

    public Suma(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
