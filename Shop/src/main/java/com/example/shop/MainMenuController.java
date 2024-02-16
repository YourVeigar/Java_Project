package com.example.shop;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Tab catalogtab;
    @FXML
    private TextField search;
    @FXML
    private TableView<Purchases> catalogTable;
    @FXML
    private Tab ordertab;
    @FXML
    private TabPane tabPane;
    @FXML
    private ComboBox<String> comboBox1;
    @FXML
    private TableColumn<Purchases, String> surname;
    @FXML
    private TableColumn<Purchases, String> name;
    @FXML
    private TableColumn<Purchases, String> id;
    @FXML
    private Button saveButton;
    @FXML
    private Label numberOrderLable;
    @FXML
    private Label sumOrder;
    @FXML
    private Hyperlink hyper;
    @FXML
    private TableColumn<Product, String> countOrder;
    @FXML
    private TableColumn<Product, String> nameOrder;
    @FXML
    private TableColumn<Product, String> priceOrder;
    @FXML
    private TableView<Product> tableOrder;

    ObservableList<String> list = FXCollections.observableArrayList();
    private final ObservableList<Purchases> spisok = FXCollections.observableArrayList();

    @FXML
    void initialize() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Catalog.fxml"));
        catalogtab.setContent(loader.load());

        list.add("В обработке");
        list.add("Ожидает оплаты");
        list.add("Оплачено");
        list.add("Ожидает заселения");

        comboBox1.setDisable(true);

        comboBox1.getItems().addAll(list);

        ArrayList<Purchases> spisok1 = Purchases.fillPurchases();

        spisok.addAll(spisok1);
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        catalogTable.setItems(spisok);

        catalogTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showOrderDetails(newValue));

    }

    private void showOrderDetails(Purchases purchases) {
        ObjectMapper mapper = new ObjectMapper();
        if (purchases != null) {
            double sum = 0;
            numberOrderLable.setText(purchases.getId().toString());
            comboBox1.setValue(purchases.getStatus());
            ObservableList<Product> products = FXCollections.observableArrayList();

            ArrayList<Product> fillProducts = new ArrayList<>();
            try {
                fillProducts = mapper.readValue(new File("orderProduct.json"), mapper.getTypeFactory().constructCollectionType(List.class, Product.class));
            } catch (IOException error) {
                error.printStackTrace();
            }

            for (int choice : purchases.getProducts()) {
                for (Product product : fillProducts) {
                    if (choice == product.getProductId()) {

                        products.add(product);
                        sum += product.productSum * product.productCount;
                    }
                }
            }
            nameOrder.setCellValueFactory(new PropertyValueFactory<>("productName"));
            countOrder.setCellValueFactory(new PropertyValueFactory<>("productCount"));
            priceOrder.setCellValueFactory(new PropertyValueFactory<>("productSum"));
            tableOrder.setItems(products);
            sumOrder.setText(Double.toString(sum));
            hyper.setOnAction(actionEvent -> {
                comboBox1.setDisable(false);
            });
            saveButton.setOnAction(event -> {
                purchases.setStatus(comboBox1.getValue());
                comboBox1.setDisable(true);
                int ind = catalogTable.getSelectionModel().getSelectedIndex();
                spisok.set(ind, purchases);
                try {
                    mapper.writeValue(new File("orders.json"), spisok);
                } catch (IOException error) {
                    error.printStackTrace();
                }
            });
        } else {
            numberOrderLable.setText("");
            sumOrder.setText("");
        }
    }

    @FXML
    private void selectCatalogTab(ActionEvent event) {
        tabPane.getSelectionModel().select(catalogtab);
    }

    @FXML
    private void selectOrderTab(ActionEvent event) {
        tabPane.getSelectionModel().select(ordertab);
    }


    @FXML
    private void searchBut(ActionEvent event) {
        showOrderDetails(Purchases.search(search.getText()));
    }

    @FXML
    private void exitBut(ActionEvent event) {
        saveButton.getScene().getWindow().hide();
    }

    @FXML
    private void HelpButton() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("О программе");
        alert.setHeaderText("Учебная программа");
        alert.setContentText("версия 1.0");
        alert.showAndWait();
    }

    @FXML
    private void OpenNewWindow() {
        FXMLLoader fxmlLoader3 = new FXMLLoader(HelloApplication.class.getResource("Catalog.fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader3.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Каталог");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void showStatistic() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        ArrayList<Product> fillProducts = new ArrayList<>();
        try {
            fillProducts = mapper.readValue(new File("orderProduct.json"), mapper.getTypeFactory().constructCollectionType(List.class, Product.class));
        } catch (IOException error) {
            error.printStackTrace();
        }

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Diagram.fxml"));
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Статистика продаж");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(null);
        stage.setScene(scene);

        ShowDiagramController controller = fxmlLoader.getController();
        controller.setProductData(fillProducts);

        stage.show();
    }

}
