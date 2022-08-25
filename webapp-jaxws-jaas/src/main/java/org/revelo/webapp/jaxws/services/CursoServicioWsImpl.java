package org.revelo.webapp.jaxws.services;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.revelo.webapp.jaxws.models.Curso;
import org.revelo.webapp.jaxws.repositories.CursoRepository;

import java.util.Arrays;
import java.util.List;

@Stateless
@DeclareRoles({"USER","ADMIN"})
@WebService(endpointInterface = "org.revelo.webapp.jaxws.services.CursoServiceWs")
public class CursoServicioWsImpl implements CursoServiceWs {

    @Inject
    private CursoRepository repository;

    @Override
    @WebMethod
    @RolesAllowed({"USER","ADMIN"})
    public List<Curso> listar() {
        return repository.listar();
    }

    @Override
    @WebMethod
    @RolesAllowed({"ADMIN"})
    public Curso guardar(Curso curso) {
        return repository.guardar(curso);
    }
}
