package manejoexcepciones;

import datos.ImplementacionCalculadora;
import datos.Operaciones;
import excepciones.ValidarNumeros;

public class CalculadoraExecpciones {

    public static void main(String[] args) {
        Operaciones op = new ImplementacionCalculadora(5);

        try {
            //op.logaritmo();
            op.raizCuadrada();
        } catch (ValidarNumeros e) {
            System.out.println("Error en numero");
            e.printStackTrace();
        }catch (NumberFormatException nfe){
            System.out.println("Error de tipo de entrada de datos");
            nfe.printStackTrace();
        }catch (Exception e){

        }
    }
}
