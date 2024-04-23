package com.mycompany.myjavafx;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class App extends Application {


    @Override
    public void start(Stage stage) {

        // Creating a grid pane
        GridPane pane = new GridPane();
        pane.setVgap(10); // setting vertical gap
        pane.setHgap(10); // setting horizontal gap
        
        
        
        Label lbl1 = new Label("Bakery Order");
        pane.add(lbl1, 0, 0); 
        
        Label lbl3 = new Label("Name");
        TextField tf3 = new TextField();
        pane.add(lbl3, 0, 1); 
        pane.add(tf3, 1, 1);   
        
        Label lbl4 = new Label("Phone Number");
        TextField tf4 = new TextField();
        pane.add(lbl4, 0, 2); 
        pane.add(tf4, 1, 2); 
        
        Label lbl5 = new Label("Cake Type");
        ComboBox<String> cb1 = new ComboBox<>();
        cb1.getItems().addAll("Apple","Carrot","Cheesecake","Chocolate", "Coffee", "Opera", "Tiramisu");
        pane.add(lbl5, 0, 3);
        pane.add(cb1, 1, 3);
        
        Label lbl6 = new Label("Cake Size");
        ToggleGroup sizeGroup = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Small");
        rb1.setToggleGroup(sizeGroup);
        RadioButton rb2 = new RadioButton("Medium");
        rb2.setToggleGroup(sizeGroup);
        RadioButton rb3 = new RadioButton("Large");
        rb3.setToggleGroup(sizeGroup);
        pane.add(lbl6, 0, 4);
        pane.add(rb1, 1, 4);
        pane.add(rb2, 1, 5);
        pane.add(rb3, 1, 6);
        
        Label lbl7 = new Label("Free Delivery");
        CheckBox cb2 = new CheckBox("Free delivery within area");
        pane.add(lbl7, 0, 7);
        pane.add(cb2, 1, 7);
        
        
        
        Button btn1 = new Button("Quit");
        Button btn2 = new Button("Save");
        
         HBox box = new HBox(btn1, btn2);
         
         box.setPadding(new Insets(10));
        
        pane.add(btn2, 1, 10); 
        pane.add(btn1, 2, 10);

        
        btn1.setOnAction(e -> {
            Platform.exit();
        });
        

        btn2.setOnAction(e -> {
            String name = tf3.getText();
            String phone = tf4.getText();
            String cakeType = cb1.getValue();
            String cakeSize = ((RadioButton) sizeGroup.getSelectedToggle()).getText();
            boolean freeDelivery = cb2.isSelected();
            
            double price = calculatePrice(cakeType, cakeSize);
            
            String orderInfo = name + ", " + phone + ", " + cakeType + ", " + cakeSize + ", " + price + ", " + (freeDelivery ? "Yes" : "No") + "\n";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Orders.txt", true))) {
                writer.write(orderInfo);
            } catch (IOException ex) {
                System.out.println(ex);
            }
            
            // Reset fields
            tf3.clear();
            tf4.clear();
            cb1.getSelectionModel().clearSelection();
            sizeGroup.getSelectedToggle().setSelected(false);
            cb2.setSelected(false);
        });
        
       
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        stage.setTitle("ShowGridPane");
        stage.setScene(scene); 
        stage.show(); 

    }

    private double calculatePrice(String cakeType, String cakeSize) {
        
        if (cakeType.equals("Apple") || cakeType.equals("Carrot") || cakeType.equals("Cheesecake") || cakeType.equals("Chocolate")) {
            switch (cakeSize) {
                case "Small":
                    return 20.00;
                case "Medium":
                    return 30.00;
                case "Large":
                    return 40.00;
                default:
                    break;
            }
        } else if (cakeType.equals("Coffee") || cakeType.equals("Opera") || cakeType.equals("Tiramisu")) {
            switch (cakeSize) {
                case "Small":
                    return 25.00;
                case "Medium":
                    return 35.00;
                case "Large":
                    return 45.00;
                default:
                    break;
            }
        }
        return 0.0;
    }
    
    public static void main(String[] args) {
        launch();
    }

}
