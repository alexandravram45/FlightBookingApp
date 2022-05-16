package org.loose.fis.sre;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.FlightAlreadyExistsException;
import org.loose.fis.sre.services.BookingService;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.FlightsService;
import org.loose.fis.sre.services.UserService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        initDirectory();
        UserService.initDatabase();
        FlightsService.initDatabase();
        FlightsService.initDatabaseInterested();
        BookingService.initDatabase();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("home.fxml"));
        primaryStage.setTitle("Registration Example");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }

    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }


    public static void main(String[] args) {
        launch(args);
        try {
            FlightsService.addFlight("Romania", "Spania", new Date(2021, 12, 12), new Date(2022, 12, 12), 18, 320);
        }
        catch (FlightAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
    }
}
