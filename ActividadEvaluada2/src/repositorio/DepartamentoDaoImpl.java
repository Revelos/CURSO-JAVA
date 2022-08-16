package repositorio;

import dto.Departamento;
import dto.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDaoImpl implements Repositorio<Departamento> {

    private Connection conn;

    @Override
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Departamento> listar() throws SQLException {
        List<Departamento> departamentos = new ArrayList<>();

        try(Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM departamento");

            while (rs.next()) {
                departamentos.add(crearDepartamento(rs));
            }
        }
        return departamentos;

    }

    @Override
    public Departamento porId(Long id) throws SQLException {
        Departamento departamento = new Departamento();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM departamento WHERE id=?");
        stmt.setLong(1,id);
        try(ResultSet rs = stmt.executeQuery()){
            if(rs.next()){
                departamento = crearDepartamento(rs);
            }
        }

        return departamento;
    }

    @Override
    public Departamento guardar(Departamento departamento) throws SQLException {

        String sql;
        if (departamento.getId() !=null && departamento.getId()>0){
            sql = "UPDATE departamento SET departamento=? WHERE id=?";

        }else{
            sql = "INSERT INTO departamento(departamento)VALUES(?)";

        }

        try(
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            stmt.setString(1, departamento.getDepartamento());


            if(departamento.getId()!=null && departamento.getId()>0){
                stmt.setLong(5,departamento.getId());
            }
            stmt.executeUpdate();
            if(departamento.getId()==null){
                try(ResultSet rs = stmt.getGeneratedKeys()){
                    if(rs.next()){
                        departamento.setId(rs.getLong(1));
                    }
                }
            }
            return departamento;
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try(
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM departamento WHERE id=?")){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }

    }

    private Departamento crearDepartamento(ResultSet rs) throws SQLException {
        Departamento d = new Departamento();
        d.setId(rs.getLong("id"));
        d.setDepartamento(rs.getString("departamento"));
        return d;
    }
}
