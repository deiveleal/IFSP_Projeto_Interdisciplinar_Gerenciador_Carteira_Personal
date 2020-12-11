/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author deive
 */
public class RegistroAlunos extends RegistroPessoa{
    private Enum tipoSanguineo; 
    private Enum rhSangue; 

    
//Métodos Geters e seters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Enum getSexo() {
        return sexo;
    }

    public void setSexo(Enum sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Enum getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(Enum tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public Enum getRhSangue() {
        return rhSangue;
    }

    public void setRhSangue(Enum rhSangue) {
        this.rhSangue = rhSangue;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    //Métodos específicos da classe
    public void submissaoAvaliacao(){
    }
    
    public boolean realizarPagamento(){
        return true;
    }
    
    public boolean cumprirTreino(){
        return true;
    }
    
}
