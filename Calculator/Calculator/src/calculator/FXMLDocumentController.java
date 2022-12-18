package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

//MUHAMMED ALPEREN DOĞRUYOL 218CS2085
//ONUR BIÇAK 218CS2103

public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Label label1;

    private double result = 0;
    private String currentNumberStr = "";
    private String lastOperation = "";

    private boolean clickAnyNum = false;
    private boolean lastClickisEqualButton = false;

    boolean undefined, noResult;

    private void calculate(String operation) {
        double currentNum = Double.parseDouble(currentNumberStr);
        undefined = noResult = false;
        currentNumberStr = "";

        switch (operation) {
            case "%": // only modula 10
                result = currentNum % 10;
                break;
            case "/":
                if (result == 0) { //to take the second number.
                    result = 1;
                    result = currentNum / result;
                    break;
                }
                double dividend = result; //bölünen, pay
                double divisor = currentNum; //bölen, payda
                try {
                    if (dividend == 0 && divisor == 0) {
                        undefined = true;
                        System.out.println("0/0");
                        throw new ArithmeticException();
                    }
                    if (divisor == 0) {
                        noResult = true;
                        System.out.println("x/0");
                        throw new ArithmeticException();
                    } else {
                        result = dividend / divisor;
                        label.setText(result + "");
                    }
                } catch (ArithmeticException exception) {
                    System.out.println("ArithmeticException");
                }
                break;
            case "*":
                if (result == 0) { //to take the second number.
                    result = 1;
                    result = result * currentNum;
                    break;
                }
                result *= currentNum;
                break;
            case "-":
                if (result == 0) {
                    currentNum *= -1;
                    result = result - currentNum;
                    break;
                }
                result -= currentNum;
                break;
            case "+":
                result += currentNum;
                break;
            default:
                break;
        }
        setExceptionLabel();

        if (!undefined && !noResult) {
            label1.setText(result + " " + operation);
            label.setText(result + "");
        }
        currentNumberStr = "";
    }

    @FXML
    private void addNumber(String number) {
        currentNumberStr += number;
        label.setText(currentNumberStr);
        clickAnyNum = true;

        if (lastClickisEqualButton && clickAnyNum) {
            clickAnyNum = false;
            lastClickisEqualButton = false;
            resetCalculator("0", "");
        }
    }

    @FXML
    private void division(ActionEvent event) {
        lastOperation = "/";
        calculate(lastOperation);
    }

    @FXML
    private void multiplication(ActionEvent event) {
        lastOperation = "*";
        calculate(lastOperation);
    }

    @FXML
    private void substraction(ActionEvent event) {
        lastOperation = "-";
        calculate(lastOperation);
    }

    @FXML
    private void addition(ActionEvent event) {
        lastOperation = "+";
        calculate(lastOperation);
    }

    @FXML
    private void result(ActionEvent event) {
        String temp = result + "" + lastOperation + "" + currentNumberStr + "=";
        String tempCurrent = currentNumberStr;
        calculate(lastOperation);
        label1.setText(temp);
        currentNumberStr = tempCurrent;
        setExceptionLabel();
        lastClickisEqualButton = true;
    }

    @FXML
    private void ce(ActionEvent event) {
        resetCalculator("0", "");
    }

    @FXML
    private void c(ActionEvent event) {
        resetCalculator("0", "");
    }

    @FXML
    private void delete(ActionEvent event) { //delete
        if (!currentNumberStr.equals("")) {
            currentNumberStr = removeLastChar(currentNumberStr);
            label.setText(currentNumberStr);
        }
    }

    @FXML
    private void oneOverX(ActionEvent event) { //1/x
        double currentNum = Double.parseDouble(currentNumberStr);
        try {
            if (currentNum != 0) {
                String resultStr = 1 / currentNum + "";
                setLabelText(resultStr);
            } else {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException exception) {
            resetCalculator("Undefined", "Division by zero");
            System.out.println("ArithmeticException");
        }
    }

    @FXML
    private void xSquare(ActionEvent event) { //x^2
        double currentNum = Double.parseDouble(label.getText());
        String resultStr = currentNum * currentNum + "";
        setLabelText(resultStr);
    }

    @FXML
    private void rootX(ActionEvent event) { //rootX
        String resultStr = Math.sqrt(Double.parseDouble(label.getText())) + "";
        setLabelText(resultStr);
    }

    @FXML
    private void mod(ActionEvent event) { //mod
        lastOperation = "%";
        calculate(lastOperation);
    }

    @FXML
    private void plusMinus(ActionEvent event) {
        double currentNum = Double.parseDouble(label.getText());
        currentNum = currentNum * (-1);
        currentNumberStr = currentNum + "";
        label.setText(currentNum + "");
    }

    @FXML
    private void dot(ActionEvent event) {
        currentNumberStr += ".";
        label.setText(currentNumberStr);
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
        currentNumberStr = "";
    }

    private String removeLastChar(String number) {
        return number.substring(0, number.length() - 1);
    }

    private void resetCalculator(String labelText, String label1Text) {
        result = 0;
        currentNumberStr = "";
        label.setText(labelText);
        label1.setText(label1Text);
    }

    private void setExceptionLabel() {
        if (undefined) {
            resetCalculator("Undefined", "Division By Zero");
        }
        if (noResult) {
            resetCalculator("Undefined", "Zero Divided By Zero");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
