package org.revelo.webappjaxrs.controllers;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.revelo.webappjaxrs.models.Cliente;
import org.revelo.webappjaxrs.models.Proveedor;
import org.revelo.webappjaxrs.services.ProveedorService;

import java.util.List;
import java.util.Optional;

@RequestScoped
@Path("/proveedor")
@Produces(MediaType.APPLICATION_JSON)
public class ProveedorRestController {
    @Inject
    private ProveedorService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proveedor> listar(){
        return service.listar();
    }

    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") Long id){
        Optional<Proveedor> clienteOptional = service.porId(id);
        if(clienteOptional.isPresent()){
            return Response.ok(clienteOptional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Proveedor proveedor){
        try {
            Proveedor nuevoProveedor = service.guardar(proveedor);
            return Response.ok(nuevoProveedor).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@PathParam("id") Long id, Proveedor proveedor){
        Optional<Proveedor> cursoOptional = service.porId(id);
        if(cursoOptional.isPresent()){
            Proveedor nuevoProveedor = cursoOptional.get();
            nuevoProveedor.setNombre(proveedor.getNombre());
            nuevoProveedor.setDireccion(proveedor.getDireccion());


            try {
                service.guardar(nuevoProveedor);
                return Response.ok(nuevoProveedor).build();
            }catch (Exception e){
                e.printStackTrace();
                return Response.serverError().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id")Long id){
        Optional<Proveedor> proveedorOptional =service.porId(id);
        if(proveedorOptional.isPresent()){
            try{
                service.eliminar(proveedorOptional.get().getId());
                return Response.noContent().build();
            }catch (Exception e){
                e.printStackTrace();
                return Response.serverError().build();
            }

        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
