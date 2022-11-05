package com.wassabi.dao;

import org.junit.jupiter.api.Test;

import com.wassabi.model.Cliente;

public class ClienteDAOTest {

	@Test
	public void testCreateCliente() throws Exception {
        Cliente cliente = new Cliente("Alfredoo", "Gabriel", "000.000.000-00", "(91) 98448-7808");
        ClienteDAO.createCliente(cliente);
	}

	@Test
	public void testUpdateCliente() throws Exception {

	}

	@Test
	public void testDeleteCliente() throws Exception {

	}

	@Test
	public void testFindCliente_byID() throws Exception {

	}

	@Test
	public void testReadClientes() throws Exception {

	}

}
