package ejemploarreglos;


import java.util.ArrayList;

public class EjemploArreglos {

    public static void main(String[] args) {
        int[] edades;

        edades= new int[3];
        edades[0]=1;
        for (int edad:
             edades) {
            System.out.println(edad!=0?edad:"Vacio");
        }

        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        cars.forEach((car)->{
            System.out.println(car);
        });

    }

} abstract class Productos  {
    private int precio;

    public Productos(int precio) {
        this.precio = precio;
    }
    public int getPrecio(){
        return this.precio;
    }

    public void imprimeAlgo(){
        System.out.println("hola desde abstract");
    }

    public abstract void getName();
}
