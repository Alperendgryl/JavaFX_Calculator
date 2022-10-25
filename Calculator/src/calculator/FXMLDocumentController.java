package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    private String currentNumber = "";

    @FXML
    private void addNumber(String number) {
        currentNumber += number;
        label.setText(currentNumber);
    }

    @FXML
    private void ce(ActionEvent event) {
        currentNumber = "";
        label.setText("");
        System.out.println("ce");
    }

    @FXML
    private void c(ActionEvent event) {
        currentNumber = "";
        label.setText("");
        System.out.println("c");
    }

    @FXML
    private void delete(ActionEvent event) {
        if (!currentNumber.equals("")) {
            currentNumber = removeLastChar(currentNumber);
            label.setText(currentNumber);
        }
        System.out.println("delete");
    }

    @FXML
    private void oneOverX(ActionEvent event) {
        double currentNum = Double.parseDouble(currentNumber);
        if (currentNum != 0) {
            String result = 1 / currentNum + "";
            setLabelText(result);
        } else {
            setLabelText("undefined");
        }
        
        System.out.println("1/x");
    }

    @FXML
    private void xSquare(ActionEvent event) {
        double currentNum = Double.parseDouble(currentNumber);
        String result = currentNum * currentNum + "";
        setLabelText(result);
        
        System.out.println("x^2");
    }

    @FXML
    private void rootX(ActionEvent event) {
        double currentNum = Double.parseDouble(currentNumber);
        String result = Math.sqrt(currentNum) + "";
        setLabelText(result);
        
        System.out.println("rootX");
    }

    private void operation(String operation) {

        String temp = currentNumber;
        String saved;
        switch (operation) {
            case "%":
                saved = temp;
                label.setText(saved + operation + currentNumber);

            case "/":
                saved = temp + "" + operation;
                label.setText(temp + "" + operation);

            case "*":
                saved = temp + "" + operation;
                label.setText(temp + "" + operation);

            case "-":
                saved = temp + "" + operation;
                label.setText(temp + "" + operation);

            case "+":
                saved = temp + "" + operation;
                label.setText(temp + "" + operation);
        }
    }

    @FXML
    private void mod(ActionEvent event) {
        operation("%");
        System.out.println("mod");
    }
    
    @FXML
    private void division(ActionEvent event) {
        operation("/");
        System.out.println("division");
    }

    @FXML
    private void multiplication(ActionEvent event) {
        operation("*");
        System.out.println("multiplication");
    }

    @FXML
    private void substraction(ActionEvent event) {
        operation("-");
        System.out.println("substraction");

    }

    @FXML
    private void addition(ActionEvent event) {
        operation("+");
        System.out.println("addition");
    }

    @FXML
    private void result(ActionEvent event) {
        System.out.println("result");
    }

    @FXML
    private void plusMinus(ActionEvent event) {
        double currentNum = Double.parseDouble(currentNumber);
        currentNumber = currentNum * (-1) + "";
        label.setText(currentNumber);
    }

    @FXML
    private void dot(ActionEvent event) {
        currentNumber += ".";
        label.setText(currentNumber);
    }

    @FXML
    private void nine(ActionEvent event) {
        addNumber("9");
    }

    @FXML
    private void eight(ActionEvent event) {
        addNumber("8");
    }

    @FXML
    private void seven(ActionEvent event) {
        addNumber("7");
    }

    @FXML
    private void six(ActionEvent event) {
        addNumber("6");
    }

    @FXML
    private void five(ActionEvent event) {
        addNumber("5");
    }

    @FXML
    private void four(ActionEvent event) {
        addNumber("4");
    }

    @FXML
    private void three(ActionEvent event) {
        addNumber("3");
    }

    @FXML
    private void two(ActionEvent event) {
        addNumber("2");
    }

    @FXML
    private void one(ActionEvent event) {
        addNumber("1");
    }

    @FXML
    private void zero(ActionEvent event) {
        addNumber("0");
    }

    private void setLabelText(String result) {
        label.setText(result);
        currentNumber = "";
    }

    private String removeLastChar(String number) {
        return number.substring(0, number.length() - 1);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
