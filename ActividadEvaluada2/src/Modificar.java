import dto.Departamento;
import dto.Empleado;
import servicio.CatalogoServicio;
import servicio.Servicio;

import java.sql.SQLException;

public class Modificar {
    public static void main(String[] args) throws SQLException {
        Servicio servicio = new CatalogoServicio();
        System.out.println("============== MODIFICAR ===============");
        Empleado emple = servicio.porIdEmpleado(2L);
        Departamento departamento = servicio.porIdDepartamento(2L);
        emple.setEmail("djskdskdjksdskjdksdjksdjksdjskdjksdksdjskjddsds");
        emple.setDepartamento(departamento);
        servicio.guardarEmpleado(emple);
        servicio.listarEmpleado().forEach(System.out::println);

    }
}
