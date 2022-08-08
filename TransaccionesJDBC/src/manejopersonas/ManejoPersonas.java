package manejopersonas;

import datos.Conexion;
import datos.PersonasJDBC;

import java.sql.Connection;
import java.sql.SQLException;


public class ManejoPersonas {

    public static void main(String[] args) {
        PersonasJDBC personasJDBC = new PersonasJDBC();

        //personasJDBC.insert("Alberto","Juarez");

        //personasJDBC.update(3,"Nombre3","Apellido3");

        //personasJDBC.delete(2);
        Connection conn = null;

       try {
           conn = Conexion.getConnection();
           if(conn.getAutoCommit()){
               conn.setAutoCommit(false);
           }

           PersonasJDBC personas = new PersonasJDBC(conn);

           personas.update(2,"Regreso2","Regreso");

           personas.insert("Miguel2","123456123456123456123456");

           conn.commit();
       }catch (Exception sqle){
          try {
               System.out.println("Entramos al rollback");

               sqle.printStackTrace(System.out);

               conn.rollback();
           }catch (SQLException e){
               e.printStackTrace(System.out);
           }

       }
    }
}
