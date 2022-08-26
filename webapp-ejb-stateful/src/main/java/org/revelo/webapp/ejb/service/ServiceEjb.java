package org.revelo.webapp.ejb.service;

import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;

@Stateful
@RequestScoped //Al poner esto indicamos que no se mezclen las solicitudes si no que sean independiente, esto no va con stateless solo con statefull
public class ServiceEjb {

    private int contador;

    public  String saludar(String nombre){
        System.out.println("Imprimiendo dentro del ejb con instancia: "+ this);
        contador++;
        System.out.println("El valor del contador en emetodo saludar "+contador);
        return "Hola que tal "+nombre;
    }
}
