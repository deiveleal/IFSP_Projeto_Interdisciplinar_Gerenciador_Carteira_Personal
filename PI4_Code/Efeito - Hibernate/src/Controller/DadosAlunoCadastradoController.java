package Controller;

import Model.ModelScreen.CadastraAlunoScr;
import Model.ModelScreen.DadosAlunoCadastradoScr;
import Model.ModelScreen.MenuPrincipalScr;
import Model.RegistroAlunos;
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

public class DadosAlunoCadastradoController implements Initializable {

    Util util = new Util();
    private static RegistroAlunos REGISTROALUNOS;

    public static RegistroAlunos getAlunoReg() {
        return REGISTROALUNOS;
    }

    public static void setAlunoReg(RegistroAlunos alunoReg) {
        DadosAlunoCadastradoController.REGISTROALUNOS = alunoReg;

    }

    @FXML
    private Button bt_menu;
    @FXML
    private Button bt_sair;
    @FXML
    private Button bt_alterar_dados;
    @FXML
    private Text txt_nome;
    @FXML
    private Text txt_endereco;
    @FXML
    private Text txt_e_mail;
    @FXML
    private Text txt_sexo;
    @FXML
    private Text txt_tipo_sanguineo;
    @FXML
    private Text txt_fator_rh;
    @FXML
    private Text txt_bairro;
    @FXML
    private Text txt_cidade;
    @FXML
    private Text txt_telefone;
    @FXML
    private Text txt_celular;
    @FXML
    private Text txt_data_nascimento;
    @FXML
    private Text text_cpf;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        iniTela();

        // Implementações do botão menu iniciar
        bt_menu.setOnMouseClicked((MouseEvent e) -> {
            MenuPrincipalScr menuPrinc = new MenuPrincipalScr();
            try {
                menuPrinc.start(new Stage());
                fechaJanela();
            } catch (Exception ex) {
                Logger.getLogger(DadosAlunoCadastradoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_menu.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                MenuPrincipalScr menuPrinc = new MenuPrincipalScr();
                try {
                    menuPrinc.start(new Stage());
                    fechaJanela();
                } catch (Exception ex) {
                    Logger.getLogger(DadosAlunoCadastradoController.class.getName()).log(Level.SEVERE, null, ex);
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

        // Implementações do botão alterar dados
        bt_alterar_dados.setOnMouseClicked((MouseEvent e) -> {
            CadastraAlunoScr cadAlunoScr = new CadastraAlunoScr();
            try {
                cadAlunoScr.start(new Stage());
                fechaJanela();
            } catch (Exception ex) {
                Logger.getLogger(CadastraAlunoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_alterar_dados.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                CadastraAlunoScr cadAlunoScr = new CadastraAlunoScr();
                try {
                    cadAlunoScr.start(new Stage());
                    fechaJanela();
                } catch (Exception ex) {
                    Logger.getLogger(CadastraAlunoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void fechaJanela() {
        DadosAlunoCadastradoScr.getStage().close();
    }

    public void iniTela() {
        txt_nome.setText(REGISTROALUNOS.getNome());
        txt_endereco.setText(REGISTROALUNOS.getRua());
        txt_e_mail.setText(REGISTROALUNOS.getEmail());
        txt_sexo.setText(REGISTROALUNOS.getSexo().toString());
        txt_tipo_sanguineo.setText(REGISTROALUNOS.getTipoSanguineo().toString());
        txt_fator_rh.setText(REGISTROALUNOS.getRhSangue().toString());
        txt_bairro.setText(REGISTROALUNOS.getBairro());
        txt_cidade.setText(REGISTROALUNOS.getCidade());
        txt_telefone.setText(REGISTROALUNOS.getTelefone());
        txt_celular.setText(REGISTROALUNOS.getCelular());
        txt_data_nascimento.setText(REGISTROALUNOS.getDataNascimento().toString());
        text_cpf.setText(REGISTROALUNOS.getCpf());
    }
}
