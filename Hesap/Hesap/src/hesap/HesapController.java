/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hesap;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author onurb
 */
public class HesapController implements Initializable {
    
    @FXML
    private TextField calculationTextField;
    
    @FXML
    private Text savedNumbers;
    
    private String firstNumber = "";
    private String currentNumber = "";
    private String TYPE;
    
    @FXML
    void buttonAddition(ActionEvent event) {
        calculation("+");
        
    }
    @FXML
    void buttonSubstraction(ActionEvent event) {
        calculation("-");
        
    }
    @FXML
    void buttonMultiplication(ActionEvent event) {
        calculation("*");
        
    }
    @FXML
    void buttonDivision(ActionEvent event) {
        calculation("/");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        calculationTextField.getText();
    }    
    public void calculation(String string) {
        int firstNumberInt = Integer.parseInt(firstNumber);
        int secondNumberInt = Integer.parseInt(currentNumber);
        if (TYPE.equals("+")) {
            int calculatedNumber = firstNumberInt + secondNumberInt;
                savedNumbers.setText(firstNumber + " + " + currentNumber + " = " + calculatedNumber);
                calculationTextField.setText(String.valueOf(calculatedNumber));
        }
        if (TYPE.equals("-")) {
            int calculatedNumber = firstNumberInt - secondNumberInt;
                savedNumbers.setText(firstNumber + " - " + currentNumber + " = " + calculatedNumber);
                calculationTextField.setText(String.valueOf(calculatedNumber));
        }
        if (TYPE.equals("/")) {
            double calculatedNumber = firstNumberInt / (double)secondNumberInt;
                savedNumbers.setText(firstNumber + " / " + currentNumber + " = " + calculatedNumber);
                calculationTextField.setText(String.valueOf(calculatedNumber));
        }
        if (TYPE.equals("*")) {
            int calculatedNumber = firstNumberInt * secondNumberInt;
                savedNumbers.setText(firstNumber + " * " + currentNumber + " = " + calculatedNumber);
                calculationTextField.setText(String.valueOf(calculatedNumber));
        }
    }
    void button0(ActionEvent event) {
        if(!currentNumber.equals("")){
            addNumber("0");
        }
    }
    void button1(ActionEvent event) {
        if(!currentNumber.equals("")){
            addNumber("1");
        }
    }
    void button2(ActionEvent event) {
        if(!currentNumber.equals("")){
            addNumber("2");
        }
    }
    void button3(ActionEvent event) {
        if(!currentNumber.equals("")){
            addNumber("3");
        }
    }
    void button4(ActionEvent event) {
        if(!currentNumber.equals("")){
            addNumber("4");
        }
    }
    void button5(ActionEvent event) {
        if(!currentNumber.equals("")){
            addNumber("5");
        }
    }
    void button6(ActionEvent event) {
        if(!currentNumber.equals("")){
            addNumber("6");
        }
    }
    void button7(ActionEvent event) {
        if(!currentNumber.equals("")){
            addNumber("7");
        }
    }
    void button8(ActionEvent event) {
        if(!currentNumber.equals("")){
            addNumber("8");
        }
    }
    void button9(ActionEvent event) {
        if(!currentNumber.equals("")){
            addNumber("9");
        }
    }    
        public void updateTextField(){
        calculationTextField.setText(currentNumber);
    }
    public void addNumber(String number) {
        currentNumber += number;
        updateTextField();
    }
}    

