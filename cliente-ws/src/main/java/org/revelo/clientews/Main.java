package org.revelo.clientews;


import org.revelo.webapp.jaxws.services.Curso;
import org.revelo.webapp.jaxws.services.ServiceWs;
import org.revelo.webapp.jaxws.services.ServicioWsImplService;

public class Main {
    public static void main(String[] args) {
        ServiceWs service = new ServicioWsImplService().getServicioWsImplPort();
        System.out.println("El saludo: "+ service.saludar("Andres"));

        Curso curso = new Curso();
        curso.setNombre("Angular");
        Curso respuesta = service.crear(curso);
        System.out.println("Nuevo curso: "+ curso.getNombre());

        service.listar().forEach(c -> System.out.println(c.getNombre()));
    }
}
