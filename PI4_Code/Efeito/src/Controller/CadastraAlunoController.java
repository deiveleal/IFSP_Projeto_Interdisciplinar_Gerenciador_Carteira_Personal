/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.CadastraAlunoPage;
import Model.MenuAluno;
import Model.MenuPrincipal;
import Model.Util;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CadastraAlunoController implements Initializable{

    @FXML private Button bt_menu;
    @FXML private Button bt_sair;
    @FXML private Button bt_salvar;
    @FXML private TextField tf_nome;
    @FXML private TextField tf_data_nascimento;
    @FXML private TextField tf_endereco;
    @FXML private TextField tf_bairro;
    @FXML private TextField tf_cidade;
    @FXML private TextField tf_telefone;
    @FXML private TextField tf_email;
    @FXML private TextField tf_celular;
    @FXML private ComboBox<?> cb_tipo_sangue;
    @FXML private ComboBox<?> cb_fator_rh;
    @FXML private ComboBox<?> cb_sexo;
    @FXML private TextField tf_cpf;
    
    Util util = new Util();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Implementações do botão menu iniciar
        bt_menu.setOnMouseClicked((MouseEvent e) -> {
            MenuPrincipal menuPrinc = new MenuPrincipal();
            try {
                menuPrinc.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_menu.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                MenuPrincipal menuPrinc = new MenuPrincipal();
                try {
                    menuPrinc.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Implementações do botão sair
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
        CadastraAlunoPage.getStage().close();
    }
}
