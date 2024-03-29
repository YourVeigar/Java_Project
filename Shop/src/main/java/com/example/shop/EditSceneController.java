package com.example.shop;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditSceneController {

    @FXML
    private TextField productIdField;
    @FXML
    private TextField productNameField;
    @FXML
    private TextField productCountField;
    @FXML
    private TextField productSumField;

    private Stage dialogStage;
    private Product product;
    private boolean okClicked = false;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setProduct(Product product) {
        this.product = product;

        if (product.getProductId() != null) {
            productIdField.setText(product.getProductId().toString());
            productNameField.setText(product.getProductName());
            productCountField.setText(product.getProductCount().toString());
            productSumField.setText(product.getProductSum().toString());
        }
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (productIdField.getText() == null || productIdField.getText().length() == 0) {
            errorMessage += "Нет доступного артикула\n";
        }
        if (productNameField.getText() == null || productNameField.getText().length() == 0) {
            errorMessage += "Нет доступного наименование товара\n";
        }
        if (productSumField.getText() == null || productSumField.getText().length() == 0) {
            errorMessage += "Нет доступного суммы\n";
        }
        if (productCountField.getText() == null || productCountField.getText().length() == 0) {
            errorMessage += "Нет доступного количества\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Некорректные поля");
            alert.setHeaderText("Внесите корректную информацию");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            product.setProductId(Integer.parseInt(productIdField.getText()));
            product.setProductName(productNameField.getText());
            product.setProductSum(Double.parseDouble(productSumField.getText()));
            product.setProductCount(Integer.parseInt(productCountField.getText()));

            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}

