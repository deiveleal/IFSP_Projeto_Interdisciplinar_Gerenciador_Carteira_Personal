package Model.ModelScreen;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CadastraPlanoScr extends Screen {

    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/CadastraPlano.fxml"));//Carrega FXML
        Scene scene = new Scene(root);//Coloca o FXML em uma cena
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("Cadastro de Plano");
        stage.setScene(scene);//Coloca a cena em uma janela
        stage.show();//Abre a janela2
        setStage(stage);

    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        CadastraPlanoScr.stage = stage;
    }

}
