package valerio.software1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import valerio.software1.model.Inventory;
import valerio.software1.model.Product;

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

        Product product1 = new Product(1, "Motor-Bike2000", 2999.99, 23, 1, 30);
        Product product2 = new Product(2, "PlayWheels Skateboard", 59.99, 19, 1, 30);
        Product product3 = new Product(3, "BuySmart Bike", 199.99, 20, 1, 30);
        Inventory.addProduct(product1);
        Inventory.addProduct(product2);
        Inventory.addProduct(product3);

        launch();
    }
}