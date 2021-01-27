package Model.ModelScreen;

import Controller.DadosAlunoCadastradoController;
import Model.RegistroAlunos;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DadosAlunoCadastradoScr extends Screen {

    private static Stage stage;//Uma janela1

    public static void main(String[] args) {
        launch(args);
    }

    public DadosAlunoCadastradoScr(RegistroAlunos alunoSelecionado) {
        DadosAlunoCadastradoController.setAlunoReg(alunoSelecionado);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/DadosAlunoCadastrado.fxml"));//Carrega FXML
        Scene scene = new Scene(root);//Coloca o FXML em uma cena
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Dados do Aluno");
        stage.setScene(scene);//Coloca a cena em uma janela
        stage.show();//Abre a janela2
        setStage(stage);

    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        DadosAlunoCadastradoScr.stage = stage;
    }

}
