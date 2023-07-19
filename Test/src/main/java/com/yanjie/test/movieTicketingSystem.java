package com.yanjie.test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class movieTicketingSystem extends Application {


    public Text popText1;
    public Text popText2;
    public Text popText3;

    public RadioButton radioButton1;
    public RadioButton radioButton2;
    public RadioButton radioButton3;

    public ComboBox<String> ExperienceComboBox;

    public double exPrice=0;



    @Override
    public void start(Stage stage) throws IOException {
        BorderPane border = new BorderPane();

        Image bckImage = new Image(movieTicketingSystem.class.getResource("cinema.jpg").toString());
        BackgroundSize backgroundSize = new BackgroundSize(
                BackgroundSize.AUTO,
                BackgroundSize.AUTO,
                false,
                false,
                true,
                true);
        BackgroundImage background = new BackgroundImage(
                bckImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);


        border.setBackground(new Background(background));

        //movie//
        Label lblMessageMovie = new Label("Movie");
        lblMessageMovie.setTextFill(Color.WHITE);
        lblMessageMovie.setFont(Font.font("Georgia"));
        lblMessageMovie.setPadding(new Insets(0, 10, 0, 20));
        TextField tfMovie = new TextField("");

        tfMovie.setMinWidth(765);
        tfMovie.setMaxWidth(0);

        HBox movie = new HBox(lblMessageMovie, tfMovie);
        movie.setPadding(new Insets(10, 0, 0, 0));
        movie.setSpacing(120);

        //experience//
        Label lblMessageExperience = new Label("Experience");
        lblMessageExperience.setTextFill(Color.WHITE);
        lblMessageExperience.setFont(Font.font("Georgia"));
        lblMessageExperience.setPadding(new Insets(0, 10, 0, 20));

        ExperienceComboBox = new ComboBox<>();
        ExperienceComboBox.setPrefWidth(300);


        HBox experience = new HBox(lblMessageExperience, ExperienceComboBox);
        experience.setSpacing(95);
        experience.setPadding(new Insets(10, 0, 0, 0));
        ExperienceComboBox.getItems().addAll(
                "Beanie",
                "Classic",
                "Deluxe",
                "Family-Friendly",
                "Flexound",
                "IMAX",
                "Indulge",
                "Infinity",
                "Junior",
                "Onyx"
                );



        //sessions//
        Label lblMessageSession = new Label("Session");
        lblMessageSession.setTextFill(Color.WHITE);
        lblMessageSession.setFont(Font.font("Georgia"));
        lblMessageSession.setPadding(new Insets(0, 0, 0, 20));

        RadioButton showtime1 = new RadioButton("11:00 AM");
        showtime1.setTextFill(Color.WHITE);
        showtime1.setFont(Font.font("Georgia"));

        RadioButton showtime2 = new RadioButton("01:30 PM");
        showtime2.setTextFill(Color.WHITE);
        showtime2.setFont(Font.font("Georgia"));

        RadioButton showtime3 = new RadioButton("04:00 PM");
        showtime3.setTextFill(Color.WHITE);
        showtime3.setFont(Font.font("Georgia"));

        RadioButton showtime4 = new RadioButton("06:30 PM");
        showtime4.setTextFill(Color.WHITE);
        showtime4.setFont(Font.font("Georgia"));

        RadioButton showtime5 = new RadioButton("09:00 PM");
        showtime5.setTextFill(Color.WHITE);
        showtime5.setFont(Font.font("Georgia"));

        // Create a ToggleGroup to ensure only one radio button can be selected at a time
        ToggleGroup showtimeToggleGroup = new ToggleGroup();
        showtime1.setToggleGroup(showtimeToggleGroup);
        showtime2.setToggleGroup(showtimeToggleGroup);
        showtime3.setToggleGroup(showtimeToggleGroup);
        showtime4.setToggleGroup(showtimeToggleGroup);
        showtime5.setToggleGroup(showtimeToggleGroup);

        VBox showTime = new VBox(10);
        showTime.setPadding(new Insets(15, 0, 15, 0));
        showTime.getChildren().addAll(showtime1, showtime2, showtime3, showtime4, showtime5);
        HBox session = new HBox(lblMessageSession, showTime);
        session.setSpacing(125);
        session.setAlignment(Pos.CENTER_LEFT);

        //seat//
        Label lblMessageSeat = new Label("Seats");
        lblMessageSeat.setTextFill(Color.WHITE);
        lblMessageSeat.setFont(Font.font("Georgia"));
        lblMessageSeat.setPadding(new Insets(0, 12, 0, 20));
        TextField tfSeat = new TextField("");

        tfSeat.setMinWidth(765);
        tfSeat.setMaxWidth(0);

        HBox seat = new HBox(lblMessageSeat, tfSeat);
        seat.setSpacing(125);


        //Food and Beverage//
        Label lblMessageFood = new Label("Food and Beverages");
        lblMessageFood.setTextFill(Color.WHITE);
        lblMessageFood.setFont(Font.font("Georgia"));
        lblMessageFood.setPadding(new Insets(0, 40, 0, 0));

        popText1 = new Text("Royal Popcorn Combo–Member Special");
        popText1.setFill(Color.WHITE);
        popText1.setFont(Font.font("Georgia",FontWeight.BOLD,12));

        popText2 = new Text("Royal Popcorn");
        popText2.setFill(Color.WHITE);
        popText2.setFont(Font.font("Georgia",FontWeight.BOLD,12));

        popText3 = new Text("Royal Popcorn Combo");
        popText3.setFill(Color.WHITE);
        popText3.setFont(Font.font("Georgia",FontWeight.BOLD,12));

        GridPane gridPopChoice = new GridPane();
        gridPopChoice.setHgap(20);
        gridPopChoice.setVgap(20);
        gridPopChoice.setPadding(new Insets(20));


        // Create the ToggleGroup for radio buttons
        ToggleGroup toggleGroupPop = new ToggleGroup();

        // Create ImageViews for popcorn options
        Image popcorn1 = new Image(movieTicketingSystem.class.getResource("popcorn1.png").toString());
        Image popcorn2 = new Image(movieTicketingSystem.class.getResource("popcorn2.png").toString());
        Image popcorn3 = new Image(movieTicketingSystem.class.getResource("popcorn3.png").toString());

        ImageView imageView1 = new ImageView(popcorn1);
        ImageView imageView2 = new ImageView(popcorn2);
        ImageView imageView3 = new ImageView(popcorn3);

        double imageWidth = 240;
        double imageHeight = 180;
        imageView1.setFitWidth(imageWidth);
        imageView1.setFitHeight(imageHeight);
        imageView2.setFitWidth(imageWidth);
        imageView2.setFitHeight(imageHeight);
        imageView3.setFitWidth(imageWidth);
        imageView3.setFitHeight(imageHeight);

        // Create RadioButtons for each popcorn option
        radioButton1 = new RadioButton("RM 19.90");
        radioButton1.setTextFill(Color.WHITE);
        radioButton1.setFont(Font.font("Georgia",FontWeight.BOLD,12));

        radioButton2 = new RadioButton("RM 17.90");
        radioButton2.setTextFill(Color.WHITE);
        radioButton2.setFont(Font.font("Georgia",FontWeight.BOLD,12));

        radioButton3 = new RadioButton("RM 21.90");
        radioButton3.setTextFill(Color.WHITE);
        radioButton3.setFont(Font.font("Georgia",FontWeight.BOLD,12));

        // Add RadioButtons to the ToggleGroup
        radioButton1.setToggleGroup(toggleGroupPop);
        radioButton2.setToggleGroup(toggleGroupPop);
        radioButton3.setToggleGroup(toggleGroupPop);

        // Add the components to the GridPane
        gridPopChoice.add(lblMessageFood, 0, 0);
        gridPopChoice.add(imageView1, 1, 0);
        gridPopChoice.add(imageView2, 2, 0);
        gridPopChoice.add(imageView3, 3, 0);

        gridPopChoice.add(popText1, 1, 1);
        gridPopChoice.add(popText2, 2, 1);
        gridPopChoice.add(popText3, 3, 1);
        gridPopChoice.add(radioButton1, 1, 2);
        gridPopChoice.add(radioButton2, 2, 2);
        gridPopChoice.add(radioButton3, 3, 2);

        HBox food = new HBox(gridPopChoice);

        //submit//
        Button btnSubmit = new Button("Submit");
        btnSubmit.setPrefWidth(150);
        btnSubmit.setStyle("-fx-pref-width: 120px; -fx-pref-height: 40px;bold;-fx-background-radius: 30;-fx-border-radius: 30;-fx-font-weight: bold;-fx-color: #000000;-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, #E0E0E0, #153D75);-fx-border-color: white;");


        btnSubmit.setOnAction(e -> handleCheckButtonClick(ExperienceComboBox,tfSeat,showtimeToggleGroup,tfMovie,toggleGroupPop));

        VBox all = new VBox(movie, experience, session, seat, food);
        border.setLeft(all);
        HBox submit = new HBox(btnSubmit);
        submit.setPadding(new Insets(30));
        submit.setAlignment(Pos.CENTER_RIGHT);
        border.setBottom(submit);


        Scene scene = new Scene(border, 960, 650);
        stage.setTitle("Movie Ticketing System");
        stage.setScene(scene);
        stage.show();
    }


    private double getPrice(String item) {
        switch (item) {
            case "Beanie":
                return 19.90;
            case "Classic":
                return 15.90;
            case "Deluxe":
                return 23.90;
            case "Family-Friendly":
                return 23.90;
            case "Flexound":
                return 25.90;
            case "IMAX":
                return 25.90;
            case "Indulge":
                return 120.00;
            case "Infinity":
                return 120.00;
            case "Junior":
                return 15.90;
            case "Onyx":
                return 89.90;
            default:
                return 0.0;
        }
    }

    private double getPopcornPrice(String popcorn) {
        switch (popcorn) {
            case "RM 19.90":
                double discountPrice=19.90*0.9;
                return discountPrice;
            case "RM 17.90":
                return 17.90;
            case "RM 21.90":
                return 21.90;
            default:
                return 0.0;
        }
    }

    private String getPopcornSet(String popcorn){
        String set=" ";
        switch (popcorn){
            case "RM 19.90":
                set=popText1.getText();
                return set;
            case "RM 17.90":
                set=popText2.getText();
                return set;
            case "RM 21.90":
                set=popText3.getText();
                return  set;

        }
        return set;
    }
    private void handleCheckButtonClick(ComboBox experience,TextField seatNumber,ToggleGroup showTime,TextField movie,ToggleGroup popcorn) {
        boolean comboBoxSelected = experience.getSelectionModel().getSelectedItem() != null;
        boolean textFieldMoviedNotEmpty = !movie.getText().isEmpty();
        boolean textFieldSeatNotEmpty = !seatNumber.getText().isEmpty();
        boolean showTimeRadioButtonSelected = showTime.getSelectedToggle() != null;
        boolean popcornRadioButtonSelected =  popcorn.getSelectedToggle() != null;

        if (!comboBoxSelected && !textFieldMoviedNotEmpty && !textFieldSeatNotEmpty && !showTimeRadioButtonSelected && !popcornRadioButtonSelected) {
            showAlert("Error","Please make sure all fields are selected/entered.");
        } else {
            String seatNumberInput = seatNumber.getText();
            try {
                String[] seatNumbers = seatNumberInput.split(",");
                int totalSeats = countTotalSeats(seatNumbers);

                RadioButton selectedShowRadioButton = (RadioButton) showTime.getSelectedToggle();
                String selectedShowValue = selectedShowRadioButton.getText();

                String selectedEx = ExperienceComboBox.getValue();
                double exPrice = getPrice(selectedEx);

                RadioButton selectedPopcornRadioButton = (RadioButton) popcorn.getSelectedToggle();
                String selectedPopcornValue = selectedPopcornRadioButton.getText();
                double popcornPrice =getPopcornPrice(selectedPopcornValue);

                double totalPrice = (exPrice*totalSeats)+popcornPrice;
                DecimalFormat decimalFormat = new DecimalFormat("#.00");
                String formattedPrice = decimalFormat.format(totalPrice);

                String movieName= movie.getText();

                submitMovie(movieName);
                processShowTimeSelection(showTime);
                processPopcornSelection(popcorn);


                if (totalSeats < 1 || seatNumber==null) {
                    throw new InvalidSeatNumberException("Please enter at least one valid seat number." + "\nUsing the format F6, F7 (e.g., Row F, Seat 6 and Seat 7)");
                }else {
                    showComfirm("Thank You",  "You selected " + movieName + " with " + selectedEx + " experience at " + selectedShowValue +
                            "\nfor " + totalSeats + " seat(s) and a " + getPopcornSet(selectedPopcornValue) + "." + "\nThe total is RM "+ formattedPrice );
                }
            } catch (InvalidSeatNumberException ex) {
                showAlert("Invalid Seat Number", ex.getMessage());
            } catch (InvalidNameException ex) {
                showAlert("Invalid Name", ex.getMessage());
            } catch (NullPointerException ex) {
                showAlert("Incomplete Selections", "Please make your choice.");
            }

            clearData(experience,seatNumber,showTime,movie,popcorn);

        }
    }

    private int countTotalSeats(String[] seatNumbers) {
        String seatNumberPattern = "[A-Z]\\d+";
        Pattern pattern = Pattern.compile(seatNumberPattern);

        int totalSeats = 0;
        for (String seatNumber : seatNumbers) {
            Matcher matcher = pattern.matcher(seatNumber.trim());
            if (matcher.matches()) {
                totalSeats++;
            }
        }
        return totalSeats;
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showComfirm(String title,String message){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText("Confirmation");
        alert.setContentText(message);
        alert.getDialogPane().setMinSize(150, 200);
        alert.showAndWait();
    }

    private static class InvalidSeatNumberException extends Exception {
        public InvalidSeatNumberException(String message) {
            super(message);
        }
    }

    private void submitMovie(String movie) throws InvalidNameException {
        if (movie == null || movie.trim().isEmpty()) {
            throw new InvalidNameException();
        }

    }
    private static class InvalidNameException extends Exception {
        public InvalidNameException() {
            super("Movie name cannot be empty.");
        }
    }
    private void processShowTimeSelection(ToggleGroup showTime) {
        RadioButton selectedRadioButton = (RadioButton) showTime.getSelectedToggle();
        if (selectedRadioButton == null) {
            throw new NullPointerException();
        }
    }

    private void processPopcornSelection(ToggleGroup popcorn) {
        RadioButton selectedRadioButton = (RadioButton) popcorn.getSelectedToggle();
        if (selectedRadioButton == null) {
            throw new NullPointerException();
        }
    }

    public void clearData(ComboBox ExperienceComboBox,TextField tfSeat,ToggleGroup showtimeToggleGroup,TextField tfMovie,ToggleGroup toggleGroupPop){
        ExperienceComboBox.setValue(null);
        tfSeat.clear();
        showtimeToggleGroup.selectToggle(null);
        tfMovie.clear();
        toggleGroupPop.selectToggle(null);
    }

    public static void main(String[] args) {
        launch();
    }
}
