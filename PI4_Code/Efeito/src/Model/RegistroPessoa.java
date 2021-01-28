package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class RegistroPessoa {

    private int id_pessoa;
    private String nome;
    private String nomeUsuario;
    private String senha;
    private Date dataNascimento;
    private Enum sexo;
    private String cpf;
    private String email;
    private Enum tipoSanguineo;
    private Enum rhSangue;
    private String telefone;
    private String celular;
    private String rua;
    private String bairro;
    private String cidade;

    private List<RegistroPessoa> registrosPessoas;

    public List<RegistroPessoa> getRegistrosPessoas() {
        return registrosPessoas;
    }

    public void setRegistrosPessoas(List<RegistroPessoa> registrosPessoas) {
        this.registrosPessoas = registrosPessoas;
    }

    public void addRegistro(RegistroPessoa registroPessoa) {
        this.registrosPessoas.add(registroPessoa);
    }
    
    public abstract void criaGrupos();

    public RegistroPessoa() {
        this.registrosPessoas = new ArrayList<>();
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

}
