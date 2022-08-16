import dto.Departamento;
import dto.Empleado;
import servicio.CatalogoServicio;
import servicio.Servicio;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Integer opcion = -1;
    private static final Scanner scanner = new Scanner(System.in);
    private static Servicio cs = new CatalogoServicio();

    public static void main(String[] args) throws SQLException {
        do {
            try {
                System.out.println("BIENVENIDO AL REGISTRO DE NOTAS");
                System.out.println("Seleccione una opcion");
                System.out.println("1. Agregar empleado");
                System.out.println("2. Agregar departamento");
                System.out.println("3. Agregar empleado y departamento");
                System.out.println("4. Listar departamentos");
                System.out.println("5. Lista empleados");
                System.out.println("6. Modificar empleado");
                System.out.println("7. Modificar departamento");
                System.out.println("8. Eliminar empleado");
                System.out.println("9. Eliminar departamento");
                System.out.println("0. Salir");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nombre del empleado");
                        String nombre = scanner.next();
                        System.out.println("Ingrese el apellido del empleado");
                        String apellido = scanner.next();
                        System.out.println("Ingrese el la direccion del empleado");
                        String direccion = scanner.next();
                        System.out.println("Ingrese el la email del empleado");
                        String email = scanner.next();
                        System.out.println("Seleccione algun departamento ");
                        cs.listarDepartamento().forEach((departamento -> {
                            System.out.println(departamento.getId()+". "+departamento.getDepartamento()+" ");
                        }));
                        String depa_id = scanner.next();
                        Departamento d = cs.porIdDepartamento(Long.valueOf(depa_id));
                        System.out.println(depa_id);
                        Empleado em = new Empleado(nombre,apellido,direccion,email,d);
                        cs.guardarEmpleado(em);
                        break;
                    case 2:
                        System.out.println("Ingrese el nombre del departamento");
                        String departamento = scanner.next();
                        Departamento depa = new Departamento();
                        depa.setDepartamento(departamento);
                        cs.guardarDepartamento(depa);
                        break;
                    case 3:
                        System.out.println("Ingrese el nombre del empleado");
                        String name = scanner.next();
                        System.out.println("Ingrese el apellido del empleado");
                        String lastName = scanner.next();
                        System.out.println("Ingrese el la direccion del empleado");
                        String address = scanner.next();
                        System.out.println("Ingrese el la email del empleado");
                        String mail = scanner.next();
                        Empleado emple = new Empleado(name,lastName,address,mail);
                        System.out.println("Ingrese el nombre del departamento");
                        String departament = scanner.next();
                        Departamento depar = new Departamento();
                        depar.setDepartamento(departament);
                        cs.guardarEmpleadoConDepartamento(emple,depar);

                        break;
                    case 4:
                       cs.listarDepartamento().forEach(System.out::println);
                        break;
                    case 5:
                        cs.listarEmpleado().forEach(System.out::println);
                        break;
                    case 6:
                        //La aplicacion de modificar esta en clase Modificar
                        break;
                    case 7:
                        //La aplicacion de modificar esta en clase Modificar
                        break;
                    case 8:
                        System.out.println("Ingrese el id del empleado");
                        String id = scanner.next();
                        cs.eliminarEmpleado(Long.valueOf(id));
                        System.out.println("Se elimino correctamente");
                        break;
                    case 9:
                        System.out.println("Ingrese el id del departamento");
                        String id_de = scanner.next();
                        cs.eliminarDepartamento(Long.valueOf(id_de));
                        System.out.println("Se elimino correctamente");
                        break;
                    case 0:
                        System.out.println("Hasta pronto");
                    default:
                        System.out.println("\n");
                }
            }catch (InputMismatchException ex){
                System.out.println("Error de entrada de datos!! ");
            }
            scanner.nextLine(); //Limpiamos buffer del System.in
            System.out.println("\n\t\tPRESIONE ENTER PARA CONTINUAR..."); //Mensaje en pantalla
            scanner.nextLine();
            System.out.flush();
        }while (opcion!=0);

    }
}
