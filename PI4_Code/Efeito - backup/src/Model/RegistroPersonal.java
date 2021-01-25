/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * @author carolina
 * @author deive
 */
public class RegistroPersonal extends RegistroPessoa{
     

    public boolean cadastrarAluno(){
        return true;
    }
    public boolean montarTreino(){
        return false;
    }
    public boolean analisarDesempenho(){
        return false;
    }
    public boolean fazerAvaliacao(){
        return false;
    }
}
