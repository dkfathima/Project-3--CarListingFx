/*
* Name: Dewan Fathima
* Class: CSTI 501-Java
* Project: CarListingFx.java
* Description: In this project it will display a car listing page that will have a drop-down menu with four cars and after selecting the
* car choice it will display the vehicle's information in another page.
* */
package sample;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextAlignment;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Listing extends Application {

    @Override
    public void start(Stage primaryStage) {
        //This is creating the layout on the display page, adding space, centering the components, and adding a nice background
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: linear-gradient(to top, #E4FFFF, #ADD8E6);");

        //Creating the header on the page using the text instance and creating a font with the font instance
        Text header1 = new Text("Welcome to the Autosome Dealership");
        Font font1 = new Font("Times New Roman", 36);
        header1.setFont(font1);
        header1.setUnderline(true);
        header1.setTextAlignment(TextAlignment.CENTER);

        //Creating the drop-down menu to display the cars and information
        ComboBox<Car> carMenu = new ComboBox<>();
        carMenu.setPromptText("Select a Car");

        //Adding the cars and the info into the arraylist inventory images, year, model, make, cost, vin, and the record
        CarInventory inventory = new CarInventory();
        inventory.addCars(new Car(new Image("BMW.jpg"),"BMW", "Series 430i", 2020, "WBA4W5C02LFH22726", 41838, 19395, false));
        inventory.addCars(new Car(new Image("toyota.jpg"),"Toyota", "Corolla S", 2010, "2T1BU4EEXAC374034", 130311, 5488, true));
        inventory.addCars(new Car(new Image("ford.jpg"),"Ford", "Fusion SE FWD", 2020, "3FA6P0HD7LR233011", 75301, 12995, true));
        inventory.addCars(new Car(new Image("nissan.jpg"),"Nissan", "Rouge SV AWD", 2021, "JN8AT3BB0MW201609", 40692, 19495, true));

        //Creating the label for the number of cars in the inventory
        Font font2 = new Font("Arial", 15);
        Label inventNum = new Label("Available Cars: " + inventory.getAllCars().size());
        inventNum.setFont(font2);

        //This is creating a new page to display the whole car information
        //also creating the layout, centering, and adding a nice background for the new page
        Stage carDetailPage = new Stage();
        carDetailPage.setTitle("Car Details");
        VBox layout2 = new VBox(20);
        layout2.setAlignment(Pos.CENTER);
        layout2.setStyle("-fx-background-color: linear-gradient(to top, #E0FFFF, #ADD8E6);");

        // The new page will activate after clicking the view detail button
        Button viewBT = new Button("View Details");
        viewBT.setAlignment(Pos.CENTER);
        viewBT.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Car selectedCar = carMenu.getValue();
                // when the car is chosen it will display the car's image, year, make, model, vin, cost, mileage, and record
                if (selectedCar != null) {
                    //this is the image of the car that will be displayed
                    ImageView carImage = new ImageView(selectedCar.getImage());

                    // This is the car make, model, and year together label, changing the font of the text, and displaying the information
                    Label makeModelYearLabel = new Label(selectedCar.getMake() + " " + selectedCar.getModel() + " " + selectedCar.getYear());
                    makeModelYearLabel.setStyle("-fx-font-weight: bold");
                    Font font3 = new Font("Ariel", 20);
                    makeModelYearLabel.setFont(font3);

                    //this is the label for the vin number and displaying the vinNum
                    Label vinNumLabel = new Label("VIN: " + selectedCar.getVinNum());

                    //this is the label for mileage and will display the mileage
                    Label mileageLabel = new Label("Mileage: " + selectedCar.getMileage());

                    //this is the label for cost and will display the cost
                    Label costLabel = new Label("Cost: $" + selectedCar.getCost());

                    //this is the label for record and displaying the record
                    Label recordLabel = new Label("Clean Record: " + (selectedCar.isRecord() ? "Yes" : "No"));

                    layout2.getChildren().addAll(carImage, makeModelYearLabel, vinNumLabel, mileageLabel, costLabel, recordLabel);
                    Scene scene = new Scene(layout2, 800, 800);
                    carDetailPage.setScene(scene);
                    carDetailPage.show();

                //If a car is not selected then in the console this statement will display
                } else {
                    System.out.println("!PLEASE SELECT A CAR!");
                }
            }
        });
        //This displays the cars make, model, and year in the drop-down menu box
        carMenu.setItems(FXCollections.observableArrayList(inventory.getAllCars()));

        //This is adding components to the layout to be displayed
        layout.getChildren().addAll(header1, inventNum, carMenu, viewBT);

        //Displaying output
        Scene scene = new Scene(layout, 600, 500);
        primaryStage.setTitle("The Autosome Dealership");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
