package com.wassabi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.wassabi.App;
import com.wassabi.model.Venda;

/**
* Interface para realizar o cadastro do Venda.
* @author Alfredo Gabriel
* @version 1.0
* @since 04/11/2022
*/
public class VendaDAO {

    private VendaDAO(){}
      
    /** 
     * Função responsavel por armazenar os vendas no banco de dados.
     * @param venda - Recebe um objeto venda a fim de torna-lo permanente.
     */
    public static void createVenda(Venda venda){
        EntityManagerFactory entityManagerFactory = App.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        entityManager.persist(venda);
        entityManager.flush();

        entityTransaction.commit();
        entityManager.close();

        System.out.println("Venda cadastrado com sucesso");
    }

    /** 
     * Função responsavel por atualizar os dados dos vendas no banco de dados.
     * @param venda - Recebe um objeto Venda com ID e os dados a serem atualizados.
     */
    public static void updateVenda(Venda venda){
        EntityManagerFactory entityManagerFactory = App.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        entityManager.merge(venda);
        entityManager.flush();

        entityTransaction.commit();
        entityManager.close();

        System.out.println("Venda atualizado com sucesso");
    }

    
    /** 
     * Função responsavel por deletar os vendas no banco de dados.
     * @param venda - Recebe um objeto Venda com ID a fim de remove-lo do banco.
     */
    public static void deleteVenda(Venda venda){
        EntityManagerFactory entityManagerFactory = App.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.remove(venda);

        entityTransaction.commit();
        entityManager.close();
        System.out.println("Venda deletado com sucesso");
    }

    
    /** 
     * Função responsavel por encontrar um determinado venda no banco de dados.
     * @param venda_id - Chave primaria do objeto venda.
     * @return Venda - Se encontra-lo retorna o objeto caso contrario retorna null.
     */
    public static Venda findVenda_byID(int venda_id){
        EntityManagerFactory entityManagerFactory = App.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Venda venda = entityManager.find(Venda.class, venda_id);
        
        entityManager.close();

        if (venda != null){
            System.out.println("Venda encontrado");
            return venda;
        } else {
            System.out.println("Venda não encontrado");
            return null;
        }
    }

    
    /** 
     * Função responsavel por retornar 10 dos vendas presentes no banco de dados.
     * @return List<Venda> - retorna uma lista com até 10 vendas.
     */
    public static List<Venda> readVendas(){
        EntityManagerFactory entityManagerFactory = App.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Venda> vendaQuery = entityManager.createQuery("from Venda", Venda.class);
        List<Venda> vendas = vendaQuery.setMaxResults(10).getResultList();
        
        entityManager.close();

        if (vendas.size() > 0){
            System.out.println("Vendas encontrados");
            return vendas;
        } else {
            System.out.println("Não foram encontrados venda no banco de dados");
            return null;
        }
    }
}
