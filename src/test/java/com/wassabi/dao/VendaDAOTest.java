package com.wassabi.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.wassabi.model.Categoria;
import com.wassabi.model.Cliente;
import com.wassabi.model.Produto;
import com.wassabi.model.Venda;

public class VendaDAOTest {

	@Test
	public void testCreateVenda() throws Exception {
        Categoria categoria = new Categoria("Promoçãooooo", "Descrição");
        CategoriaDAO.createCategoria(categoria);
        Produto prod = new Produto(categoria, "Pizzazzzzzzzz", 75.0, "Pizza com bordas");
        ProdutoDAO.createProduto(prod);
        
        Cliente cliente = new Cliente("Alfredoo", "Gabriel", "000.000.000-00", "(91) 98448-7808");
        ClienteDAO.createCliente(cliente);

        Venda venda = new Venda(cliente);
        venda.addProduto(prod, 5);

        VendaDAO.createVenda(venda);
        assertTrue(VendaDAO.findVenda_byID(venda.getVendaId()) != null);
	}

	@Test
	public void testUpdateVenda() throws Exception {

	}

	@Test
	public void testDeleteVenda() throws Exception {

	}

	@Test
	public void testFindVenda_byID() throws Exception {

	}

	@Test
	public void testReadVendas() throws Exception {
        List<Venda> vendas = VendaDAO.readVendas();
        assertTrue(vendas.size() > 0);
	}

}
