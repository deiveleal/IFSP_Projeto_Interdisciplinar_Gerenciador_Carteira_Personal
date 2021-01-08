/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 * @carol
 * @author deive
 */
public abstract class RegistroPessoa {
    public String nome;
    public Date dataNascimento; 
    public Enum sexo;
    public String cpf; 
    public String email;
    public String telefone; 
    public String celular; 
    public String rua;
    public String bairro;
    public String cidade;    
}
