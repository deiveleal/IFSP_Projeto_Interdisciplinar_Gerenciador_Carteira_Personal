package Model.ModelScreen;

import Controller.RegistroAvaliacaoFisicaController;
import Model.RegistroAlunos;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistroAvaliacaoFisicaScr extends Screen {

    private static Stage stage;//Uma janela1

    public static void main(String[] args) {
        launch(args);
    }

    public RegistroAvaliacaoFisicaScr(RegistroAlunos alunoSelecionado) {
        RegistroAvaliacaoFisicaController.setRegAlunos(alunoSelecionado);
    }

    public RegistroAvaliacaoFisicaScr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/RegistroAvaliacaoFisica.fxml"));//Carrega FXML
        Scene scene = new Scene(root);//Coloca o FXML em uma cena
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Registro de Avaliação Física");
        stage.setScene(scene);//Coloca a cena em uma janela
        stage.show();//Abre a janela2
        setStage(stage);

    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        RegistroAvaliacaoFisicaScr.stage = stage;
    }

}
