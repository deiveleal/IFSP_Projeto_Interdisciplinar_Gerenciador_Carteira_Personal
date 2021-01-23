/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelScreen.CadastraAlunoScr;
import Model.ModelScreen.CadastraPlanoScr;
import Model.ModelScreen.MenuPrincipalScr;
import Model.Util;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author carolina
 */
public class CadastraPlanoController implements Initializable {
    
    @FXML    private Text t_titulo;
    @FXML    private TextField tf_nome_aluno;
    @FXML    private TextField tf_id_aluno;
    @FXML    private Text t_titulo1;
    @FXML    private Text t_titulo11;
    @FXML    private TextField tf_valor;
    @FXML    private Button bt_menu;
    @FXML    private Button bt_sair;
    @FXML    private Button bt_salvar;
    
    Util util = new Util();
 
    /**
     * Initializes the controller class.
     */
    @Override
    // Implementações do botão menu iniciar
    public void initialize(URL url, ResourceBundle rb) {
        
        //Implementações do botão menu inicial
        bt_menu.setOnMouseClicked((MouseEvent e) -> {
            MenuPrincipalScr menuPrinc = new MenuPrincipalScr();
            try {
                menuPrinc.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(CadastraPlanoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_menu.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                MenuPrincipalScr menuPrinc = new MenuPrincipalScr();

                try {
                    menuPrinc.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(CadastraPlanoController.class.getName()).log(Level.SEVERE, null, ex);
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
        CadastraPlanoScr.getStage().close();
        }
}
