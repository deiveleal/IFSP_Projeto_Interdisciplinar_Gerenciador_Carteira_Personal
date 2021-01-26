package Controller;

import DAO.RegistraAlunoDAO;
import DAO.RegistroAvaliacaoFisicaDAO;
import DAO.RegistroMedidasDAO;
import Model.ModelScreen.CadastraAlunoScr;
import Model.ModelScreen.DadosAlunoCadastradoScr;
import Model.ModelScreen.HistoricoAfericoesMedidasScr;
import Model.ModelScreen.HistoricoAvaliacaoFisicaScr;
import Model.ModelScreen.MenuAlunoScr;
import Model.ModelScreen.MenuPrincipalScr;
import Model.ModelScreen.RegistroAvaliacaoFisicaScr;
import Model.ModelScreen.RegistroMedidasScr;
import Model.RegistroAlunos;
import Model.RegistroAvaliacaoFisica;
import Model.RegistroMedidas;
import Model.Util;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuAlunoController implements Initializable {

    private ObservableList<RegistroAlunos> alunosList = FXCollections.observableArrayList();
    private ObservableList<RegistroAvaliacaoFisica> avaFisList = FXCollections.observableArrayList();
    private ObservableList<RegistroMedidas> medidasList = FXCollections.observableArrayList();
    private RegistroAlunos alunoSelecionado;
    Util util = new Util();

    @FXML
    private TextField tf_busca_nome;
    @FXML
    private Button bt_buscar;
    @FXML
    private TableView<RegistroAlunos> table_alunos;
    @FXML
    private TableColumn<RegistroAlunos, String> table_alunos_col_name;
    @FXML
    private TableColumn<RegistroAlunos, String> table_alunos_col_celular;
    @FXML
    private TableColumn<RegistroAlunos, String> table_alunos_col_telefone;
    @FXML
    private TableColumn<RegistroAlunos, String> table_alunos_col_email;
    @FXML
    private Button bt_cadastrar_aluno;
    @FXML
    private Button bt_ver_dados_completo;
    @FXML
    private TableView<RegistroAvaliacaoFisica> table_avaliacao_fisica;
    @FXML
    private TableColumn<RegistroAvaliacaoFisica, Date> table_avaliacao_fisica_col_data;
    @FXML
    private TableColumn<RegistroAvaliacaoFisica, Double> table_avaliacao_fisica_col_pressao;
    @FXML
    private TableColumn<RegistroAvaliacaoFisica, Double> table_avaliacao_fisica_col_batimento;
    @FXML
    private TableColumn<RegistroAvaliacaoFisica, Enum> table_avaliacao_fisica_col_condicionamento;
    @FXML
    private Button bt_add_avaliacao;
    @FXML
    private Button bt_ver_avaliações;
    @FXML
    private TableView<RegistroMedidas> table_medidas;
    @FXML
    private TableColumn<RegistroMedidas, Integer> table_medidas_col_id_aluno;
    @FXML
    private TableColumn<RegistroMedidas, Date> table_medidas_col_data;
    @FXML
    private TableColumn<RegistroMedidas, Double> table_medidas_col_peso;
    @FXML
    private TableColumn<RegistroMedidas, Double> table_medidas_col_altura;
    @FXML
    private TableColumn<RegistroMedidas, Double> table_medidas_col_peito;
    @FXML
    private TableColumn<RegistroMedidas, Double> table_medidas_col_braco;
    @FXML
    private Button bt_add_medidas;
    @FXML
    private Button bt_ver_medicoes;
    @FXML
    private Button bt_menu_iniciar;
    @FXML
    private Button bt_sair;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTableAlunos();

        table_alunos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                alunoSelecionado = (RegistroAlunos) newValue;
            }
        });

        //Implementação do botão buscar
        bt_buscar.setOnMouseClicked((MouseEvent e) -> {
            if (alunoSelecionado != null) {
                initTableAvaFis();
                initTableMedidas();
            } else {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setHeaderText("Nenhum aluno selecionado!");
                a.show();
            }
        });
        bt_buscar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (alunoSelecionado != null) {
                    initTableAvaFis();
                    initTableMedidas();
                } else {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setHeaderText("Nenhum aluno selecionado!");
                    a.show();
                }
            }
        });

        //Implementações do botão aluno
        bt_cadastrar_aluno.setOnMouseClicked((MouseEvent e) -> {
            CadastraAlunoScr cadAluno = new CadastraAlunoScr();
            try {
                cadAluno.start(new Stage());
                fechaJanela();
            } catch (Exception ex) {
                Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_cadastrar_aluno.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                CadastraAlunoScr cadAluno = new CadastraAlunoScr();

                try {
                    cadAluno.start(new Stage());
                    fechaJanela();
                } catch (Exception ex) {
                    Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        //Implementações do botão add medidas
        bt_ver_dados_completo.setOnMouseClicked((MouseEvent e) -> {
            if (alunoSelecionado != null) {
                DadosAlunoCadastradoScr dadoAlunCad = new DadosAlunoCadastradoScr(alunoSelecionado);
                try {
                    dadoAlunCad.start(new Stage());
                    fechaJanela();

                } catch (Exception ex) {
                    Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setHeaderText("Nenhum aluno selecionado!");
                a.show();
            }
        });
        bt_ver_dados_completo.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (alunoSelecionado != null) {
                    DadosAlunoCadastradoScr dadoAlunCad = new DadosAlunoCadastradoScr(alunoSelecionado);

                    try {
                        dadoAlunCad.start(new Stage());
                        fechaJanela();

                    } catch (Exception ex) {
                        Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setHeaderText("Nenhum aluno selecionado!");
                    a.show();
                }
            }
        });

        //Implementações do botão add medidas
        bt_add_avaliacao.setOnMouseClicked((MouseEvent e) -> {
            if (alunoSelecionado != null) {
                RegistroAvaliacaoFisicaScr regAvaFis = new RegistroAvaliacaoFisicaScr(alunoSelecionado);
                try {
                    regAvaFis.start(new Stage());
                    fechaJanela();
                } catch (Exception ex) {
                    Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setHeaderText("Nenhum aluno selecionado!");
                a.show();
            }
        });
        bt_add_avaliacao.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (alunoSelecionado != null) {
                    RegistroAvaliacaoFisicaScr regAvaFis = new RegistroAvaliacaoFisicaScr(alunoSelecionado);

                    try {
                        regAvaFis.start(new Stage());
                        fechaJanela();
                    } catch (Exception ex) {
                        Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setHeaderText("Nenhum aluno selecionado!");
                    a.show();
                }
            }
        });

        //Implementações do botão add medidas
        bt_ver_avaliações.setOnMouseClicked((MouseEvent e) -> {
            if (alunoSelecionado != null) {
                HistoricoAvaliacaoFisicaScr histAvaFis = new HistoricoAvaliacaoFisicaScr(alunoSelecionado);
                try {
                    histAvaFis.start(new Stage());

                } catch (Exception ex) {
                    Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setHeaderText("Nenhum aluno selecionado!");
                a.show();
            }
        });
        bt_ver_avaliações.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (alunoSelecionado != null) {
                    HistoricoAvaliacaoFisicaScr histAvaFis = new HistoricoAvaliacaoFisicaScr(alunoSelecionado);

                    try {
                        histAvaFis.start(new Stage());

                    } catch (Exception ex) {
                        Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setHeaderText("Nenhum aluno selecionado!");
                    a.show();
                }
            }
        });

        //Implementações do botão add medidas
        bt_add_medidas.setOnMouseClicked((MouseEvent e) -> {
            if (alunoSelecionado != null) {
                RegistroMedidasScr regMed = new RegistroMedidasScr(alunoSelecionado);
                try {
                    regMed.start(new Stage());
                    fechaJanela();
                } catch (Exception ex) {
                    Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setHeaderText("Nenhum aluno selecionado!");
                a.show();
            }
        });
        bt_add_medidas.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (alunoSelecionado != null) {
                    RegistroMedidasScr regMed = new RegistroMedidasScr(alunoSelecionado);
                    fechaJanela();

                    try {
                        regMed.start(new Stage());

                    } catch (Exception ex) {
                        Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setHeaderText("Nenhum aluno selecionado!");
                    a.show();
                }
            }
        });

        //Implementações do botão historico de medicoes
        bt_ver_medicoes.setOnMouseClicked((MouseEvent e) -> {
            if (alunoSelecionado != null) {
                HistoricoAfericoesMedidasScr histAferMed = new HistoricoAfericoesMedidasScr(alunoSelecionado);
                try {
                    histAferMed.start(new Stage());

                } catch (Exception ex) {
                    Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setHeaderText("Nenhum aluno selecionado!");
                a.show();
            }
        });
        bt_ver_medicoes.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                if (alunoSelecionado != null) {
                    HistoricoAfericoesMedidasScr histAferMed = new HistoricoAfericoesMedidasScr(alunoSelecionado);

                    try {
                        histAferMed.start(new Stage());

                    } catch (Exception ex) {
                        Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setHeaderText("Nenhum aluno selecionado!");
                    a.show();
                }
            }
        });

        //Implementações do botão menu inicial
        bt_menu_iniciar.setOnMouseClicked((MouseEvent e) -> {
            MenuPrincipalScr menuPrinc = new MenuPrincipalScr();

            try {
                menuPrinc.start(new Stage());
                fechaJanela();
            } catch (Exception ex) {
                Logger.getLogger(MenuAlunoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        bt_menu_iniciar.setOnKeyPressed((KeyEvent e) -> {
            if (e.getCode() == KeyCode.ENTER) {
                MenuPrincipalScr menuPrinc = new MenuPrincipalScr();

                try {
                    menuPrinc.start(new Stage());
                    fechaJanela();
                } catch (Exception ex) {
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

        tf_busca_nome.setOnKeyReleased((KeyEvent e) -> {
            table_alunos.setItems(buscaAluno());
        });
    }

    private void fechaJanela() {
        MenuAlunoScr.getStage().close();
    }

    public ObservableList<RegistroAlunos> atualizaTabela() {
        RegistraAlunoDAO dao = new RegistraAlunoDAO();
        alunosList = FXCollections.observableArrayList(dao.getList());
        return alunosList;
    }

    public ObservableList<RegistroAvaliacaoFisica> atualizaTabelaAvaFis() {
        RegistroAvaliacaoFisicaDAO dao = new RegistroAvaliacaoFisicaDAO();
        System.out.print("\nAluno selecionado: " + alunoSelecionado.getId_pessoa() + "\n");
        avaFisList = FXCollections.observableArrayList(dao.getListAvaliacaoFisica(alunoSelecionado.getId_pessoa()));
        return avaFisList;
    }

    public ObservableList<RegistroMedidas> atualizaTabelaMedidas() {
        RegistroMedidasDAO dao = new RegistroMedidasDAO();
        System.out.print("\nAluno selecionado: " + alunoSelecionado.getId_pessoa() + "\n");
        medidasList = FXCollections.observableArrayList(dao.getListaMedidas(alunoSelecionado.getId_pessoa()));
        return medidasList;
    }

    public void initTableAlunos() {
        table_alunos_col_name.setCellValueFactory(new PropertyValueFactory("nome"));
        table_alunos_col_celular.setCellValueFactory(new PropertyValueFactory("celular"));
        table_alunos_col_telefone.setCellValueFactory(new PropertyValueFactory("telefone"));
        table_alunos_col_email.setCellValueFactory(new PropertyValueFactory("email"));

        table_alunos.setItems(atualizaTabela());
    }

    public void initTableAvaFis() {
        table_avaliacao_fisica_col_data.setCellValueFactory(new PropertyValueFactory("data_avaliacao"));
        table_avaliacao_fisica_col_pressao.setCellValueFactory(new PropertyValueFactory("pressao_art"));
        table_avaliacao_fisica_col_batimento.setCellValueFactory(new PropertyValueFactory("batimento_repouso"));
        table_avaliacao_fisica_col_condicionamento.setCellValueFactory(new PropertyValueFactory("nivel_condicionamento"));

        table_avaliacao_fisica.setItems(atualizaTabelaAvaFis());
    }

    public void initTableMedidas() {
        table_medidas_col_id_aluno.setCellValueFactory(new PropertyValueFactory("id_aluno"));
        table_medidas_col_data.setCellValueFactory(new PropertyValueFactory("data_medicao"));
        table_medidas_col_peso.setCellValueFactory(new PropertyValueFactory("peso"));
        table_medidas_col_altura.setCellValueFactory(new PropertyValueFactory("altura"));
        table_medidas_col_peito.setCellValueFactory(new PropertyValueFactory("peito"));
        table_medidas_col_braco.setCellValueFactory(new PropertyValueFactory("braco"));

        table_medidas.setItems(atualizaTabelaMedidas());
    }

    private ObservableList<RegistroAlunos> buscaAluno() {
        ObservableList<RegistroAlunos> pesquisaAluno = FXCollections.observableArrayList();
        for (int x = 0; x < alunosList.size(); x++) {
            if (alunosList.get(x).getNome().toLowerCase().contains(tf_busca_nome.getText().toLowerCase())) {
                pesquisaAluno.add(alunosList.get(x));
            }
        }
        return pesquisaAluno;
    }

}
