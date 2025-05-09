package br.senac.sp.livraria.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmFactory {
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("senac");

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

}
