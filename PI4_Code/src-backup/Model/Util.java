package Model;

import Model.ModelScreen.LoginScr;
import Controller.MenuPrincipalController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.Stage;

public class Util {

    public void voltaTelaLogin() {
        LoginScr login = new LoginScr();
        try {
            login.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
