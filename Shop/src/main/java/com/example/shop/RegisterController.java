package com.example.shop;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RegisterController {
    @FXML
    private TextField login2;
    @FXML
    private TextField password2;

    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField otchestvo;

    @FXML
    private TextField age;

    @FXML
    private Button register2;

    public void onButtonClick4() throws IOException {
        User user = new User();
        String answer = user.addUsers(login2.getText(), password2.getText(), name.getText(), surname.getText(), otchestvo.getText(), age.getText());

        if (!Objects.equals(answer, "Удачно")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Неудачная регистрация");
            alert.setContentText(answer);
            alert.showAndWait();
        }
        else {
            register2.getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello.fxml"));
            Scene scene;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            stage.setTitle("Авторизация");
            stage.setScene(scene);
            stage.show();
        }
    }

}
