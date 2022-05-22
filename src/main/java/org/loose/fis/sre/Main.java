package org.loose.fis.sre;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.FlightAlreadyExistsException;
import org.loose.fis.sre.model.Flight;
import org.loose.fis.sre.services.BookingService;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.FlightsService;
import org.loose.fis.sre.services.UserService;

import java.nio.file.Files;
import java.nio.file.Path;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        initDirectory();
        UserService.initDatabase();
        FlightsService.initDatabase();
        FlightsService.initDatabaseInterested();
        BookingService.initDatabase();
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("login.fxml"));
        primaryStage.setTitle("Flight Booking App");
        primaryStage.setScene(new Scene(root, 600, 400));
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
            FlightsService.addFlight("Romania", "Italia", "06/04/2022" ,18, 320);
            FlightsService.addFlight("Romania", "Spania", "12/12/2022", 18, 320);
        }
        catch (FlightAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
    }
}
