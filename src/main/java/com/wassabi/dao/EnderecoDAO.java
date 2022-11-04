package com.wassabi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.wassabi.App;
import com.wassabi.model.Endereco;
import com.wassabi.model.EnderecoId;

public class EnderecoDAO {
    public static void main(String[] args) {
        
    }

    private EnderecoDAO() {}

    public static void createEndereco(Endereco endereco){
        EntityManagerFactory entityManagerFactory = App.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(endereco);
        entityManager.flush();
        
        entityTransaction.commit();
        entityManager.close();
        System.out.println("Endereço cadastrado com sucesso");
    }

    public static void updateEndereco(Endereco endereco){
        EntityManagerFactory entityManagerFactory = App.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.merge(endereco);
        entityManager.flush();
        
        entityTransaction.commit();
        entityManager.close();
        System.out.println("Endereço atualizado com sucesso");
    }

    public static Endereco findEndereco_byID(int endereco_id, int cliente_id){
        EntityManagerFactory entityManagerFactory = App.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Endereco endereco = entityManager.find(Endereco.class, new EnderecoId(endereco_id, cliente_id))
        
        entityManager.close();

        if (endereco != null){
            System.out.println("Endereço encontrado");
            return endereco;
        } else {
            System.out.println("Endereço não encontrado");
            return null;
        }
    }

    public static void deleteEndereco(Endereco endereco){
        EntityManagerFactory entityManagerFactory = App.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.remove(endereco);

        entityTransaction.commit();
        entityManager.close();

        System.out.println("Endereco deletado com sucesso");
    }
}
