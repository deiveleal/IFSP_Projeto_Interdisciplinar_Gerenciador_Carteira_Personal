
package Controller;

import Model.ModelComboBox.QuantidadeMesesCB;
import Model.ModelScreen.CadastraAlunoScr;
import Model.ModelScreen.CadastraPlanoScr;
import Model.ModelScreen.MenuPrincipalScr;
import Model.Util;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author carolina
 */
public class CadastraPlanoController implements Initializable {
    
    @FXML    private TextField tf_nome_aluno;
    @FXML    private TextField tf_id_aluno;
    @FXML    private TextField tf_valor;
    @FXML    private Button bt_menu;
    @FXML    private Button bt_sair;
    @FXML    private Button bt_salvar;
    @FXML    private ComboBox<QuantidadeMesesCB> cb_tipoplano;
    
    private List<QuantidadeMesesCB> quantidadeMeses = new ArrayList<>();
    private ObservableList<QuantidadeMesesCB> obsQuantidadeMesesCB;
    
    Util util = new Util();
 
    /**
     * Initializes the controller class.
     */
    @Override
    // Implementações do botão menu iniciar
    public void initialize(URL url, ResourceBundle rb) {
        
        //carrega ComboBox - preset de planos
        carregaComboBoxQuantidades();
        
        //Implementações do botão menu inicial
        bt_menu.setOnMouseClicked((MouseEvent e) -> {
            MenuPrincipalScr menuPrinc = new MenuPrincipalScr();
            try {
                menuPrinc.start(new Stage());
                fechaJanela();
            }
            catch (Exception ex) {
                Logger.getLogger(CadastraPlanoController.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(CadastraPlanoController.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void carregaComboBoxQuantidades(){
        
        QuantidadeMesesCB qtdMeses01 = new QuantidadeMesesCB(1,500,"Mensal");
        QuantidadeMesesCB qtdMeses02 = new QuantidadeMesesCB(2,450,"Bimestral");
        QuantidadeMesesCB qtdMeses03 = new QuantidadeMesesCB(3,425,"Trimestral");
        QuantidadeMesesCB qtdMeses04 = new QuantidadeMesesCB(6,400,"Semestral");
        QuantidadeMesesCB qtdMeses05 = new QuantidadeMesesCB(6,450,"Anual");
        
        quantidadeMeses.add(qtdMeses01);
        quantidadeMeses.add(qtdMeses02);
        quantidadeMeses.add(qtdMeses03);
        quantidadeMeses.add(qtdMeses04);
        quantidadeMeses.add(qtdMeses05);
        
        obsQuantidadeMesesCB = FXCollections.observableArrayList(quantidadeMeses);
        
        cb_tipoplano.setItems(FXCollections.observableArrayList(obsQuantidadeMesesCB));
    }
    
    private void fechaJanela() {
        CadastraPlanoScr.getStage().close();
        }

//    private QuantidadeMesesCB QuantidadeMesesCB() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}

