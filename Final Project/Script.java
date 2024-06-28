import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Script extends Application {

    private String selectedMode = "";
    private String selectedTemperature = "";

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Smart Washing Machine GUI");

        // Main Menu
        VBox mainMenu = new VBox();
        mainMenu.setSpacing(10);
        Label welcomeLabel = new Label("Welcome to ScrubHub");
        Button washingModesButton = new Button("Washing Modes");
        Button settingsButton = new Button("Settings");

        washingModesButton.setOnAction(e -> showWashingModes(primaryStage));
        settingsButton.setOnAction(e -> showSettings(primaryStage));

        mainMenu.getChildren().addAll(welcomeLabel, washingModesButton, settingsButton);

        Scene mainScene = new Scene(mainMenu, 700, 700);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private void showWashingModes(Stage primaryStage) {
        VBox washingModesMenu = new VBox();
        washingModesMenu.setSpacing(10);
        Label washingModesLabel = new Label("Select Washing Mode");

        HBox modesRow1 = new HBox();
        modesRow1.setSpacing(10);
        HBox modesRow2 = new HBox();
        modesRow2.setSpacing(10);

        String[] modes = {"Energy-saver", "Quick Wash", "Rinse+Spin", "Active Wear", "Heavy Duty", "Silent Mode", "Delicates", "Custom wash"};
        for (int i = 0; i < modes.length; i++) {
            final String mode = modes[i];
            Button modeButton = new Button(mode);
            modeButton.setOnAction(e -> selectMode(mode, primaryStage));
            if (i < 4) {
                modesRow1.getChildren().add(modeButton);
            } else {
                modesRow2.getChildren().add(modeButton);
            }
        }

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> goBackToMainMenu(primaryStage));

        washingModesMenu.getChildren().addAll(washingModesLabel, modesRow1, modesRow2, backButton);

        Scene washingModesScene = new Scene(washingModesMenu, 700, 700);
        primaryStage.setScene(washingModesScene);
    }

    private void selectMode(String mode, Stage primaryStage) {
        selectedMode = mode;
        showTemperatureSelection(primaryStage);
    }

    private void showTemperatureSelection(Stage primaryStage) {
        VBox temperatureSelectionMenu = new VBox();
        temperatureSelectionMenu.setSpacing(10);
        Label temperatureSelectionLabel = new Label("Select Temperature");

        HBox temperatureRow1 = new HBox();
        temperatureRow1.setSpacing(10);
        HBox temperatureRow2 = new HBox();
        temperatureRow2.setSpacing(10);

        String[] temperatures = {"Hot", "Warm", "Cool", "Cold"};
        for (int i = 0; i < temperatures.length; i++) {
            final String temp = temperatures[i];
            Button tempButton = new Button(temp);
            tempButton.setOnAction(e -> selectTemperature(temp, primaryStage));
            if (i < 2) {
                temperatureRow1.getChildren().add(tempButton);
            } else {
                temperatureRow2.getChildren().add(tempButton);
            }
        }

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> goBackToWashingModes(primaryStage));

        temperatureSelectionMenu.getChildren().addAll(temperatureSelectionLabel, temperatureRow1, temperatureRow2, backButton);

        Scene temperatureSelectionScene = new Scene(temperatureSelectionMenu, 700, 700);
        primaryStage.setScene(temperatureSelectionScene);
    }

    private void selectTemperature(String temp, Stage primaryStage) {
        selectedTemperature = temp;
        showConfirmation(primaryStage);
    }

    private void showConfirmation(Stage primaryStage) {
        VBox confirmationMenu = new VBox();
        confirmationMenu.setSpacing(10);
        Label confirmationLabel = new Label("Confirmation");
        Label confirmationText = new Label("Mode: " + selectedMode + ", Temperature: " + selectedTemperature);
        Button startButton = new Button("Start");
        Button setDelayButton = new Button("Set Delay");

        startButton.setOnAction(e -> startWashing(primaryStage));
        setDelayButton.setOnAction(e -> setDelay());

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> goBackToTemperatureSelection(primaryStage));

        confirmationMenu.getChildren().addAll(confirmationLabel, confirmationText, startButton, setDelayButton, backButton);

        Scene confirmationScene = new Scene(confirmationMenu, 700, 700);
        primaryStage.setScene(confirmationScene);
    }

    private void startWashing(Stage primaryStage) {
        VBox statusMenu = new VBox();
        statusMenu.setSpacing(10);
        Label statusLabel = new Label("Starting washing cycle...");
        Label statusText = new Label("");

        statusMenu.getChildren().addAll(statusLabel, statusText);

        Scene statusScene = new Scene(statusMenu, 700, 700);
        primaryStage.setScene(statusScene);

        // Simulate washing process
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                Platform.runLater(() -> statusText.setText("Washing..."));
                Thread.sleep(2000);
                Platform.runLater(() -> statusText.setText("Draining water..."));
                Thread.sleep(2000);
                Platform.runLater(() -> {
                    statusText.setText("Done. Door unlocked.");
                    Button exitButton = new Button("Exit");
                    exitButton.setOnAction(e -> Platform.exit());
                    statusMenu.getChildren().add(exitButton);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void setDelay() {
        // Implement delay logic
    }

    private void toggleVoiceCommand() {
        // Implement voice command logic
    }

    private void pairBluetooth() {
        // Implement Bluetooth pairing logic
    }

    private void goBackToMainMenu(Stage primaryStage) {
        start(primaryStage);
    }

    private void goBackToWashingModes(Stage primaryStage) {
        showWashingModes(primaryStage);
    }

    private void goBackToTemperatureSelection(Stage primaryStage) {
        showTemperatureSelection(primaryStage);
    }

    private void showSettings(Stage primaryStage) {
        VBox settingsMenu = new VBox();
        settingsMenu.setSpacing(10);
        Label settingsLabel = new Label("Settings");

        Button voiceCommandButton = new Button("Voice Command");
        Button bluetoothButton = new Button("Pair Bluetooth");

        voiceCommandButton.setOnAction(e -> toggleVoiceCommand());
        bluetoothButton.setOnAction(e -> pairBluetooth());

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> goBackToMainMenu(primaryStage));

        settingsMenu.getChildren().addAll(settingsLabel, voiceCommandButton, bluetoothButton, backButton);

        Scene settingsScene = new Scene(settingsMenu, 700, 700);
        primaryStage.setScene(settingsScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}