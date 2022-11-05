package com.wassabi.dao;

import org.junit.jupiter.api.Test;

import com.wassabi.model.Cartao;
import com.wassabi.model.Cliente;
import com.wassabi.model.Endereco;

public class CartaoDAOTest {

	@Test
	public void testCreateCartao() throws Exception {
        Cliente cliente = new Cliente("Alfredoo", "Gabriel", "000.000.000-00", "(91) 98448-7808");

        Endereco end = new Endereco(cliente, "Rua", "bai", "null", "null", "null", "null");

        Cartao cartao = new Cartao(cliente, "0000000000000000");

        cliente.addEndereco(end);
        cliente.addCartao(cartao);
        ClienteDAO.createCliente(cliente);
	}

	@Test
	public void testUpdateCartao() throws Exception {

	}

	@Test
	public void testDeleteCartao() throws Exception {

	}

	@Test
	public void testFindCartao_byID() throws Exception {

	}

	@Test
	public void testReadCartoes() throws Exception {

	}

}
