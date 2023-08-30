package valerio.software1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import valerio.software1.model.*;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-form.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 952, 400);
        stage.setTitle("Inventory Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        Part part1 = new InHouse(1, "Wheel", 4.99, 30, 1, 35, 1);
        Part part2 = new Outsourced(2, "Handle", 3.99, 40, 10, 40, "ABC Company");
        Part part3 = new InHouse(3, "Seat", 5.99, 25, 5, 50, 2);
        Inventory.addPart(part1);
        Inventory.addPart(part2);
        Inventory.addPart(part3);

        Product product1 = new Product(1, "Premium Motor-Bike", 2999.99, 23, 1, 30);
        Product product2 = new Product(2, "PlayWheels Skateboard", 59.99, 19, 1, 30);
        Product product3 = new Product(3, "BuySmart Bike", 199.99, 20, 1, 30);
        Inventory.addProduct(product1);
        Inventory.addProduct(product2);
        Inventory.addProduct(product3);

        launch();
    }
}