
package Controller;

import DAO.RegistroAvaliacaoFisicaDAO;
import Model.ModelEnum.CondicionamentoFisicoEnum;
import Model.ModelScreen.MenuPrincipalScr;
import Model.RegistroAvaliacaoFisica;
import Model.ModelScreen.RegistroAvaliacaoFisicaScr;
import Model.RegistroAlunos;
import Model.Util;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class RegistroAvaliacaoFisicaController implements Initializable {

    @FXML private TextField tf_id_aluno;
    @FXML private TextField tf_data;
    @FXML private TextField tf_pressao_arterial;
    @FXML private TextField tf_batimento_repouso;
    @FXML private ComboBox<CondicionamentoFisicoEnum> cb_condicionamento;
    @FXML private Button bt_menu;
    @FXML private Button bt_salvar;
    @FXML private Button bt_sair;
    
    Util util = new Util();
    private static RegistroAlunos regAlunos;

    public static RegistroAlunos getRegAlunos() {
        return regAlunos;
    }

    public static void setRegAlunos(RegistroAlunos regAlunos) {
        RegistroAvaliacaoFisicaController.regAlunos = regAlunos;
    }

 
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniCampos();
        
        // Implementações do botão menu iniciar
        bt_menu.setOnMouseClicked((MouseEvent e) -> {
            MenuPrincipalScr menuPrinc = new MenuPrincipalScr();
            try {
                menuPrinc.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(RegistroAvaliacaoFisicaController.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(RegistroAvaliacaoFisicaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //Implementação do botão salvar
        bt_salvar.setOnMouseClicked((MouseEvent e) -> {
            try {
                salvarAvaFis();
            } catch (ParseException ex) {
                Logger.getLogger(CadastraAlunoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_salvar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    salvarAvaFis();
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
    
    private void salvarAvaFis() throws ParseException {
        
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        
        int id_aluno = Integer.parseInt(tf_id_aluno.getText());
        Date data_avaliacao = fmt.parse(tf_data.getText());
        double pressao_art = Double.parseDouble(tf_pressao_arterial.getText());
        double batimento_repouso = Double.parseDouble(tf_batimento_repouso.getText());
        Enum nivel_condicionamento = (Enum) cb_condicionamento.getValue();


        RegistroAvaliacaoFisica regAvaFis = new RegistroAvaliacaoFisica(id_aluno, data_avaliacao, pressao_art, batimento_repouso, nivel_condicionamento);
        RegistroAvaliacaoFisicaDAO regAvaFisDAO = new RegistroAvaliacaoFisicaDAO();            
        
        if (regAvaFisDAO.inserir(regAvaFis)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Avaliação Física Registrada!");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erro ao registrar avaliação física!");
            alert.show();
        }
    }  
    
    private void iniCampos(){
        cb_condicionamento.setItems(FXCollections.observableArrayList(CondicionamentoFisicoEnum.values()));
        tf_id_aluno.setText(Integer.toString(regAlunos.getId_pessoa()));
    }
        
    private void fechaJanela() {
        RegistroAvaliacaoFisicaScr.getStage().close();
    }
    
}
