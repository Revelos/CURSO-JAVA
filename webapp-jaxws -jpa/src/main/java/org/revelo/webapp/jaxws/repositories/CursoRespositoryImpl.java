package org.revelo.webapp.jaxws.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.revelo.webapp.jaxws.models.Curso;

import java.util.List;

@RequestScoped
public class CursoRespositoryImpl implements CursoRepository{

    @PersistenceContext(unitName = "ejemploJPA")
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
