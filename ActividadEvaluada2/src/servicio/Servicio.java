package servicio;

import dto.Departamento;
import dto.Empleado;

import java.sql.SQLException;
import java.util.List;

public interface Servicio {


    List<Empleado> listarEmpleado() throws SQLException;

    Empleado porIdEmpleado(Long id) throws SQLException;

    Empleado guardarEmpleado(Empleado empleado) throws SQLException;

    void eliminarEmpleado(Long id) throws SQLException;

    List<Departamento> listarDepartamento() throws SQLException;

    Departamento porIdDepartamento(Long id) throws SQLException;

    Departamento guardarDepartamento(Departamento departamento) throws SQLException;

    void eliminarDepartamento(Long id) throws SQLException;



    void guardarEmpleadoConDepartamento(Empleado empleado, Departamento departamento) throws SQLException;


}
