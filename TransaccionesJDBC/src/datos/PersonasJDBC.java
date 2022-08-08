package datos;

import domain.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene los metodo SELECT, INSERT UPDATE, DELETE para ña tabla de PERSONAS en MYSQL*/


public class PersonasJDBC {

    private Connection userConn;

    private final String SQL_INSERT = "INSERT INTO persona(nombre, apellido) VALUES(?,?)";
    private final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=? WHERE id_persona=?";
    private final String SQL_DELETE = "DELETE FROM persona WHERE  id_persona=?";
    private final String SQL_SELECT = "SELECT *  FROM persona ORDER BY id_persona";


    public PersonasJDBC() {
    }

    public PersonasJDBC(Connection userConn) {
        this.userConn = userConn;
    }

    public int insert(String nombre, String apellido) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs;
        int rows=0;

        try {
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index =1;
            stmt.setString(index++,nombre);
            stmt.setString(index++,apellido);
            System.out.println("Ejecutando query: "+SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados: "+rows);

        }finally {
            Conexion.close(stmt);
            if(this.userConn==null){
                Conexion.close(conn);
            }

        }
        return rows;
    }

    public int update(int id_persona,String nombre,String apellido){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs;
        int rows = 0;
        try {
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            System.out.println("Ejecutando query: "+ SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++,nombre);
            stmt.setString(index++,apellido);
            stmt.setInt(index,id_persona);
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizados: "+rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Conexion.close(stmt);
            if(this.userConn==null){
                Conexion.close(conn);
            }
        }
        return rows;
    }

    public int delete(int id_persona){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs;
        int rows = 0;
        try {
            conn= (this.userConn!=null)?this.userConn:Conexion.getConnection();
            System.out.println("Ejecutando query: "+SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,id_persona);
            stmt.executeUpdate();
            ++rows;
            System.out.println("Registro eliminados: "+rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Conexion.close(stmt);
            if(this.userConn==null){
                Conexion.close(conn);
            }
        }
        return rows;

    }

    public List<Persona> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Persona persona = null;
        List<Persona> personas= new ArrayList<>();
        int rows = 0;
        try {
            conn= (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                int id_persona = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);

                persona = new Persona();
                persona.setId_persona(id_persona);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                personas.add(persona);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if(this.userConn==null){
                Conexion.close(conn);
            }

        }
        return personas;

    }


}
