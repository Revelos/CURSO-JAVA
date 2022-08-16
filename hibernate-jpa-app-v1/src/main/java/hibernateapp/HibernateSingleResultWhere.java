package hibernateapp;

import hibernateapp.entity.Cliente;
import hibernateapp.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Scanner;

public class HibernateSingleResultWhere {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("FROM Cliente c WHERE c.formaPago=?1");
        System.out.println("Ingrese una forma de pago: ");
        String pago = s.next();
        query.setParameter(1,pago);
        query.setMaxResults(1);
        Cliente c = (Cliente) query.getSingleResult();
        System.out.println(c);
        em.close();

    }
}
