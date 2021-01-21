/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.RegistroMedidasDAO;
import Model.MenuPrincipalScr;
import Model.RegistroAvaliacaoFisicaScr;
import Model.RegistroMedidas;
import Model.Util;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
public class RegistroAvaliacaoFisicaController implements Initializable {

    @FXML private TextField tf_id_aluno;
    @FXML private TextField tf_data;
    @FXML private TextField tf_peso;
    @FXML private TextField tf_altura;
    @FXML private TextField tf_pescoco;
    @FXML private TextField tf_peito;
    @FXML private TextField tf_braco;
    @FXML private TextField tf_antebraco;
    @FXML private TextField tf_cintura;
    @FXML private TextField tf_quadril;
    @FXML private TextField tf_coxa;
    @FXML private TextField tf_panturrilha;
    @FXML private Button bt_menu;
    @FXML private Button bt_salvar;
    @FXML private Button bt_sair;
    
    Util util = new Util();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        
        // Implementações do botão menu iniciar
        bt_menu.setOnMouseClicked((MouseEvent e) -> {
            MenuPrincipalScr menuPrinc = new MenuPrincipalScr();
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
                MenuPrincipalScr menuPrinc = new MenuPrincipalScr();
                try {
                    menuPrinc.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //Implementação do botão salvar
        bt_salvar.setOnMouseClicked((MouseEvent e) -> {
            try {
                salvarMedidas();
            } catch (ParseException ex) {
                Logger.getLogger(CadastraAlunoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_salvar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    salvarMedidas();
                } catch (ParseException ex) {
                    Logger.getLogger(CadastraAlunoController.class.getName()).log(Level.SEVERE, null, ex);
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
    
        private void salvarMedidas() throws ParseException {
        
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        
        int id_aluno = Integer.parseInt(tf_id_aluno.getText());
        Date data_medicao = fmt.parse(tf_data.getText());
        double peso = Double.parseDouble(tf_peso.getText());
        double altura = Double.parseDouble(tf_altura.getText());
        double pescoco = Double.parseDouble(tf_pescoco.getText());
        double peito = Double.parseDouble(tf_peito.getText());
        double braco = Double.parseDouble(tf_braco.getText());
        double antebraco = Double.parseDouble(tf_antebraco.getText());
        double cintura = Double.parseDouble(tf_cintura.getText());
        double quadril = Double.parseDouble(tf_quadril.getText());
        double coxa = Double.parseDouble(tf_coxa.getText());
        double panturrilha = Double.parseDouble(tf_panturrilha.getText());

        RegistroMedidas regMedid = new RegistroMedidas(id_aluno, data_medicao, peso, altura, pescoco, peito, braco, antebraco, cintura, quadril, coxa, panturrilha);
        RegistroMedidasDAO regMedDAO = new RegistroMedidasDAO();
        
        if (regMedDAO.inserir(regMedid)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Aluno cadastrado!");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erro ao cadastrar aluno!");
            alert.show();
        }
    }  
        
    private void fechaJanela() {
        RegistroAvaliacaoFisicaScr.getStage().close();
    }
    
}
