package com.example.shop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class userChoiceController {

    @FXML
    private Button buttonCatalog;

    public void Catalog() {
        buttonCatalog.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("userCatalog.fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Каталог");
        stage.setScene(scene);
        stage.show();
    }

    public void Basket() {
        buttonCatalog.getScene().getWindow().hide();
        FXMLLoader fxmlLoader1 = new FXMLLoader(HelloApplication.class.getResource("userBasket.fxml"));
        Scene scene1;
        try {
            scene1 = new Scene(fxmlLoader1.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage1 = new Stage();
        stage1.setTitle("Корзина");
        stage1.setScene(scene1);
        stage1.show();
    }
}
