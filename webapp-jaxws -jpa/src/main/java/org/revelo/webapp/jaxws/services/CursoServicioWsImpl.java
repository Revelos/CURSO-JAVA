package org.revelo.webapp.jaxws.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.revelo.webapp.jaxws.models.Curso;
import org.revelo.webapp.jaxws.repositories.CursoRepository;

import java.util.Arrays;
import java.util.List;

@Stateless
@WebService(endpointInterface = "org.revelo.webapp.jaxws.services.CursoServiceWs")
public class CursoServicioWsImpl implements CursoServiceWs {

    @Inject
    private CursoRepository repository;

    @Override
    @WebMethod
    public List<Curso> listar() {
        return repository.listar();
    }

    @Override
    @WebMethod
    public Curso guardar(Curso curso) {
        return repository.guardar(curso);
    }
}
