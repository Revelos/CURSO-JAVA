package hibernateapp;

import hibernateapp.entity.Cliente;
import hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Scanner;

public class HibernatePorId {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EntityManager em = JpaUtil.getEntityManager();
        System.out.println("Ingrese el id del cliente");
        Long id = sc.nextLong();

        Cliente cliente = em.find(Cliente.class,id);
        System.out.println(cliente);
        em.close();

    }
}
