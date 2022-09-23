package org.revelo.webappjaxrs.repositories;

import org.revelo.webappjaxrs.models.Cliente;
import org.revelo.webappjaxrs.models.Proveedor;

import java.util.List;

public interface ProveedorRepository {
    List<Proveedor> listar();

    Proveedor guardar(Proveedor proveedor);

    Proveedor porId(Long id);

    void eliminar(Long id);
}
