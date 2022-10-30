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
    
    @FXML
    private Label label1;

    private double result = 0;
    private String currentNumberStr = "";
    private String lastOperation="";
    private void compute(String operation) {
        
        double currentNum = Double.parseDouble(currentNumberStr);
        currentNumberStr = " ";
        label1.setText(currentNum + " " + operation);
        
        switch (operation) {
            /*bak*/
            case "%":
                    if (result == 0) {
                    result = 1 ;
                    result=currentNum;
                    break;
                }
                result = result % currentNum;
                break;
            case "/":
                 if (result == 0) {
                    result = 1 ;
                    result=currentNum/result;
                    break;
                }
                result /= currentNum;
                break;
            case "*":
                if (result == 0) {
                    result = 1 ;
                    result=result*currentNum;
                    break;
                }
                result *= currentNum;
                break;
            case "-":
                if (result==0) {
                    
                    currentNum*=-1;
                    result=result-currentNum;
                    break;
                    
                }
                result -= currentNum;
                break;
            case "+":
                result += currentNum;
                break;
            case "=":
                label1.setText(currentNumberStr+"=");
                compute(lastOperation);
                break;
            default:
                break;
        }
        
        label1.setText(result + " " + operation);
        label.setText(result + " ");
    }

    @FXML
    private void addNumber(String number) {
        currentNumberStr += number;
        label.setText(currentNumberStr);
    }

    @FXML
    private void division(ActionEvent event) {
        lastOperation="/";
        compute(lastOperation);
        
    }

    @FXML
    private void multiplication(ActionEvent event) {
        lastOperation="*";
        compute(lastOperation);
        
    }

    @FXML
    private void substraction(ActionEvent event) {
        lastOperation="-";
        compute(lastOperation);
        
    }

    @FXML
    private void addition(ActionEvent event) {
        lastOperation="+";
        compute(lastOperation);
    }

    @FXML
    private void result(ActionEvent event) {
        compute(lastOperation);
    }
    
    @FXML
    private void ce(ActionEvent event) {
        result = 0;
        currentNumberStr = "";
        label.setText("");
        label1.setText("");
        System.out.println("ce");
    }

    @FXML
    private void c(ActionEvent event) {
        result = 0;
        currentNumberStr = "";
        label.setText("");
        label1.setText("");
        System.out.println("c");
    }

    @FXML
    private void delete(ActionEvent event) {
        if (!currentNumberStr.equals("")) {
            currentNumberStr = removeLastChar(currentNumberStr);
            label.setText(currentNumberStr);
        }
        System.out.println("delete");
    }

    @FXML
    private void oneOverX(ActionEvent event) {
        double currentNum = Double.parseDouble(currentNumberStr);
        if (currentNum != 0) {
            String resultStr = 1 / currentNum + "";
            setLabelText(resultStr);
        } else {
            setLabelText("undefined");
        }
        System.out.println("1/x");
    }

    @FXML
    private void xSquare(ActionEvent event) {
        double currentNum = Double.parseDouble(currentNumberStr);
        String resultStr = currentNum * currentNum + "";
        setLabelText(resultStr);
        System.out.println("x^2");
    }

    @FXML
    private void rootX(ActionEvent event) {
        double currentNum = Double.parseDouble(currentNumberStr);
        String resultStr = Math.sqrt(currentNum) + "";
        setLabelText(resultStr);
        System.out.println("rootX");
    }

    @FXML
    private void mod(ActionEvent event) {
        compute("%");
        System.out.println("mod");
    }

    @FXML
    private void plusMinus(ActionEvent event) {
        double currentNum = Double.parseDouble(currentNumberStr);
        
        currentNum = currentNum * (-1) ;
        currentNumberStr = currentNum+"";
        label.setText(currentNum+"");
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        }
    }

