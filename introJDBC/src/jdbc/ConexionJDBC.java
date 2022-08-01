package jdbc;

import java.sql.*;

public class ConexionJDBC {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sga?useSSL=false";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conexion = (Connection) DriverManager.getConnection(url,"root","admin");
            //Se ocupa para cualquier sentencia
            Statement instruccion = conexion.createStatement();

            String sql = "select * from persona";
            String sql2 = "insert into persona(nombre, apellido) values ('Nancy','Lopez')";

            instruccion.executeUpdate(sql2);

            //Creamos un objeto ResultSet y se le asigna la respues de la consulta
            ResultSet rs = instruccion.executeQuery(sql);

            while (rs.next()){
                System.out.print("ID:"+ rs.getInt(1));
                System.out.print(" Nombre: "+rs.getString(2));
                System.out.print(" Apellido: "+ rs.getString(3));
                System.out.println("");
            }
            rs.close();
            instruccion.close();
            conexion.close();

        }catch ( ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }
}
