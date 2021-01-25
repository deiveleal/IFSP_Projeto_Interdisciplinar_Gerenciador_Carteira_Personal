/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.RegistroMedidasDAO;
import Model.ModelScreen.HistoricoAfericoesMedidasScr;
import Model.ModelScreen.MenuPrincipalScr;
import Model.RegistroAlunos;
import Model.RegistroMedidas;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
public class HistoricoAfericoesMedidasController implements Initializable {

    @FXML private TextField txf_id_aluno;
    @FXML private TableView<RegistroMedidas> table_medicoes;
    @FXML private TableColumn<RegistroMedidas, Date> table_medicoes_col_data;
    @FXML private TableColumn<RegistroMedidas, Double> table_medicoes_col_peso;
    @FXML private TableColumn<RegistroMedidas, Double> table_medicoes_col_altura;
    @FXML private TableColumn<RegistroMedidas, Double> table_medicoes_col_pescoco;
    @FXML private TableColumn<RegistroMedidas, Double> table_medicoes_col_peito;
    @FXML private TableColumn<RegistroMedidas, Double> table_medicoes_col_braco;
    @FXML private TableColumn<RegistroMedidas, Double> table_medicoes_col_antebraco;
    @FXML private TableColumn<RegistroMedidas, Double> table_medicoes_col_cintura;
    @FXML private TableColumn<RegistroMedidas, Double> table_medicoes_col_quadril;
    @FXML private TableColumn<RegistroMedidas, Double> table_medicoes_col_coxa;
    @FXML private TableColumn<RegistroMedidas, Double> table_medicoes_col_panturrilha;
    @FXML private Button bt_menu;
    @FXML private Button bt_sair;
    
    Util util = new Util();
    private ObservableList<RegistroMedidas> medidasList = FXCollections.observableArrayList();
    private static RegistroAlunos regAlunos;
    

    public static RegistroAlunos getRegAlunos() {
        return regAlunos;
    }

    public static void setRegAlunos(RegistroAlunos regAlunos) {
        HistoricoAfericoesMedidasController.regAlunos = regAlunos;
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
                Logger.getLogger(HistoricoAfericoesMedidasController.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(HistoricoAfericoesMedidasController.class.getName()).log(Level.SEVERE, null, ex);
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
        txf_id_aluno.setText(Integer.toString(regAlunos.getId_pessoa()));
        initTableAvaliacaoFisica();

    }
        
    private void fechaJanela() {
        HistoricoAfericoesMedidasScr.getStage().close();
    }
    
    public ObservableList<RegistroMedidas> atualizaTabelaMedicoes() {
        RegistroMedidasDAO dao = new RegistroMedidasDAO();
        medidasList = FXCollections.observableArrayList(dao.getListaMedidas(regAlunos.getId_pessoa()));
        return medidasList;
    }
    
    public void initTableAvaliacaoFisica() {
        table_medicoes_col_data.setCellValueFactory(new PropertyValueFactory("data_medicao"));
        table_medicoes_col_peso.setCellValueFactory(new PropertyValueFactory("peso"));
        table_medicoes_col_altura.setCellValueFactory(new PropertyValueFactory("altura"));
        table_medicoes_col_pescoco.setCellValueFactory(new PropertyValueFactory("pescoco"));
        table_medicoes_col_peito.setCellValueFactory(new PropertyValueFactory("peito"));
        table_medicoes_col_braco.setCellValueFactory(new PropertyValueFactory("braco"));
        table_medicoes_col_antebraco.setCellValueFactory(new PropertyValueFactory("antebraco"));
        table_medicoes_col_cintura.setCellValueFactory(new PropertyValueFactory("cintura"));
        table_medicoes_col_quadril.setCellValueFactory(new PropertyValueFactory("quadril"));
        table_medicoes_col_coxa.setCellValueFactory(new PropertyValueFactory("coxa"));
        table_medicoes_col_panturrilha.setCellValueFactory(new PropertyValueFactory("panturrilha"));

        table_medicoes.setItems(atualizaTabelaMedicoes());
    }
    
}
