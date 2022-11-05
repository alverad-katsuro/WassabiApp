package com.wassabi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.wassabi.App;
import com.wassabi.model.Categoria;

/**
* Interface para realizar o cadastro do Categoria.
* @author Alfredo Gabriel
* @version 1.0
* @since 04/11/2022
*/
public class CategoriaDAO {

    public static void main(String[] args) {
        Categoria categoria1 = new Categoria("Promoção", "Não tem");
        Categoria categoria2 = new Categoria("Temaki", "Não tem");
        Categoria categoria3 = new Categoria("Entradas", "Não tem");
        Categoria categoria4 = new Categoria("Hall Wassabi", "Não tem");
        CategoriaDAO.createCategoria(categoria1);
        CategoriaDAO.createCategoria(categoria2);
        CategoriaDAO.createCategoria(categoria3);
        CategoriaDAO.createCategoria(categoria4);
    }

    private CategoriaDAO(){}
      
    /** 
     * Função responsavel por armazenar os categorias no banco de dados.
     * @param categoria - Recebe um objeto categoria a fim de torna-lo permanente.
     */
    public static void createCategoria(Categoria categoria){
        EntityManagerFactory entityManagerFactory = App.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        entityManager.persist(categoria);
        entityManager.flush();

        entityTransaction.commit();
        entityManager.close();

        System.out.println("Categoria cadastrado com sucesso");
    }

    /** 
     * Função responsavel por atualizar os dados dos categorias no banco de dados.
     * @param categoria - Recebe um objeto Categoria com ID e os dados a serem atualizados.
     */
    public static void updateCategoria(Categoria categoria){
        EntityManagerFactory entityManagerFactory = App.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        
        entityManager.merge(categoria);
        entityManager.flush();

        entityTransaction.commit();
        entityManager.close();

        System.out.println("Categoria atualizado com sucesso");
    }

    
    /** 
     * Função responsavel por deletar os categorias no banco de dados.
     * @param categoria - Recebe a chave primaria do objeto fim de remove-lo do banco.
     */
    public static void deleteCategoria(int categoria_id){
        EntityManagerFactory entityManagerFactory = App.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Categoria categoria = entityManager.find(Categoria.class, categoria_id);
        entityManager.remove(categoria);

        entityTransaction.commit();
        entityManager.close();
        System.out.println("Categoria deletado com sucesso");
    }

    
    /** 
     * Função responsavel por encontrar um determinado categoria no banco de dados.
     * @param categoria_id - Chave primaria do objeto categoria.
     * @return Categoria - Se encontra-lo retorna o objeto caso contrario retorna null.
     */
    public static Categoria findCategoria_byID(int categoria_id){
        EntityManagerFactory entityManagerFactory = App.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Categoria categoria = entityManager.find(Categoria.class, categoria_id);
        
        entityManager.close();

        if (categoria != null){
            System.out.println("Categoria encontrado");
            return categoria;
        } else {
            System.out.println("Categoria não encontrado");
            return null;
        }
    }

    
    /** 
     * Função responsavel por retornar 10 dos categorias presentes no banco de dados.
     * @return List<Categoria> - retorna uma lista com até 10 categorias.
     */
    public static List<Categoria> readCategorias(){
        EntityManagerFactory entityManagerFactory = App.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TypedQuery<Categoria> categoriaQuery = entityManager.createQuery("from Categoria", Categoria.class);
        List<Categoria> categorias = categoriaQuery.setMaxResults(10).getResultList();
        
        entityManager.close();

        if (categorias.size() > 0){
            System.out.println("Categorias encontrados");
            return categorias;
        } else {
            System.out.println("Não foram encontrados categoria no banco de dados");
            return categorias;
        }
    }
}
