package org.revelo.webappjaxrs.services;

import jakarta.ejb.Local;
import org.revelo.webappjaxrs.models.Curso;

import java.util.List;
import java.util.Optional;

@Local
public interface CursoService {

    List<Curso> listar();

    Curso guardar(Curso curso);

    Optional<Curso> porId(Long id);

    void eliminar(Long id);
}
