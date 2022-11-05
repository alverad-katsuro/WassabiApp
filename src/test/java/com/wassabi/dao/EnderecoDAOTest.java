package com.wassabi.dao;

import org.junit.jupiter.api.Test;

import com.wassabi.model.Cliente;
import com.wassabi.model.Endereco;

public class EnderecoDAOTest {

	@Test
	public void testCreateEndereco() throws Exception {
        Cliente cliente = new Cliente("Alfredoo", "Gabriel", "000.000.000-00", "(91) 98448-7808");

        Endereco end = new Endereco(cliente, "Rua", "bai", "null", "null", "null", "null");

        cliente.addEndereco(end);
        ClienteDAO.createCliente(cliente);
	}

	@Test
	public void testUpdateEndereco() throws Exception {

	}

	@Test
	public void testDeleteEndereco() throws Exception {

	}

	@Test
	public void testFindEndereco_byID() throws Exception {

	}

	@Test
	public void testReadEnderecos() throws Exception {

	}

}
