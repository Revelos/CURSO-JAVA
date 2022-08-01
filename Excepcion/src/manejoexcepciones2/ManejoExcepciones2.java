package manejoexcepciones2;

import datos.AccesoDatos;
import datos.ImplementacionMysql;
import excepciones.AccesoDatosEx;
import excepciones.LecturaDatosEx;

public class ManejoExcepciones2 {
    public static void main(String[] args) throws AccesoDatosEx {
        AccesoDatos datos = new ImplementacionMysql();
        datos.simularError(false);
        ejecutar(datos,"listar");

        datos.simularError(true);
        System.out.println("");
        ejecutar(datos,"insertar");
    }

    public static void ejecutar(AccesoDatos datos, String accion) {
        if("listar".equals(accion)){
            try{
                datos.listar();
            }catch (LecturaDatosEx ex){
                System.out.println("Error lectura: Procesa la excepcion mas especifica de lectura de datos");
            }catch (AccesoDatosEx ex){
                System.out.println("Error acceso de datos: Procesa la excepcion mas generica de acceso a datos");
            }catch (Exception ex){
                System.out.println("Error general");
            }finally {
                System.out.println("Se ejecuta sin imporar si hubo error");
            }
        } else if ("insertar".equals(accion)) {
            try {
                datos.insertar();
            }catch (AccesoDatosEx ex){
                System.out.println("Error acceso datos: Podemos procesar solo la excepcion mas generica");
            }finally {
                System.out.println("Se ejecutara sin importar si hubo error o no");
            }
        }else{
            System.out.println("No se proporciono ninguna accion");
        }
    }
}


