package org.revelo.webapp.jaxws.services;

import jakarta.jws.WebService;
import org.revelo.webapp.jaxws.models.Curso;

import java.util.List;

@WebService
public interface CursoServiceWs {

    List<Curso> listar();

    Curso guardar(Curso curso);
}
