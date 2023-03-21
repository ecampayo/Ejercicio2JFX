package com.example.ejercicio2jfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button btnOperacion;
    @FXML
    private TextField txtOp1;
    @FXML
    private TextField txtOp2;
    @FXML
    private TextField txtResultado;
    @FXML
    private RadioButton rdbSuma;
    @FXML
    private RadioButton rdbResta;
    @FXML
    private RadioButton rdbMultiplicacion;
    @FXML
    private RadioButton rdbDivision;




    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tg=new ToggleGroup();
        this.rdbSuma.setToggleGroup(tg);
        this.rdbDivision.setToggleGroup(tg);
        this.rdbMultiplicacion.setToggleGroup(tg);
        this.rdbResta.setToggleGroup(tg);
    }

    @FXML
    private void hacerOperacion (ActionEvent event) {

        try {
            // Obtengo los parametros
            int op1 = Integer.parseInt(this.txtOp1.getText());
            int op2 = Integer.parseInt(this.txtOp2.getText());

            // Creo una instancia del modelo
            Operaciones op = new Operaciones (op1, op2);
            // operaciones según el RadioButton seleccionado
            if (this.rdbSuma.isSelected()){
                this.txtResultado.setText(op.suma() + "");
            }else if (this.rdbResta.isSelected()){
                this.txtResultado.setText(op.resta() + "");
            }else if (this.rdbMultiplicacion.isSelected()){
                this.txtResultado.setText(op.multiplicacion()+"");
            }else if (this.rdbDivision.isSelected()){
                //Si el op2 es 0 tendré en cuenta el error
                if (op2==0){
                    Alert alert=new Alert (Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("El operando 2 no puede ser 0");
                    alert.showAndWait();
                }else {
                    this.txtResultado.setText(op.division()+"");
                }

            }

        } catch (NumberFormatException e) {
            // Alerta de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }

    }
}
