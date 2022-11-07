package com.wassabi.dao;

import org.junit.jupiter.api.Test;

import com.wassabi.model.Cliente;
import com.wassabi.model.Usuario;

public class ClienteDAOTest {

	@Test
	public void testCreateCliente() throws Exception {
        Cliente cliente = new Cliente("Alfredoo", "Gabriel", "000.000.000-00", "(91) 98448-7808");
        ClienteDAO.createCliente(cliente);
        ClienteDAO.deleteCliente(cliente.getClienteId());
	}

	@Test
	public void testUpdateCliente() throws Exception {
        Usuario user = UsuarioDAO.findUsuario_byID(1);
        Cliente cli = user.getCliente();
        cli.setClienteCpf("011.000.000-44");
        ClienteDAO.updateCliente(cli);
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
