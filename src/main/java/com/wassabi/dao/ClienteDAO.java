package com.wassabi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.wassabi.App;
import com.wassabi.model.Cliente;
import com.wassabi.model.Endereco;

public class ClienteDAO {
    private ClienteDAO(){}

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Cliente cli = new Cliente(0, "NOME", "SOBRENOME", "000.000.000-00", "(91) 98448-7808");

        Endereco end = new Endereco(cli, "RUA", "BAIRRO", "CUDADE", "ESTADO");
        

        //Cliente cli = ClienteDAO.findCliente_byID(1);
        //System.out.println(cli);
        ClienteDAO.createCliente(cli);
    }

    
    /** 
     * @param cliente
     */
    public static void createCliente(Cliente cliente){
        EntityManagerFactory entityManagerFactory = App.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        if (cliente.getEndereco().getEnderecoId() == null) {
            entityManager.persist(cliente.getEndereco());
            entityManager.flush();
        }
        entityManager.persist(cliente);
        entityTransaction.commit();
        entityManager.close();
        System.out.println("Cadastrado com sucesso");
    }

    
    /** 
     * @param cliente
     */
    public static void deleteCliente(Cliente cliente){
        EntityManagerFactory entityManagerFactory = App.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.remove(cliente);

        entityTransaction.commit();
        entityManager.close();
        System.out.println("Cliente deletado com sucesso");
    }

    
    /** 
     * @param cliente_id
     * @return Cliente
     */
    public static Cliente findCliente_byID(int cliente_id){
        EntityManagerFactory entityManagerFactory = App.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Cliente cliente = entityManager.find(Cliente.class, cliente_id);
        
        entityManager.close();

        if (cliente != null){
            System.out.println("Cliente encontrado");
            return cliente;
        } else {
            System.out.println("Cliente não encontrado");
            return null;
        }
    }
}
