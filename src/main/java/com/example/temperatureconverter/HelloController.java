package com.example.temperatureconverter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.math.BigDecimal;
import java.util.Objects;

public class HelloController {

    @FXML
    private TextField leftField;

    @FXML
    private TextArea middleField;

    @FXML
    private TextField rightField;

    @FXML
    private Button CalculateButton;





    ObservableList<String> options =
            FXCollections.observableArrayList(
                    "C",
                    "F",
                    "K"
            );

    @FXML
    private ChoiceBox<String> leftChoiceBox;

    @FXML
    private ChoiceBox<String> rightChoiceBox;

    public void initialize() {
        rightChoiceBox.setItems(options);
        leftChoiceBox.setItems(options);

    }

    @FXML
    void handleCalculateButton(ActionEvent event) {

        if(Objects.equals(leftChoiceBox.getValue(), "C")){
            if(Objects.equals(rightChoiceBox.getValue(), "C")) {
                rightField.setText(String.valueOf(leftField.getText()));
                middleField.setText("C = C");

            }else if(Objects.equals(rightChoiceBox.getValue(), "F")){
                BigDecimal amount = new BigDecimal(leftField.getText());
                float inputTempFloat = Float.parseFloat(String.valueOf(amount));
                rightField.setText(String.valueOf(((inputTempFloat) * (9.0/5.0)) + 32));
                middleField.setText("C * (9.0/5.0) + 32 = F");
            }else if(Objects.equals(rightChoiceBox.getValue(), "K")){
                BigDecimal amount = new BigDecimal(leftField.getText());
                float inputTempFloat = Float.parseFloat(String.valueOf(amount));
                rightField.setText(String.valueOf((inputTempFloat) + 273.15));
                middleField.setText("C + 273.15 = K");

            } else{
                rightField.setText("ERROR");
            }
        } else if (Objects.equals(leftChoiceBox.getValue(), "F")){
            if(Objects.equals(rightChoiceBox.getValue(), "C")) {
                BigDecimal amount = new BigDecimal(leftField.getText());
                float inputTempFloat = Float.parseFloat(String.valueOf(amount));
                rightField.setText(String.valueOf(((inputTempFloat) - 32.0) * (5.0/9.0)));
                middleField.setText("(F - 32.0) * 5.0/9.0 = C");


            }else if(Objects.equals(rightChoiceBox.getValue(), "F")){
                rightField.setText(String.valueOf(leftField.getText()));
                middleField.setText("F = F");

            }else if(Objects.equals(rightChoiceBox.getValue(), "K")){
                BigDecimal amount = new BigDecimal(leftField.getText());
                float inputTempFloat = Float.parseFloat(String.valueOf(amount));
                rightField.setText(String.valueOf((((inputTempFloat) - 32.0) * (5.0/9.0))+273.15));
                middleField.setText("(F - 32.0) * 5.0/9.0 + 273.15 = K");

        }else{
                rightField.setText("ERROR");

            }
        } else if(Objects.equals(leftChoiceBox.getValue(), "K")){
                if(Objects.equals(rightChoiceBox.getValue(), "C")) {
                    BigDecimal amount = new BigDecimal(leftField.getText());
                    float inputTempFloat = Float.parseFloat(String.valueOf(amount));
                    rightField.setText(String.valueOf((inputTempFloat) - 273.15));
                    middleField.setText("(K - 273.15 = C");

                }else if(Objects.equals(rightChoiceBox.getValue(), "F")){
                    BigDecimal amount = new BigDecimal(leftField.getText());
                    float inputTempFloat = Float.parseFloat(String.valueOf(amount));
                    rightField.setText(String.valueOf(((inputTempFloat - 273.15) * (9.0/5.0)) + 32));
                    middleField.setText("(K - 273.15) * 9.0/5.0 + 32 = F");

                }else if(Objects.equals(rightChoiceBox.getValue(), "K")){
                    rightField.setText(String.valueOf(leftField.getText()));
                    middleField.setText("K = K");


                } else{
                    rightField.setText("ERROR");
                }

}else{
            rightField.setText("ERROR");
        }

    }}
