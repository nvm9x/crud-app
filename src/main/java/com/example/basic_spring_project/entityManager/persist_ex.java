package com.example.basic_spring_project.entityManager;

import com.example.basic_spring_project.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class persist_ex {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("main");
        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User user = new User(1,"Tom", "tom@yahoo.com");
            entityManager.persist(user);
            transaction.commit();
        }catch (Exception e){
            if(transaction!=null){
                transaction.rollback();
            }
            e.printStackTrace();

        } finally {
            if(entityManager!=null){
                entityManager.close();
                factory.close();
            }
        }
    }
}
