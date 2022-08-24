package org.revelo.webappjaxrs.repositories;


import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.revelo.webappjaxrs.models.Curso;

import java.util.List;

@RequestScoped
@DeclareRoles({"USER","ADMIN"})
public class CursoRepositoryImpl implements CursoRepository{

    @Inject
    private EntityManager em;

    @Override
    @RolesAllowed({"USER","ADMIN"})
    public List<Curso> listar() {
        return em.createQuery("select  c from Curso c left outer join fetch c.instructor",Curso.class).getResultList();
    }

    @Override
    @RolesAllowed({"ADMIN"})
    public Curso guardar(Curso curso) {
        if(curso.getId()!=null && curso.getId()>0){
            em.merge(curso);
        }else{
            em.persist(curso);
        }
        return curso;
    }

    @Override
    @RolesAllowed({"USER","ADMIN"})
    public Curso porId(Long id) {

        return em.createQuery("select  c from Curso c left outer join fetch c.instructor where c.id=:id",Curso.class).setParameter("id",id).getSingleResult();
    }

    @Override
    @RolesAllowed({"ADMIN"})
    public void eliminar(Long id) {
        Curso c = porId(id);
        em.remove(c);
    }
}
