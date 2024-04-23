package com.mycompany.t3assignment4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
//import java.util.FileReader;


/**
 * JavaFX App
 */
public class App extends Application {
    private ObservableList<Hotel> hotelsList = FXCollections.observableArrayList();
    private ListView<Hotel> listView = new ListView<>(hotelsList);

    @Override
    public void start(Stage primaryStage) {
       Button sortByRatingButton = new Button("Sort by Star Rating");
        sortByRatingButton.setOnAction(e -> hotelsList.sort(Hotel.byRatingThenName));

        Button sortByPriceButton = new Button("Sort by Lowest Price");
        sortByPriceButton.setOnAction(e -> hotelsList.sort(Hotel.sortByPrice));

        Button saveButton = new Button("Save to Sorted.txt");
        saveButton.setOnAction(e -> {
            try (PrintWriter writer = new PrintWriter(new File("Sorted.txt"))) {
                for (Hotel hotel : hotelsList) {
                    writer.println(hotel.getName() + " " + hotel.getStars() + " stars " + hotel.getPrice() + " per night");
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        });

        VBox root = new VBox(listView, sortByRatingButton, sortByPriceButton, saveButton);
        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Hotel List");
        primaryStage.setScene(scene);
        primaryStage.show();

        loadHotelsFromTextFile();
    }

    private void loadHotelsFromTextFile() {
        List<Hotel> hotels = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("Hotels.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                String name = "";
                int stars = 0;
                int price = 0;

                for (int i = 0; i < parts.length; i++) {
                    if (parts[i].equals("stars")) {
                        name = String.join(" ", name);
                        stars = Integer.parseInt(parts[i - 1]);
                        price = Integer.parseInt(parts[i + 1]);
                        break;
                    } else {
                        name += parts[i] + " ";
                    }
                }

                hotels.add(new Hotel(name.trim(), stars, price));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        hotelsList.addAll(hotels);

        System.out.println("Sorted by natural ordering:");
        Collections.sort(hotelsList, Hotel.byRatingThenName);
        hotelsList.forEach(System.out::println);

        System.out.println("\nSorted by lowest price:");
        hotelsList.sort(Hotel.sortByPrice);
        hotelsList.forEach(System.out::println);
    }
    
    public static void main(String[] args) {
        launch();
    }
    public static class Hotel {

        private String name;
        private int stars;
        private int price;

        public Hotel(String name, int stars, int price) {
            this.name = name;
            this.stars = stars;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getStars() {
            return stars;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name + " " + stars + " stars " + price + " per night";
        }

        public static Comparator<Hotel> sortByPrice = Comparator.comparingInt(Hotel::getPrice);

        public static Comparator<Hotel> byRatingThenName = Comparator.comparing(Hotel::getStars).reversed()
                .thenComparing(Hotel::getName);
    }
}
