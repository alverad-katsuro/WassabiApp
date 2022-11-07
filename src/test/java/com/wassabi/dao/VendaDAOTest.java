package com.wassabi.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.wassabi.model.Cliente;
import com.wassabi.model.Produto;
import com.wassabi.model.Usuario;
import com.wassabi.model.Venda;

public class VendaDAOTest {

	@Test
	public void testCreateVenda() throws Exception {
        Produto prod = ProdutoDAO.findProduto_byID(1);
        
        Usuario user = UsuarioDAO.findUsuario_byID(1);
        Cliente cliente = user.getCliente();

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
