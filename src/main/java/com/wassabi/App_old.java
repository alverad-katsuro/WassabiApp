package com.wassabi;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

    
    /** 
     * @return EntityManagerFactory
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    } 
    
}