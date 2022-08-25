package org.revelo.clientews;

import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.Service;
import org.revelo.webapp.jaxws.services.Curso;
import org.revelo.webapp.jaxws.services.CursoServiceWs;
import org.revelo.webapp.jaxws.services.CursoServicioWsImplService;

import javax.xml.namespace.QName;
import java.net.URL;
import java.util.List;


public class Main {
    public static void main(String[] args) {


         CursoServiceWs serviceWs = new CursoServicioWsImplService().getCursoServicioWsImplPort();
        ((BindingProvider)serviceWs).getRequestContext().put(BindingProvider.USERNAME_PROPERTY,"admin");
        ((BindingProvider)serviceWs).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,"123456");


        Curso curso = new Curso();
        curso.setNombre("react ");
        curso.setDescripcion("react js ");
        curso.setDuracion(500.0);
        curso.setInstructor("Andres Guardado");
        Curso respuesta = serviceWs.guardar(curso);
        System.out.println("Nuevo curso: "+respuesta.getNombre());

        serviceWs.listar().forEach(curso1 -> System.out.println(curso1.getNombre()));


    }
}
