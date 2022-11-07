package com.wassabi.dao;

import org.junit.jupiter.api.Test;

import com.wassabi.model.Usuario;

public class UsuarioDAOTest {

	@Test
	public void testCreateUsuario() throws Exception {
        Usuario usuario = new Usuario("amgabriel1@hotmail.com", "1234", "ADMINISTRADOR");
        UsuarioDAO.createUsuario(usuario);
	}

	@Test
	public void testUpdateUsuario() throws Exception {

	}

	@Test
	public void testDeleteUsuario() throws Exception {

	}

	@Test
	public void testFindUsuario_byID() throws Exception {

	}

	@Test
	public void testFindUsuario_byEmail() throws Exception {

	}

	@Test
	public void testReadCartoes() throws Exception {

	}

}
