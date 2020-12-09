/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CadastraUsuarioController {

    @FXML
    private Button bt_menu;

    @FXML
    private Button bt_sair;

    @FXML
    private Button bt_salvar;

    @FXML
    private TextField tf_nome;

    @FXML
    private TextField tf_data_nascimento;

    @FXML
    private TextField tf_endereco;

    @FXML
    private TextField tf_bairro;

    @FXML
    private TextField tf_cidade;

    @FXML
    private TextField tf_telefone;

    @FXML
    private TextField tf_email;

    @FXML
    private TextField tf_celular;

    @FXML
    private ComboBox<?> cb_tipo_sangue;

    @FXML
    private ComboBox<?> cb_fator_rh;

    @FXML
    private ComboBox<?> cb_sexo;

}
