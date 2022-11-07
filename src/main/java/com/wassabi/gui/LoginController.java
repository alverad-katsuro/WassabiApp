package com.wassabi.gui;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

import com.wassabi.criptografia.PasswordStorage;
import com.wassabi.criptografia.PasswordStorage.CannotPerformOperationException;
import com.wassabi.criptografia.PasswordStorage.InvalidHashException;
import com.wassabi.dao.UsuarioDAO;
import com.wassabi.model.Usuario;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML private TextField usuario_email;
    @FXML private PasswordField usuario_password;
    @FXML private Button botao_login;
    @FXML private Button botao_novo_usuario;
    
    @FXML
    public void login(){
        if (usuario_email.getText().length() > 0 && usuario_password.getText().length() > 0) {
            Usuario usuario = UsuarioDAO.findUsuario_byEmail(usuario_email.getText());
            try {
                if (usuario != null && PasswordStorage.verifyPassword(usuario_password.getText(), usuario.getUsuarioSenha())) {
                    AppFX.usuarioAutenticado(usuario);
                    AppFX.setRoot("primary");
                } else {
                    JOptionPane.showMessageDialog(null, "Email ou senha incorretos", "Login", JOptionPane.ERROR_MESSAGE);
                    
                }
            } catch (HeadlessException | CannotPerformOperationException | InvalidHashException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Insira o e-mail e senha", "Login", JOptionPane.ERROR_MESSAGE);
            
        }
    }

    //private boolean validaCampos(){
    //    return true;
    //}
}
