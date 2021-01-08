package Controller;

import Model.MenuAcompanhamento;
import Model.MenuAluno;
import Model.MenuExercicios;
import Model.MenuFinanceiro;
import Model.MenuPrincipal;
import Model.Util;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuPrincipalController implements Initializable{

    @FXML private Button bt_aluno;
    @FXML private Button bt_exercicios;
    @FXML private Button bt_acompanhamento;
    @FXML private Button bt_financeiro;
    @FXML private Button bt_sair;
    
    Util util = new Util();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Implementações do botão aluno
        bt_aluno.setOnMouseClicked((MouseEvent e) -> {
            MenuAluno menuAluno = new MenuAluno();

            try {
                menuAluno.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_aluno.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                MenuAluno menuAluno = new MenuAluno();

                try {
                    menuAluno.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //Implementação do botão exercicios
        bt_exercicios.setOnMouseClicked((MouseEvent e) -> {
            MenuExercicios menuExercicios = new MenuExercicios();

            try {
                menuExercicios.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_exercicios.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                MenuExercicios menuExercicios = new MenuExercicios();

                try {
                    menuExercicios.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //Implementações do botão acompanhamento
        bt_acompanhamento.setOnMouseClicked((MouseEvent e) -> {
            MenuAcompanhamento menuAcompanhamento = new MenuAcompanhamento();

            try {
                menuAcompanhamento.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_acompanhamento.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                MenuAcompanhamento menuAcompanhamento = new MenuAcompanhamento();

                try {
                    menuAcompanhamento.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //Implementações do botão financeiro
        bt_financeiro.setOnMouseClicked((MouseEvent e) -> {
            MenuFinanceiro menuFinanceiro = new MenuFinanceiro();

            try {
                menuFinanceiro.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_financeiro.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                MenuFinanceiro menuFinanceiro = new MenuFinanceiro();
                try {
                    menuFinanceiro.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });        
        
        //Implementações do botão Sair
        bt_sair.setOnMouseClicked((MouseEvent e) -> {
            util.voltaTelaLogin();
            fechaJanela();
        });   
        bt_sair.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                util.voltaTelaLogin();
                fechaJanela();
            }
        });
    }
    
    private void fechaJanela() {
        MenuPrincipal.getStage().close();
    }
    

}