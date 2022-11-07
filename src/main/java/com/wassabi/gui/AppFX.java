package com.wassabi.gui;

import java.io.IOException;

import com.wassabi.model.Usuario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class AppFX extends Application {
    private static Scene scene;
    private static PrimaryController controller = new PrimaryController();
    protected static Usuario usuario_autenticado;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppFX.class.getResource("loginController.fxml"));
        Parent loader = fxmlLoader.load();
        scene = new Scene(loader);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void setRoot(String fxml) {
        try {
            scene.setRoot(loadFXML(fxml));
        } catch (IOException e) {
            System.out.println("Algum erro aconteceu");
            e.printStackTrace();
        }
    }

    static void setRoot(Parent parent) {
        scene.setRoot(parent);
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppFX.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        AppFX.scene = scene;
    }

    public static PrimaryController getController() {
        return controller;
    }

    public static void setController(PrimaryController controller) {
        AppFX.controller = controller;
    }

    public static Usuario getUsuario_autenticado() {
        return usuario_autenticado;
    }

    public static void setUsuario_autenticado(Usuario usuario_autenticado) {
        AppFX.usuario_autenticado = usuario_autenticado;
    }

    
    protected static void usuarioAutenticado(Usuario usuario_autenticado){
        AppFX.usuario_autenticado = usuario_autenticado;
        AppFX.setRoot("primary");
    }

}