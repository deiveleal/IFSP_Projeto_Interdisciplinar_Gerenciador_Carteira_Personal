package Model.ModelScreen;

import Controller.HistoricoAvaliacaoFisicaController;
import Model.RegistroAlunos;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HistoricoAvaliacaoFisicaScr extends Screen {

    private static Stage stage;//Uma janela1

    public static void main(String[] args) {
        launch(args);
    }

    public HistoricoAvaliacaoFisicaScr(RegistroAlunos alunoSelecionado) {
        HistoricoAvaliacaoFisicaController.setRegAlunos(alunoSelecionado);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/HistoricoAvaliacaoFisica.fxml"));//Carrega FXML
        Scene scene = new Scene(root);//Coloca o FXML em uma cena
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Histórico de Avaliação Física");
        stage.setScene(scene);//Coloca a cena em uma janela
        stage.show();//Abre a janela2
        setStage(stage);

    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        HistoricoAvaliacaoFisicaScr.stage = stage;
    }

}
