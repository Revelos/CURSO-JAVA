package org.revelo.webappjaxrs.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.revelo.webappjaxrs.models.Proveedor;
import org.revelo.webappjaxrs.repositories.ProveedorRepository;

import java.util.List;
import java.util.Optional;

@Stateless
public class ProveedorServiceImpl implements ProveedorService{

    @Inject
    private ProveedorRepository repo;

    @Override
    public List<Proveedor> listar() {
        return repo.listar();
    }

    @Override
    public Proveedor guardar(Proveedor proveedor) {
        return repo.guardar(proveedor);
    }

    @Override
    public Optional<Proveedor> porId(Long id) {
        return Optional.ofNullable(repo.porId(id));
    }

    @Override
    public void eliminar(Long id) {
        repo.eliminar(id);
    }
}
