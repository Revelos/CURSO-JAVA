package repositorio;

import dto.Departamento;
import dto.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDaoImpl implements  Repositorio<Empleado> {

    private Connection conn;

    @Override
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Empleado> listar() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();

        try(Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("select e.*,d.departamento from rh.empleado as e inner join rh.departamento as d on e.id_departamento=d.id");

            while (rs.next()) {
                empleados.add(crearEmpleado(rs));
            }
        }
        return empleados;

    }

    @Override
    public Empleado porId(Long id) throws SQLException {
        Empleado empleado = null;
        try(PreparedStatement stmt = conn.prepareStatement("select e.*,d.departamento from rh.empleado as e inner join rh.departamento as d on e.id_departamento=d.id where e.id=?")){
        stmt.setLong(1,id);
        ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                empleado = crearEmpleado(rs);
            }
        }

        return empleado;
    }

    @Override
    public Empleado guardar(Empleado empleado) throws SQLException {

        String sql;
        if (empleado.getId() !=null && empleado.getId()>0){
            sql = "UPDATE empleado SET nombre=?,apellido=?,direccion=?,email=?,id_departamento=? WHERE id=?";

        }else{
            sql = "INSERT INTO empleado(nombre,apellido,direccion,email,id_departamento)VALUES(?,?,?,?,?)";

        }

        try(
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ){
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2,empleado.getApellido());
            stmt.setString(3,empleado.getDireccion());
            stmt.setString(4,empleado.getEmail());
            stmt.setLong(5,empleado.getDepartamento().getId());

            if(empleado.getId()!=null && empleado.getId()>0){
                stmt.setLong(6,empleado.getId());
            }
            stmt.executeUpdate();
            if(empleado.getId()==null){
                try(ResultSet rs = stmt.getGeneratedKeys()){
                    if(rs.next()){
                        empleado.setId(rs.getLong(1));
                    }
                }
            }
            return empleado;
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try(
                PreparedStatement stmt = conn.prepareStatement("DELETE FROM empleado WHERE id=?")){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }

    }

    private Empleado crearEmpleado(ResultSet rs) throws SQLException {
        Empleado c = new Empleado();
        c.setId(rs.getLong("id"));
        c.setNombre(rs.getString("nombre"));
        c.setApellido(rs.getString("apellido"));
        c.setDireccion(rs.getString("direccion"));
        c.setEmail(rs.getString("email"));
        Departamento depa = new Departamento();
        depa.setId(rs.getLong("id_departamento"));
        depa.setDepartamento(rs.getString("departamento"));
        c.setDepartamento(depa);
        return c;
    }
}
