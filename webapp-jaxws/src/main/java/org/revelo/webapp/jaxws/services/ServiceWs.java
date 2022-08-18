package org.revelo.webapp.jaxws.services;

import jakarta.jws.WebService;
import org.revelo.webapp.jaxws.models.Curso;

import java.util.List;

@WebService
public interface ServiceWs {
    String saludar(String persona);

    List<Curso> listar();

    Curso crear(Curso curso);
}
