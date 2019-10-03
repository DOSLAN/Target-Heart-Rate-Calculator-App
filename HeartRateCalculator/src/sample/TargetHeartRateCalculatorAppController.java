package sample;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class TargetHeartRateCalculatorAppController {



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField inputAge;

    @FXML
    private Label displayMaxHeartRate;

    @FXML
    private Label displayTargetHeartRate;

    @FXML
    private Button CalculateButton;

    public void CalculatePressed(javafx.event.ActionEvent actionEvent) {
        calculate();
    }

    @FXML
    void initialize() {
        assert inputAge != null : "fx:id=\"inputAge\" was not injected: check your FXML file 'Target-Heart-RateCalculatorApp.fxml.fxml'.";
        assert displayMaxHeartRate != null : "fx:id=\"displayMaxHeartRate\" was not injected: check your FXML file 'Target-Heart-RateCalculatorApp.fxml.fxml'.";
        assert displayTargetHeartRate != null : "fx:id=\"displayTargetHeartRate\" was not injected: check your FXML file 'Target-Heart-RateCalculatorApp.fxml.fxml'.";

        onlyNumber(inputAge);
    }

    private void onlyNumber(TextField textField) {
        textField.textProperty().addListener((observable, oldValue,newValue) ->{
            if (!newValue.matches("\\d*")) {
                textField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    private void calculate() {
        int resultOfMaxHeartRate , resultOfTargetHeartRateFrom , resultOfTargetHeartRateTo; String resultOfTargetHeartRate;
        resultOfMaxHeartRate = 220 - Integer.valueOf(inputAge.getText());
        displayMaxHeartRate.setText(String.valueOf(resultOfMaxHeartRate));
        resultOfTargetHeartRateFrom = 50*resultOfMaxHeartRate/100;
        resultOfTargetHeartRateTo = 85*resultOfMaxHeartRate/100;
        resultOfTargetHeartRate = "from "+resultOfTargetHeartRateFrom+" to "+resultOfTargetHeartRateTo;
        displayTargetHeartRate.setText(resultOfTargetHeartRate);

    }
}
