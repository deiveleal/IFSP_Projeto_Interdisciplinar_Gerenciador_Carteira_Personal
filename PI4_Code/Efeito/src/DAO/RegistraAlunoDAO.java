/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactoryMysqlSingleton;
import Model.RegistroAlunos;
import Model.ModelEnum.SexoEnum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * @author carolina
 * @author deive
 */
public class RegistraAlunoDAO {
    private final Connection openCon;

    ConnectionFactoryMysqlSingleton conecta = ConnectionFactoryMysqlSingleton.getConnectionSingleton();

    public RegistraAlunoDAO() {
        this.openCon = conecta.getConnection();
    }

    public boolean inserir(RegistroAlunos aluno) {
        SimpleDateFormat fmtUS = new SimpleDateFormat("yyyy/MM/dd");
        String dataBanco = fmtUS.format(aluno.getDataNascimento());
        String sexo;
        if(aluno.getSexo().equals(SexoEnum.NAOBINARIO)){
            sexo = "nao-binario";
        }else{
            sexo = aluno.getSexo().toString();
        }
        
        String sql = "INSERT INTO aluno(nome, data_nascimento, sexo, cpf, email, tipo_sanguineo, rh_sangue,"
                + "telefone, celular, rua, bairro, cidade) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";

        try {
            try (PreparedStatement stmt = openCon.prepareStatement(sql)) {
                stmt.setString(1, aluno.getNome());
                stmt.setString(2, dataBanco);
                stmt.setString(3, sexo);
                stmt.setString(4, aluno.getCpf());
                stmt.setString(5, aluno.getEmail());
                stmt.setString(6, aluno.getTipoSanguineo().toString().toLowerCase());
                stmt.setString(7, aluno.getRhSangue().toString().toLowerCase());
                stmt.setString(8, aluno.getTelefone());
                stmt.setString(9, aluno.getCelular());
                stmt.setString(10, aluno.getRua());
                stmt.setString(11, aluno.getBairro());
                stmt.setString(12, aluno.getCidade());
                
                stmt.execute();
                stmt.close();
            }
            openCon.close();
            return true;            
        }
        catch (SQLException ex) {
            Logger.getLogger(RegistraAlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    } 
    
    //Método que retorna uma lista de alunos
    public List<RegistroAlunos> getList() {
        List<RegistroAlunos> regAlunoList = new ArrayList<>();
        String sql = "SELECT * FROM Estoque ORDER BY nomeItem";
        try {
            PreparedStatement stmt = openCon.prepareStatement(sql);
            ResultSet ResSet = stmt.executeQuery();
            while (ResSet.next()) {
                RegistroAlunos regAluno = new RegistroAlunos();

                regAluno.setNome(ResSet.getString("nome"));
                regAluno.setDataNascimento(ResSet.getDate("data_nascimento"));
                //regAluno.setSexo(ResSet.getObject("sexo"));
                //regAluno.setQtdItem(ResSet.getDouble("quantItem"));

                regAlunoList.add(regAluno);
            }
            stmt.close();
            ResSet.close();
            openCon.close();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Erro! Lista não retornada");
            return null;
        }
        return regAlunoList;
    }
}
