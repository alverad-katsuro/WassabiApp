package com.wassabi.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.wassabi.model.Categoria;

public class CategoriaDAOTest {
    
	@Test
	public void testCreateCategoria() throws Exception {
        Categoria categoria = new Categoria("categoriaaaa", "alguma_descricao");
        CategoriaDAO.createCategoria(categoria);
        Categoria encontrada = CategoriaDAO.findCategoria_byID(categoria.getCategoriaId());
        assertTrue(categoria.getCategoriaId() == encontrada.getCategoriaId());
        assertTrue(categoria.getCategoriaNome().equals(encontrada.getCategoriaNome()));
        assertTrue(categoria.getCategoriaDescricao().equals(encontrada.getCategoriaDescricao()));
        CategoriaDAO.deleteCategoria(encontrada.getCategoriaId());
	}

	@Test
	public void testUpdateCategoria() throws Exception {
        Categoria categoria = new Categoria("categoriaaaa", "alguma_descricao");
        CategoriaDAO.createCategoria(categoria);
        categoria.setCategoriaNome("Mudei de nome");
        CategoriaDAO.updateCategoria(categoria);
        Categoria encontrada = CategoriaDAO.findCategoria_byID(categoria.getCategoriaId());
        assertTrue(categoria.getCategoriaId() == encontrada.getCategoriaId());
        assertTrue(categoria.getCategoriaNome().equals(encontrada.getCategoriaNome()));
        assertTrue(categoria.getCategoriaDescricao().equals(encontrada.getCategoriaDescricao()));
        CategoriaDAO.deleteCategoria(encontrada.getCategoriaId());
	}

	@Test
	public void testDeleteCategoria() throws Exception {
        Categoria categoria = new Categoria("categoriaaaa", "alguma_descricao");
        CategoriaDAO.createCategoria(categoria);
        CategoriaDAO.deleteCategoria(categoria.getCategoriaId());
        Categoria encontrada = CategoriaDAO.findCategoria_byID(categoria.getCategoriaId());
        assertTrue(encontrada == null);

	}

	@Test
	public void testFindCategoria_byID() throws Exception {
	}

	@Test
	public void testReadCategorias() throws Exception {

	}

}
