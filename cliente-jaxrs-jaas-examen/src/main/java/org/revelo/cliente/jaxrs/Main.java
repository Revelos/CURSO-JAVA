package org.revelo.cliente.jaxrs;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.internal.BasicAuthentication;
import org.revelo.cliente.jaxrs.models.Cliente;
import org.revelo.cliente.jaxrs.models.Curso;
import org.revelo.cliente.jaxrs.models.Proveedor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget rootUri = client.target("http://127.0.0.1:8081/webapp-jaxrs-jpa-examen/api").path("/clientes");
        WebTarget rootUriPro = client.target("http://127.0.0.1:8081/webapp-jaxrs-jpa-examen/api").path("/proveedor");
        rootUri.register(new BasicAuthentication("admin","123456"));
        rootUriPro.register(new BasicAuthentication("admin","123456"));

       /*System.out.println("================Creando un nuevo proveedor");
        Proveedor nuevoProveedor = new Proveedor();
        nuevoProveedor.setNombre("Dell Company");
        nuevoProveedor.setDireccion("Ilopango, San Salvador");
        Entity<Proveedor> eH = Entity.entity(nuevoProveedor,MediaType.APPLICATION_JSON);
        Proveedor proveedor=rootUriPro.request(MediaType.APPLICATION_JSON).post(eH,Proveedor.class);

        System.out.println("EL proveedor se creo exitoxamente");



        System.out.println("================ por id");
        //si queremos mostrar un xml, cambiarlo y usar _request(MediaType.APPLICATION_JSON)_esta solicitando esto
        Response response = rootUri.path("/1").request(MediaType.APPLICATION_JSON).get();

        Cliente curso = response.readEntity(Cliente.class);
        System.out.println(curso);
        System.out.println(response.getStatus());
        System.out.println(response.getMediaType());

        System.out.println("================= listando");
        listar(rootUri);

        System.out.println("================= creando cliente");
        Cliente clienteNuevo = new Cliente();
        clienteNuevo.setId(6L);
        clienteNuevo.setNombre("Spring Cloud");
        clienteNuevo.setApellido("spring cloud eureka");
        clienteNuevo.setProveedor(proveedor);

        Entity<Cliente> entityHeader = Entity.entity(clienteNuevo, MediaType.APPLICATION_JSON);


        curso = rootUri.request(MediaType.APPLICATION_JSON).post(entityHeader,Cliente.class);
        System.out.println(curso);

        listar(rootUri);*/

        /*System.out.println("========== Editando");
        Response resp = rootUriPro.path("/1").request(MediaType.APPLICATION_JSON).get();
        Proveedor provee = resp.readEntity(Proveedor.class);
        Proveedor proEditado = provee;
        proEditado.setNombre("Revelo Companny");
        //Cliente clienteEditado = curso;
        //clienteEditado.setProveedor(provee);
        Entity<Proveedor> entityHeaderPro = Entity.entity(proEditado, MediaType.APPLICATION_JSON);
        //entityHeader = Entity.entity(proEditado,MediaType.APPLICATION_JSON);
        Proveedor p = rootUriPro.path("/"+provee.getId()).request().put(entityHeaderPro,Proveedor.class);

        System.out.println(p);

        listar(rootUri);*/

       System.out.println("========= Eliminado");
        Response re = rootUriPro.path("/"+1L)
                .request()
                .delete();
        //System.out.println(re.getStatus()+" "+re.getStatusInfo());

        listar(rootUri);
    }

    private static void listar(WebTarget rootUri){
        System.out.println("================================= lista actualizada");

        Response response;
        response = rootUri.request(MediaType.APPLICATION_JSON).get();
        List<Cliente> clientes = response.readEntity(new GenericType<List<Cliente>>(){});
        clientes.forEach(System.out::println);
    }
}