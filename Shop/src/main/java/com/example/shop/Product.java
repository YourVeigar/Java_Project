package com.example.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
public class Product {
    String productName;
    Integer productId, productCount;
    Double productSum;

    public Product(Integer productId,String productName, Double productSum, Integer productCount) {
        this.productName = productName;
        this.productId = productId;
        this.productCount = productCount;
        this.productSum = productSum;
    }

    public Product() {}

    public static ArrayList<Product> fillCatalog(){
        ArrayList<Product> product = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            product = mapper.readValue(new File("product.json"), mapper.getTypeFactory().constructCollectionType(List.class, Product.class));
        } catch (IOException error) {
            error.printStackTrace();
        }
        return product;
    }

    public static void editProduct(ObservableList<Product> products){
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File("product.json"), products);
        } catch (IOException error) {
            error.printStackTrace();
        }
    }


    public String getProductName() {
        return productName;
    }

    public Integer getProductId() {
        return productId;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public Double getProductSum() {
        return productSum;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public void setProductSum(Double productSum) {
        this.productSum = productSum;
    }
}
