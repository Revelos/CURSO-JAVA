package test;

import herencia.*;

import java.util.Date;
public class TestHerencia {

    public static void main(String[] args) {

        Empleado emp1 = new Empleado("Cristian Revelo",123);
        Empleado emp2 = new Empleado("Cristian Revelo",123);
        //System.out.println(Empleado.contadorEmpleado +""+ emp1);
        //imprimir(emp1);
        Cliente cliente1 = new Cliente("Cristian",'M',24,"San Salvador",new Date(),true);
        //System.out.println(cliente1.obtenerDetalles());
        //imprimir(cliente1);


    }
    public static void imprimir(Persona persona){
        System.out.println(persona.obtenerDetalles());
    }
}
