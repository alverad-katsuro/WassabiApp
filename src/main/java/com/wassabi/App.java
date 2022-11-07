package com.wassabi;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.wassabi.gui.AppFX;

import javafx.application.Application;

//import net.miginfocom.swing.MigLayout;

/*
 * Está e classe principal que sera chamada para iniciar a aplicação
 */
public class App {
    private static EntityManagerFactory entityManagerFactory = Persistence.
    createEntityManagerFactory("WassabiApp");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        Application.launch(AppFX.class, args);
	}

    
	/** 
     * @return EntityManagerFactory
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}