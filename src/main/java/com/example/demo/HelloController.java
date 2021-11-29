package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private String noun = "";
    private String verb = "";
    private String adverb = "";
    private String result = "";
    private String allstr = "";
    private String boxChoice1 = "";
    private String boxChoice2 = "";

    @FXML
    private RadioButton check_adverb;

    @FXML
    private TextField txt_field_input;

    @FXML
    private Button button_clearall;

    @FXML
    private Label lbl_output;

    @FXML
    private Button button_result;

    @FXML
    private ChoiceBox<String> choice_noun;

    @FXML
    private RadioButton check_noun;

    @FXML
    private ChoiceBox<String> choice_adverb;

    @FXML
    private RadioButton check_add;

    @FXML
    public void Implementation(javafx.event.ActionEvent event) {
        noun = "";
        verb = "";
        adverb = "";
        Alert alert = new Alert(Alert.AlertType.ERROR);

        if (event.getSource() == button_result) {
            lbl_output.setText("");
            allstr = "";
            allstr += txt_field_input.getText();
            for (int i = 0, j = 1; i < allstr.length(); i++) {
                if (allstr.charAt(i) == ' ') {
                    j++;
                    continue;
                }
                if (j == 1)
                    noun += allstr.charAt(i);

                if (j == 2)
                    verb += allstr.charAt(i);

                if (j == 3)
                    adverb += allstr.charAt(i);

            }


        }

        if (check_noun.isSelected()) {
            lbl_output.setText("");
            noun = choice_noun.getValue();
            choice_noun.getItems().addAll(null, "твой", "мой", "какой");

        }
        if(check_adverb.isSelected()){
            lbl_output.setText("");
            adverb= choice_adverb.getValue();
            choice_adverb.getItems().addAll(null, "весело", "грустно", "быстро", "натурально");

        }

        if(check_add.isSelected()){
            lbl_output.setText("");
            noun+=" бы";

        }

        if(noun==null){
            noun="";
        }
        if(adverb==null){
            adverb="";
        }
        lbl_output.setText(noun + " " + verb + " " + adverb);
        if(event.getSource()==button_clearall){
            txt_field_input.setText("");
            lbl_output.setText("");
            noun = "";
            verb = "";
            adverb = "";
            allstr="";
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
    }
}