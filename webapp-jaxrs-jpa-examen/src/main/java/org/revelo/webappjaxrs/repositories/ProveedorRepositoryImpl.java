package org.revelo.webappjaxrs.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.revelo.webappjaxrs.models.Cliente;
import org.revelo.webappjaxrs.models.Proveedor;

import java.util.List;

@RequestScoped
public class ProveedorRepositoryImpl implements ProveedorRepository{

    @Inject
    private EntityManager em;

    @Override
    public List<Proveedor> listar() {
        return em.createQuery("select p from Proveedor p").getResultList();
    }

    @Override
    public Proveedor guardar(Proveedor proveedor) {
        if(proveedor.getId()!=null && proveedor.getId()>0){
            em.merge(proveedor);
        }else{
            em.persist(proveedor);
        }
        return proveedor;
    }

    @Override
    public Proveedor porId(Long id) {
        return em.createQuery("select  p from Proveedor p  where p.id=:id", Proveedor.class).setParameter("id",id).getSingleResult();
    }

    @Override
    public void eliminar(Long id) {
        Proveedor c = porId(id);
        em.remove(c);
    }
}
