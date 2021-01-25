/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.ModelScreen;

import Controller.RegistroMedidasController;
import Model.RegistroAlunos;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author carolina
 * @author deive
 */
public class RegistroMedidasScr extends Application {

    private static Stage stage;//Uma janela1

    public static void main(String[] args) {
        launch(args);
    }

    public RegistroMedidasScr(RegistroAlunos alunoSelecionado) {
        RegistroMedidasController.setRegAlunos(alunoSelecionado);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/RegistroMedidas.fxml"));//Carrega FXML
        Scene scene = new Scene(root);//Coloca o FXML em uma cena
        stage.setTitle("Registro de Medidas");
        stage.setScene(scene);//Coloca a cena em uma janela
        stage.show();//Abre a janela2
        setStage(stage);

    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        RegistroMedidasScr.stage = stage;
    }
    
}
