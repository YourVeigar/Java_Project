package com.example.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.control.Alert;


@JsonAutoDetect
public class User {
    public String login;
    public String password;
    public String name1;
    public String surname1;
    public String otchestvo1;
    public String age1;
    public String type;


    public User(String login, String password, String name1, String surname1, String otchestvo1, String age1, String type) {
        this.login = login;
        this.password = password;
        this.name1 = name1;
        this.surname1 = surname1;
        this.otchestvo1 = otchestvo1;
        this.age1 = age1;
        this.type = type;
    }

    public User() {}
    public ArrayList<User> fillUsers(){
        ArrayList<User> users = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            users = mapper.readValue(new File("logpass.json"), mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        } catch (IOException error) {
            error.printStackTrace();
        }
        return users;
    }

    public String Check(String login_id, String password_id){
        ArrayList<User> users = fillUsers();
        for (User user: users){
            if (login_id.equals(user.login)){
                if (password_id.equals(user.password)){
                    this.type = user.type;
                    System.out.println(type);
                    return "Пароль и логин найдены";
                } else {
                    return "Не верный пароль";
                }
            }
        }
        return "Пользователь не найден";
    }

    public String addUsers(String login, String password, String name1, String surname1, String otchestvo1, String age1) {
        ArrayList<User> users = fillUsers();

        for (User prov: users){
            if (Objects.equals(login, prov.login)) {
                return "Логин уже существует";
            }
        }

        if (!Objects.equals(login, "") && !Objects.equals(password, "")) {
            User user = new User(login, password, name1, surname1, otchestvo1, age1,  "user");
            users.add(user);
            ObjectMapper mapper = new ObjectMapper();
            try {
                mapper.writeValue(new File("logpass.json"), users);
            } catch (IOException error) {
                error.printStackTrace();
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Регистрация");
            alert.setHeaderText("Регистрация прошла успешно");
            alert.setContentText("Вы зарегистрировались");
            alert.showAndWait();
        }
        else {
            return "Попробуйте снова";
        }
        return "Удачно";
    }


    public String getType() {
        return type;
    }



    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

/*
    public static void main(String[] args) {
        User user = new User();
        try (FileReader fr = new FileReader("D:\\Вуз\\Проектирование интерфейса\\logpass.txt")) {
            BufferedReader bf = new BufferedReader(fr);
            user.setLogin(bf.readLine());
            user.setPassword(bf.readLine());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(user.getLogin());
        if ("doda".equals(user.getLogin())) {
            if ("dia" == user.getPassword()) {
                System.out.println("true" + " iygbhn");
            }
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }

    }


 */
}
