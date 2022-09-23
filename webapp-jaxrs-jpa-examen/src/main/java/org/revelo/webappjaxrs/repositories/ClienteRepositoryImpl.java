package org.revelo.webappjaxrs.repositories;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.revelo.webappjaxrs.models.Cliente;

import java.util.List;

@RequestScoped
public class ClienteRepositoryImpl implements ClienteRepository {

    @Inject
    private EntityManager em;

    @Override
    public List<Cliente> listar() {
        return em.createQuery("select  c from Cliente c left outer join fetch c.proveedor",Cliente.class).getResultList();
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        if(cliente.getId()!=null && cliente.getId()>0){
            em.merge(cliente);
        }else{
            em.persist(cliente);
        }
        return cliente;
    }

    @Override
    public Cliente porId(Long id) {

        return em.createQuery("select  c from Cliente c left outer join fetch c.proveedor where c.id=:id", Cliente.class).setParameter("id",id).getSingleResult();
    }

    @Override
    public void eliminar(Long id) {
        Cliente c = porId(id);
        em.remove(c);
    }
}
