package org.revelo.webappjaxrs.services;

import jakarta.ejb.Local;
import org.revelo.webappjaxrs.models.Cliente;
import org.revelo.webappjaxrs.models.Proveedor;

import java.util.List;
import java.util.Optional;

@Local
public interface ProveedorService {
    List<Proveedor> listar();

    Proveedor guardar(Proveedor proveedor);

    Optional<Proveedor> porId(Long id);

    void eliminar(Long id);
}
