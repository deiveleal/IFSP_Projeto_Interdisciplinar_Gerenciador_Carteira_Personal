package Controller;

import Model.ModelScreen.CadastraAlunoScr;
import Model.ModelScreen.DadosAlunoCadastradoScr;
import Model.ModelScreen.MenuAlunoScr;
import Model.ModelScreen.MenuPrincipalScr;
import Model.ModelScreen.RegistroAvaliacaoFisicaScr;
import Model.ModelScreen.RegistroMedidasScr;
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
import javafx.stage.Stage;

public class MenuAlunoController implements Initializable{

    @FXML private TextField tf_entra_nome_aluno;
    @FXML private Button bt_buscar;
    @FXML private Button bt_dados_aluno;
    @FXML private Button bt_cadastrar_aluno;
    @FXML private Button bt_avaliacao;
    @FXML private Button bt_add_avaliacao;
    @FXML private Button bt_medidas;
    @FXML private Button bt_add_medidas;
    @FXML private Button bt_ultimo_treino;
    @FXML private Button bt_add_treino;
    @FXML private Button bt_menu_iniciar;
    @FXML private Button bt_sair;
    
    Util util = new Util();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        



        //Implementação da ação do botão aluno
        bt_dados_aluno.setOnMouseClicked((MouseEvent e) -> {
            DadosAlunoCadastradoScr dadoAlunoCad = new DadosAlunoCadastradoScr();

            try {
                dadoAlunoCad.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_dados_aluno.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                DadosAlunoCadastradoScr dadoAlunoCad = new DadosAlunoCadastradoScr();

                try {
                    dadoAlunoCad.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });       
        
        //Implementações do botão aluno
        bt_cadastrar_aluno.setOnMouseClicked((MouseEvent e) -> {
            CadastraAlunoScr cadAluno = new CadastraAlunoScr();

            try {
                cadAluno.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_cadastrar_aluno.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                CadastraAlunoScr cadAluno = new CadastraAlunoScr();

                try {
                    cadAluno.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //Implementações do botão add avaliação
        bt_add_avaliacao.setOnMouseClicked((MouseEvent e) -> {
            RegistroAvaliacaoFisicaScr regAvaFis = new RegistroAvaliacaoFisicaScr();

            try {
                regAvaFis.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_add_avaliacao.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                RegistroAvaliacaoFisicaScr regAvaFis = new RegistroAvaliacaoFisicaScr();

                try {
                    regAvaFis.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //Implementações do botão add medidas
        bt_add_medidas.setOnMouseClicked((MouseEvent e) -> {
            RegistroMedidasScr regMed = new RegistroMedidasScr();

            try {
                regMed.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_add_medidas.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                RegistroMedidasScr regMed = new RegistroMedidasScr();

                try {
                    regMed.start(new Stage());
                    fechaJanela();
                }
                catch (Exception ex) {
                    Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        //Implementações do botão menu inicial
        bt_menu_iniciar.setOnMouseClicked((MouseEvent e) -> {
            MenuPrincipalScr menuPrinc = new MenuPrincipalScr();

            try {
                menuPrinc.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
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
        MenuAlunoScr.getStage().close();
    }
    

}