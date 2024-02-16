package com.example.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserCatalogController {

    @FXML
    private Label Catalog;

    @FXML
    private TableColumn<Product, String> productId;
    @FXML
    private TableColumn<Product, String> productName;
    @FXML
    private TableColumn<Product, String> productSum;
    @FXML
    private TableColumn<Product, String> productCount;
    @FXML
    private TableView<Product> catalogTable;
    @FXML
    private Label productIdLabel;
    @FXML
    private Label productNameLabel;
    @FXML
    private Label productSumLabel;
    @FXML
    private Label productCountLabel;
    @FXML
    private TextField count;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    private Product danProduct;

    private final ObservableList<Product> productData = FXCollections.observableArrayList();

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
            danProduct = product;
        } else {
            productIdLabel.setText("");
            productIdLabel.setText("");
            productIdLabel.setText("");
            productIdLabel.setText("");

        }
    }

    @FXML
    void buttonBack(ActionEvent event) {
        Catalog.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("userChoice.fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void addButton(ActionEvent event){
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Product> fillProducts = new ArrayList<>();
        try {
            fillProducts = mapper.readValue(new File("orderProduct.json"), mapper.getTypeFactory().constructCollectionType(List.class, Product.class));
        } catch (IOException error) {
            error.printStackTrace();
        }
        ArrayList<Purchases> zak = new ArrayList<>();
        try {
            zak = mapper.readValue(new File("orders.json"), mapper.getTypeFactory().constructCollectionType(List.class, Purchases.class));
        } catch (IOException error) {
            error.printStackTrace();
        }

        if (productNameLabel != null && productSumLabel != null && count != null && surname != null && name != null) {
            fillProducts.add(new Product(fillProducts.size() + 1, danProduct.productName, danProduct.productSum, Integer.parseInt(count.getText())));
            try {
                mapper.writeValue(new File("orderProduct.json"), fillProducts);
            } catch (IOException error) {
                error.printStackTrace();
            }

            boolean perem = false;
            for (int i = 0; i < zak.size(); i++) {
                if (surname.getText().equals(zak.get(i).surname) && name.getText().equals(zak.get(i).name)) {
                    perem = true;
                    List<Integer> prod = new ArrayList<>(Arrays.asList(zak.get(i).products));
                    Integer a = fillProducts.size();
                    prod.add(a);

                    zak.get(i).products = prod.toArray(new Integer[0]);
                }
            }
            Integer[] mas = {fillProducts.size()};
            if (!perem) {
                zak.add(new Purchases(Integer.toString(zak.size() + 1), surname.getText(), name.getText(), "В обработке", mas));
            }

            try {
                mapper.writeValue(new File("orders.json"), zak);
            } catch (IOException error) {
                error.printStackTrace();
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            alert.setTitle("Отель");
            alert.setHeaderText("Бронирование номера");
            alert.setContentText("Успешно");
            alert.showAndWait();
        }
    }


}
