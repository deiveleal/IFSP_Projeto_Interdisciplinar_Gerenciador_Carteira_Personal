/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ModelScreen.DadosAlunoCadastradoScr;
import Model.ModelScreen.MenuPrincipalScr;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DadosAlunoCadastradoController implements Initializable{

    @FXML private Button bt_menu;
    @FXML private Button bt_sair;
    @FXML private Button bt_alterar_dados;
    @FXML private Text txt_nome;
    @FXML private Text txt_endereco;
    @FXML private Text txt_e_mail;
    @FXML private Text txt_sexo;
    @FXML private Text txt_tipo_sanguineo;
    @FXML private Text txt_fator_rh;
    @FXML private Text txt_bairro;
    @FXML private Text txt_cidade;
    @FXML private Text txt_telefone;
    @FXML private Text txt_celular;
    @FXML private Text txt_data_nascimento;
    @FXML private Text text_cpf;

    @FXML
    private Button bt_salvar;
    
    Util util = new Util();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Implementações do botão menu iniciar
        bt_menu.setOnMouseClicked((MouseEvent e) -> {
            MenuPrincipalScr menuPrinc = new MenuPrincipalScr();
            try {
                menuPrinc.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(ExerciciosController.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ExerciciosController.class.getName()).log(Level.SEVERE, null, ex);
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
        DadosAlunoCadastradoScr.getStage().close();
    }
}
