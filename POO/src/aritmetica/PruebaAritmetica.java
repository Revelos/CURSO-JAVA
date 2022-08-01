package aritmetica;

import org.w3c.dom.ls.LSOutput;

public class PruebaAritmetica {


    public static void main(String[] args) {
        int operandoA = 6;
        int operandoB = 2;


        Aritmetica obj1 = new Aritmetica(operandoA,operandoB);
        System.out.println("Operando A: "+operandoA+" y operandoB: "+operandoB);
        System.out.println("\nResultado suma: "+obj1.Sumar());
        System.out.println("\nResultado resta: "+obj1.Restar());
        System.out.println("\nResultado multiplicacion: "+obj1.Multiplicar());
        System.out.println("\nResultado dividir: "+obj1.Dividir());
    }
}
