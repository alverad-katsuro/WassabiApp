package com.wassabi;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.wassabi.model.Cliente;
import com.wassabi.model.Endereco;

/*
 * Está e classe principal que sera chamada para iniciar a aplicação
 */
public class App {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WassabiApp");

    /** 
     * @param args
     */
    public static void main(String[] args) {
        
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    } 
    
}