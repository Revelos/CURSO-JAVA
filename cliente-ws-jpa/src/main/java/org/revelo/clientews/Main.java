package org.revelo.clientews;

import org.revelo.webapp.jaxws.services.Curso;
import org.revelo.webapp.jaxws.services.CursoServiceWs;
import org.revelo.webapp.jaxws.services.CursoServicioWsImplService;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        CursoServiceWs serviceWs = new CursoServicioWsImplService().getCursoServicioWsImplPort();
        Curso curso = new Curso();
        curso.setNombre("react ");
        curso.setDescripcion("react js ");
        curso.setDuracion(500.0);
        curso.setInstructor("Andres Guardado");
        serviceWs.guardar(curso);

        serviceWs.listar().forEach(curso1 -> System.out.println(curso1.getNombre()));


    }
}
