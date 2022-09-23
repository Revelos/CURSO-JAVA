package org.revelo.webappjaxrs.services;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Local;
import org.revelo.webappjaxrs.models.Cliente;

import java.util.List;
import java.util.Optional;

@Local
@RolesAllowed({"ADMIN","USER"})
public interface ClienteService {


    List<Cliente> listar();

    Cliente guardar(Cliente cliente);

    Optional<Cliente> porId(Long id);

    void eliminar(Long id);
}
