/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.EquipamentosScr;
import Model.MenuPrincipalScr;
import Model.RegistroAvaliacaoFisicaScr;
import Model.RegistroMedidasScr;
import Model.Util;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author deive
 */
public class EquipamentosController implements Initializable {
    
    @FXML private TextField tf_busca_aluno;
    @FXML private Button bt_buscar;
    @FXML private Button bt_add_equipamento;
    @FXML private TableView<?> table_esquipamentos;
    @FXML private TableColumn<?, ?> table_column_equipamento;
    @FXML private TableColumn<?, ?> table_column_caracteristica;
    @FXML private TableColumn<?, ?> table_column_caracteristica1;
    @FXML private Button bt_menu_iniciar;
    @FXML private Button bt_sair;
    
    Util util = new Util();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // Implementações do botão add avaliação física
        bt_buscar.setOnMouseClicked((MouseEvent e) -> {
            RegistroAvaliacaoFisicaScr regAvaFis = new RegistroAvaliacaoFisicaScr();
            try {
                regAvaFis.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(EquipamentosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_buscar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                RegistroAvaliacaoFisicaScr regAvaFis = new RegistroAvaliacaoFisicaScr();
                try {
                    regAvaFis.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(EquipamentosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        // Implementações do botão add medidas
        bt_add_equipamento.setOnMouseClicked((MouseEvent e) -> {
            RegistroMedidasScr regMed = new RegistroMedidasScr();
            try {
                regMed.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(EquipamentosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_add_equipamento.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                RegistroMedidasScr regMed = new RegistroMedidasScr();
                try {
                    regMed.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(EquipamentosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
              
        // Implementações do botão menu iniciar
        bt_menu_iniciar.setOnMouseClicked((MouseEvent e) -> {
            MenuPrincipalScr menuPrinc = new MenuPrincipalScr();
            try {
                menuPrinc.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(EquipamentosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_menu_iniciar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                MenuPrincipalScr menuPrinc = new MenuPrincipalScr();
                try {
                    menuPrinc.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(EquipamentosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Implementações do botão do sair
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
        EquipamentosScr.getStage().close();
    };
}
