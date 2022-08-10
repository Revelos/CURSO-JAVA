package usuarios.jdbc;

import usuarios.dto.UsuarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoJDBC implements UsuarioDao{
    private Connection userConn;
    private final String SQL_INSERT = "INSERT INTO usuario(usuario, password, email) VALUES(?,?,?)";
    private final String SQL_UPDATE = "UPDATE usuario SET usuario=?, password=?,email=? WHERE id_persona=?";
    private final String SQL_DELETE = "DELETE FROM usuario WHERE  id_persona=?";
    private final String SQL_SELECT = "SELECT *  FROM usuario ORDER BY id_persona";

    public UsuarioDaoJDBC() {
    }

    public UsuarioDaoJDBC(Connection userConn) {
        this.userConn = userConn;
    }

    @Override
    public int insert(UsuarioDTO usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs;
        int rows=0;

        try {
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            int index =1;
            stmt.setString(index++,usuario.getUsuario());
            stmt.setString(index++,usuario.getPassword());
            stmt.setString(index,usuario.getEmail());
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
    @Override
    public int update(UsuarioDTO usuario) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs;
        int rows = 0;
        try {
            conn = (this.userConn!=null)?this.userConn:Conexion.getConnection();
            System.out.println("Ejecutando query: "+ SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            int index = 1;
            stmt.setString(index++,usuario.getUsuario());
            stmt.setString(index++,usuario.getPassword());
            stmt.setString(index++,usuario.getEmail());
            stmt.setInt(index,usuario.getId_usuario());

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
    @Override
    public int delete(UsuarioDTO usuario) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs;
        int rows = 0;
        try {
            conn= (this.userConn!=null)?this.userConn:Conexion.getConnection();
            System.out.println("Ejecutando query: "+SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,usuario.getId_usuario());
            rows= stmt.executeUpdate();

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
    @Override
    public List<UsuarioDTO> select() throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs= null;
        UsuarioDTO user = null;
        List<UsuarioDTO> usuarios= new ArrayList<>();
        int rows = 0;
        try {
            conn= (this.userConn!=null)?this.userConn:Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                int id_usuario = rs.getInt(1);
                String usuario = rs.getString(2);
                String password = rs.getString(3);
                String email = rs.getString(4);

                user = new UsuarioDTO();
                user.setId_usuario(id_usuario);
                user.setUsuario(usuario);
                user.setPassword(password);
                user.setEmail(email);
                usuarios.add(user);
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
        return usuarios;

    }
}
