package org.revelo.webappjaxrs.repositories;

import org.revelo.webappjaxrs.models.Cliente;

import java.util.List;

public interface ClienteRepository {
    List<Cliente> listar();

    Cliente guardar(Cliente cliente);

    Cliente porId(Long id);

    void eliminar(Long id);
}
