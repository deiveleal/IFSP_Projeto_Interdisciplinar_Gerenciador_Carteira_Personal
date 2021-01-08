/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.MenuAluno;
import Model.MenuExercicios;
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

/**
 * FXML Controller class
 *
 * @author deive
 */
public class MenuExerciciosController implements Initializable {
    
    @FXML private Button bt_cadastrar_aluno;
    @FXML private Button bt_avaliacao;
    @FXML private Button bt_medidas;
    @FXML private Button bt_menu_iniciar;
    @FXML private Button bt_sair;
    
    Util util = new Util();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        bt_menu_iniciar.setOnMouseClicked((MouseEvent e) -> {
            MenuPrincipal menuPrinc = new MenuPrincipal();
            try {
                menuPrinc.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(MenuExerciciosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_menu_iniciar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                MenuPrincipal menuPrinc = new MenuPrincipal();
                try {
                    menuPrinc.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(MenuExerciciosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

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
        MenuExercicios.getStage().close();
    };
}
