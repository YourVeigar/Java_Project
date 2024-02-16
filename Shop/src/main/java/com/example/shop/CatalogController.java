package com.example.shop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CatalogController {
    private final ObservableList<Product> productData = FXCollections.observableArrayList();
    @FXML
    private TableView<Product> catalogTable;

    @FXML
    private TableColumn<Product, String> productId;
    @FXML
    private TableColumn<Product, String> productName;
    @FXML
    private TableColumn<Product, String> productSum;
    @FXML
    private TableColumn<Product, String> productCount;
    @FXML
    private Label productIdLabel;
    @FXML
    private Label productNameLabel;
    @FXML
    private Label productSumLabel;
    @FXML
    private Label productCountLabel;

    public void initialize() {

        ArrayList<Product> list = Product.fillCatalog();
        productData.addAll(list);

        productId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        productName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productSum.setCellValueFactory(new PropertyValueFactory<>("productSum"));
        productCount.setCellValueFactory(new PropertyValueFactory<>("productCount"));
        catalogTable.setItems(productData);

        showProductDetails(null);

        catalogTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showProductDetails(newValue));
    }
    private void showProductDetails( Product product) {
        if (product != null) {
            productIdLabel.setText(product.getProductId().toString());
            productNameLabel.setText(product.getProductName().toString());
            productSumLabel.setText(product.getProductSum().toString());
            productCountLabel.setText(product.getProductCount().toString());
        } else {
            productIdLabel.setText("");
            productIdLabel.setText("");
            productIdLabel.setText("");
            productIdLabel.setText("");

        }
    }
    @FXML
    private void handleDeleteProduct() {
        int selectedIndex = catalogTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            catalogTable.getItems().remove(selectedIndex);

            Product.editProduct(catalogTable.getItems());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Не выделено");
            alert.setHeaderText("Не выбран товар");
            alert.setContentText("Выберите товар в таблице");
            alert.showAndWait();
        }
    }

    public boolean showProductEditDialog(Product product) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EditSceneController.class.getResource("EditScene.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Product");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(null);
            Scene scene = new Scene(pane);
            dialogStage.setScene(scene);

            EditSceneController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setProduct(product);

            dialogStage.showAndWait();

            return  controller.isOkClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML
    private void hadNewProduct() throws IOException {
        Product tempProduct = new Product();

        boolean okClicked = this.showProductEditDialog(tempProduct);
        if (okClicked) {
            productData.add(tempProduct);

            Product.editProduct(productData);
        }
    }

    @FXML
    private void handEditProduct() {
        Product selectedProduct = catalogTable.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            boolean okClicked = showProductEditDialog(selectedProduct);
            if (okClicked) {
                showProductDetails(selectedProduct);
                int selectedIndex = catalogTable.getSelectionModel().getSelectedIndex();
                productData.set(selectedIndex, selectedProduct);

                Product.editProduct(productData);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(null);
            alert.setTitle("Ничего не выбрано");
            alert.setHeaderText("Нет выбранного продукта");
            alert.setContentText("Выберете продукт в таблице");

            alert.showAndWait();
        }
    }

}
