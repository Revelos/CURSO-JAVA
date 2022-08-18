package org.revelo.webapp.jaxws.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.revelo.webapp.jaxws.models.Curso;

import java.util.Arrays;
import java.util.List;

@WebService(endpointInterface = "org.revelo.webapp.jaxws.services.ServiceWs")
public class ServicioWsImpl implements ServiceWs{

    private  int contador;

    @Override
    @WebMethod
    public String saludar(String persona) {
        System.out.println("Imprimir dentro del servicio web con instancia: "+this);
        contador++;
        System.out.println("Valor del contador en metodo saludar es "+contador);

        return "Hola que tal "+persona;
    }

    @Override
    @WebMethod
    public List<Curso> listar() {
        return Arrays.asList(new Curso("Java"),new Curso("Spring"),new Curso("Jakarta"));
    }

    @Override
    @WebMethod
    public Curso crear(Curso curso) {
        System.out.println("Curso guardado con exito ... "+curso.getNombre());
        Curso nuevoCurso = new Curso();
        nuevoCurso.setNombre(curso.getNombre());
        return nuevoCurso;
    }
}
