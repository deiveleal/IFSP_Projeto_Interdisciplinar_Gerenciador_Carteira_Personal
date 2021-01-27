package Model.ModelScreen;

import Controller.HistoricoAfericoesMedidasController;
import Model.RegistroAlunos;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HistoricoAfericoesMedidasScr extends Screen {

    private static Stage stage;//Uma janela1

    public static void main(String[] args) {
        launch(args);
    }

    public HistoricoAfericoesMedidasScr(RegistroAlunos alunoSelecionado) {
        HistoricoAfericoesMedidasController.setRegAlunos(alunoSelecionado);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/HistoricoAfericoesMedidas.fxml"));//Carrega FXML
        Scene scene = new Scene(root);//Coloca o FXML em uma cena
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Histórico de Aferições Medidas");
        stage.setScene(scene);//Coloca a cena em uma janela
        stage.show();//Abre a janela2
        setStage(stage);

    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        HistoricoAfericoesMedidasScr.stage = stage;
    }

}
