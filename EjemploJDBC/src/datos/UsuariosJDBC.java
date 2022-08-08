package datos;

import domain.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosJDBC {
    private Connection userConn;
    private final String SQL_INSERT = "INSERT INTO usuario(usuario, password) VALUES(?,?)";
    private final String SQL_UPDATE = "UPDATE usuario SET usuario=?, password=? WHERE id_usuario=?";
    private final String SQL_DELETE = "DELETE FROM usuario WHERE  id_usuario=?";
    private final String SQL_SELECT = "SELECT *  FROM usuario ORDER BY id_usuario";

    public UsuariosJDBC() {
    }

    public UsuariosJDBC(Connection userConn) {
        this.userConn = userConn;
    }

    public int insert(String usuario, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs;
        int rows=0;

        try {
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index =1;
            stmt.setString(index++,usuario);
            stmt.setString(index++,password);
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

    public int update(int id_usuario,String usuario,String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs;
        int rows = 0;
        try {
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            System.out.println("Ejecutando query: "+ SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++,usuario);
            stmt.setString(index++,password);
            stmt.setInt(index,id_usuario);
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

    public int delete(int id_usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs;
        int rows = 0;
        try {
            conn= (this.userConn!=null)?this.userConn:Conexion.getConnection();
            System.out.println("Ejecutando query: "+SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,id_usuario);
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

    public List<Usuario> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        Usuario usuario = null;
        List<Usuario> personas= new ArrayList<>();
        int rows = 0;
        try {
            conn= (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                int id_persona = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);

                usuario = new Usuario();
                usuario.setId_usuario(id_persona);
                usuario.setUsuario(nombre);
                usuario.setPassword(apellido);
                personas.add(usuario);
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
