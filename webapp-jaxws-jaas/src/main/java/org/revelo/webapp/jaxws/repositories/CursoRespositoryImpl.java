package org.revelo.webapp.jaxws.repositories;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;
import org.revelo.webapp.jaxws.models.Curso;
import java.util.List;


@RequestScoped
public class CursoRespositoryImpl implements CursoRepository{

    @Inject
    private EntityManager em;

    @Override
    public List<Curso> listar() {
        return em.createQuery("select c from Curso c",Curso.class).getResultList();
    }

    @Override
    public Curso guardar(Curso curso) {
        em.persist(curso);
        return curso;
    }
}
