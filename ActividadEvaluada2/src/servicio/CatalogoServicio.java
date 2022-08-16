package servicio;

import dto.Departamento;
import dto.Empleado;
import jdbc.Conexion;
import repositorio.DepartamentoDaoImpl;
import repositorio.EmpleadoDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CatalogoServicio implements Servicio{

    EmpleadoDaoImpl empleadoDao;
    DepartamentoDaoImpl departamentoDao;


    public CatalogoServicio() {
        this.empleadoDao = new EmpleadoDaoImpl();
        this.departamentoDao = new DepartamentoDaoImpl();
    }


    @Override
    public List<Empleado> listarEmpleado() throws SQLException {
        try(Connection conn= Conexion.getConnection()) {
            empleadoDao.setConn(conn);
            return  empleadoDao.listar();
        }
    }

    @Override
    public Empleado porIdEmpleado(Long id) throws SQLException {
        try(Connection conn = Conexion.getConnection() ) {
            empleadoDao.setConn(conn);
            return empleadoDao.porId(id);
        }
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) throws SQLException {
        try(Connection conn = Conexion.getConnection()){
            empleadoDao.setConn(conn);
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            Empleado nuevoEmpleado = null;
            try{
                nuevoEmpleado=empleadoDao.guardar(empleado);
                conn.commit();
            }catch (SQLException e){
                conn.rollback();
                e.printStackTrace();
            }
            return nuevoEmpleado;
        }
    }

    @Override
    public void eliminarEmpleado(Long id) throws SQLException {
        try(Connection conn = Conexion.getConnection()){
            empleadoDao.setConn(conn);
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try{
                empleadoDao.eliminar(id);
                conn.commit();
            }catch (SQLException e){
                conn.rollback();
                e.printStackTrace();
            }

        }
    }

    @Override
    public List<Departamento> listarDepartamento() throws SQLException {
        try(Connection conn = Conexion.getConnection()){
            departamentoDao.setConn(conn);
            return departamentoDao.listar();
        }
    }

    @Override
    public Departamento porIdDepartamento(Long id) throws SQLException {
        try(Connection conn = Conexion.getConnection() ) {
            departamentoDao.setConn(conn);
            return departamentoDao.porId(id);
        }
    }

    @Override
    public Departamento guardarDepartamento(Departamento departamento) throws SQLException {
        try(Connection conn = Conexion.getConnection()) {
            departamentoDao.setConn(conn);
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            Departamento nuevaDepartamento = null;
            try{
                nuevaDepartamento =departamentoDao.guardar(departamento);
                conn.commit();
            }catch (SQLException e){
                conn.rollback();
                e.printStackTrace();
            }
            return  nuevaDepartamento;
        }
    }

    @Override
    public void eliminarDepartamento(Long id) throws SQLException {
        try(Connection conn = Conexion.getConnection()){
            departamentoDao.setConn(conn);
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try{
                departamentoDao.eliminar(id);
                conn.commit();
            }catch (SQLException e){
                conn.rollback();
                e.printStackTrace();
            }

        }
    }

    @Override
    public void guardarEmpleadoConDepartamento(Empleado empleado, Departamento departamento) throws SQLException {
        try(Connection conn = Conexion.getConnection()){
            empleadoDao.setConn(conn);
            departamentoDao.setConn(conn);
            if(conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }

            try{
                Departamento nuevaDepartamento = departamentoDao.guardar(departamento);
                empleado.setDepartamento(nuevaDepartamento);
                empleadoDao.guardar(empleado);
                conn.commit();
            }catch (SQLException e){
                conn.rollback();
                e.printStackTrace();
            }

        }
    }
}
