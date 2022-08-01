package datos;

import excepciones.AccesoDatosEx;

public interface AccesoDatos {

    void insertar() throws AccesoDatosEx;

    void listar() throws AccesoDatosEx;

    void simularError(boolean h) throws AccesoDatosEx;
}
