/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.RegistroAvaliacaoFisicaDAO;
import Model.ModelScreen.HistoricoAvaliacaoFisicaScr;
import Model.ModelScreen.MenuPrincipalScr;
import Model.RegistroAlunos;
import Model.RegistroAvaliacaoFisica;
import Model.Util;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author deive
 */
public class HistoricoAvaliacaoFisicaController implements Initializable {

    @FXML private TableView<RegistroAvaliacaoFisica> table_avaliacao_fisica;
    @FXML private TableColumn<RegistroAvaliacaoFisica, Date> table_avaliacao_fisica_data;
    @FXML private TableColumn<RegistroAvaliacaoFisica, Double> table_avaliacao_fisica_pressao;
    @FXML private TableColumn<RegistroAvaliacaoFisica, Double> table_avaliacao_fisica_batimentos;
    @FXML private TableColumn<RegistroAvaliacaoFisica, Enum> table_avaliacao_fisica_nivel_condicionamento;
    @FXML private Button bt_menu;
    @FXML private Button bt_sair;
    @FXML private Label lbl_id_aluno;
    
    Util util = new Util();
    private ObservableList<RegistroAvaliacaoFisica> avaFisList = FXCollections.observableArrayList();
    private static RegistroAlunos regAlunos;
    

    public static RegistroAlunos getRegAlunos() {
        return regAlunos;
    }

    public static void setRegAlunos(RegistroAlunos regAlunos) {
        HistoricoAvaliacaoFisicaController.regAlunos = regAlunos;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCampos();
        
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
    
       
    public void initCampos() {
        lbl_id_aluno.setText(Integer.toString(regAlunos.getId_pessoa()));
        initTableAvaliacaoFisica();

    }
        
    private void fechaJanela() {
        HistoricoAvaliacaoFisicaScr.getStage().close();
    }
        public ObservableList<RegistroAvaliacaoFisica> atualizaTabelaAvaFis() {
        RegistroAvaliacaoFisicaDAO dao = new RegistroAvaliacaoFisicaDAO();
        avaFisList = FXCollections.observableArrayList(dao.getListAvaliacaoFisica(regAlunos.getId_pessoa()));
        return avaFisList;
    }
    
    public void initTableAvaliacaoFisica() {
        table_avaliacao_fisica_data.setCellValueFactory(new PropertyValueFactory("data_avaliacao"));
        table_avaliacao_fisica_pressao.setCellValueFactory(new PropertyValueFactory("pressao_art"));
        table_avaliacao_fisica_batimentos.setCellValueFactory(new PropertyValueFactory("batimento_repouso"));
        table_avaliacao_fisica_nivel_condicionamento.setCellValueFactory(new PropertyValueFactory("nivel_condicionamento"));

        table_avaliacao_fisica.setItems(atualizaTabelaAvaFis());
    }
    
}
