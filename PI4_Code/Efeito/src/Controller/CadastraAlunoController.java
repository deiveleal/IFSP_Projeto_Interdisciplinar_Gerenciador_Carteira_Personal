/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.RegistroAlunoDAO;
import Model.CadastraAlunoScr;
import Model.MenuPrincipalScr;
import Model.RegistroAlunos;
import Model.RhSangueEnum;
import Model.SexoEnum;
import Model.TipoSanguineoEnum;
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
    @FXML private ComboBox<TipoSanguineoEnum> cb_tipo_sangue;
    @FXML private ComboBox<RhSangueEnum> cb_fator_rh;
    @FXML private ComboBox<SexoEnum> cb_sexo;
    @FXML private TextField tf_cpf;
    
    Util util = new Util();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cb_sexo.setItems(FXCollections.observableArrayList(SexoEnum.values()));
        cb_fator_rh.setItems(FXCollections.observableArrayList(RhSangueEnum.values()));
        cb_tipo_sangue.setItems(FXCollections.observableArrayList(TipoSanguineoEnum.values()));
        
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
                cadastraAluno();
            } catch (ParseException ex) {
                Logger.getLogger(CadastraAlunoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_salvar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    cadastraAluno();
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
    
    private void cadastraAluno() throws ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        String nome = tf_nome.getText(),
                rua = tf_endereco.getText(),
                bairro = tf_bairro.getText(),
                cidade = tf_cidade.getText(),
                telefone = tf_telefone.getText(),
                email = tf_email.getText(),
                cpf = tf_cpf.getText(),
                celular = tf_celular.getText();
        Date dataNascimento = fmt.parse(tf_data_nascimento.getText());
        Enum tipoSanguineo = (Enum) cb_tipo_sangue.getValue(),
                rhSangue = (Enum) cb_fator_rh.getValue(),
                sexo = (Enum) cb_sexo.getValue();

        RegistroAlunos regAlunos = new RegistroAlunos(nome, dataNascimento, sexo, cpf, email, tipoSanguineo, rhSangue, telefone, celular, rua, bairro, cidade);
        RegistroAlunoDAO regAlunoDAO = new RegistroAlunoDAO();
        
        if (regAlunoDAO.inserir(regAlunos)) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Usuário cadastrado!");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erro ao cadastrar usuário!");
            alert.show();
        }
    }
    
    private void fechaJanela() {
        CadastraAlunoScr.getStage().close();
    }
}
