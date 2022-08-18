package org.revelo.webapp.jaxws.repositories;

import org.revelo.webapp.jaxws.models.Curso;

import java.util.List;

public interface CursoRepository {


    List<Curso> listar();

    Curso guardar(Curso curso);
}
