package com.example.shop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private Label label1;
    @FXML
    private Button SignIn;
    @FXML
    private Button Cancel;
    @FXML
    private Button register1;
    @FXML
    User user = new User();

    @FXML
    protected void onButtonClick1() throws IOException {
        if (user.Check(textField1.getText(), textField2.getText()) == "Пароль и логин найдены") {
            if (user.getType().equals("admin")) {
                SignIn.getScene().getWindow().hide();
                FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("MainMenu.fxml"));
                Scene scene;
                try {
                    scene = new Scene(fxmlLoader2.load());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage = new Stage();
                stage.setTitle("Каталог");
                stage.setScene(scene);
                stage.show();
            } else {
                SignIn.getScene().getWindow().hide();
                FXMLLoader fxmlLoader2 = new FXMLLoader(HelloApplication.class.getResource("userChoice.fxml"));
                Scene scene;
                try {
                    scene = new Scene(fxmlLoader2.load());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Stage stage = new Stage();
                stage.setTitle("");
                stage.setScene(scene);
                stage.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Неудачный вход");
            alert.setContentText(user.Check(textField1.getText(), textField2.getText()));
            alert.showAndWait();
        }
    }

    public void onButtonClick2(ActionEvent actionEvent) {
        textField1.setText("");
        textField2.setText("");
    }

    public void onButtonClick3(ActionEvent actionEvent) throws IOException {
        register1.getScene().getWindow().hide();
        Stage stage1 = new Stage();
        stage1.setTitle("Регистрация");
        Parent root1 = FXMLLoader.load(getClass().getResource("register.fxml"));
        Scene scene1 = new Scene(root1);
        stage1.setScene(scene1);
        stage1.show();
    }
}