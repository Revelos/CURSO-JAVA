package datos;

import excepciones.*;

public class ImplementacionMysql implements AccesoDatos{

    private boolean simularError;



    @Override
    public void insertar() throws AccesoDatosEx {
        if (simularError){
            throw  new EscrituraDatosEx("Error de escritura de datos");
        }else{
            System.out.println("Insertar desde Mysql");
        }
    }

    @Override
    public void listar() throws AccesoDatosEx {
        if (simularError){
            throw new LecturaDatosEx("Error de lectura de datos");
        }else{
            System.out.println("Listar datos desde Mysql");
        }
    }

    @Override
    public void simularError(boolean simularError) throws AccesoDatosEx {
        this.simularError=simularError;
    }

    public boolean isSimularError(){
        return simularError;
    }
}
