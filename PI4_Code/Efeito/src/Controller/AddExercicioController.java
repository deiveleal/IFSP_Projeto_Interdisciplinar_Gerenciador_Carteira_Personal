/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.AddExercicioDAO;
import Model.AddExercicio;
import Model.AddExercicioScr;
import Model.MenuPrincipalScr;
import Model.Util;
import java.net.URL;
import java.text.ParseException;
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
public class AddExercicioController implements Initializable {

    @FXML private TextField tf_nome_exercicio;
    @FXML private TextField tf_grupo_muscular;
    @FXML private TextField tf_acao_principal;
    @FXML private TextField tf_posicao;
    @FXML private TextField tf_observacoes;
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
        
        //Implementação do botão salvar
        bt_salvar.setOnMouseClicked((MouseEvent e) -> {
            try {
                salvarExercicio();
            } catch (ParseException ex) {
                Logger.getLogger(CadastraAlunoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_salvar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    salvarExercicio();
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
    
        private void salvarExercicio() throws ParseException {
        
        String nome_exercicio = tf_nome_exercicio.getText();
        String grupo_muscular = tf_grupo_muscular.getText();
        String acao_principal = tf_acao_principal.getText();
        String posicao = tf_posicao.getText();
        String observacao = tf_observacoes.getText();

        AddExercicio addExerc = new AddExercicio(nome_exercicio, grupo_muscular, acao_principal, posicao, observacao);
        AddExercicioDAO addExercDAO = new AddExercicioDAO();
        
        if (addExercDAO.inserir(addExerc)) {
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
        AddExercicioScr.getStage().close();
    }
    
}
