/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.ConnectionFactoryMysqlSingleton;
import Model.RegistroAlunos;
import Model.SexoEnum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * @author carolina
 * @author deive
 */
public class EquipamentosDAO {
    private final Connection openCon;

    ConnectionFactoryMysqlSingleton conecta = ConnectionFactoryMysqlSingleton.getConnectionSingleton();

    public EquipamentosDAO() {
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
            Logger.getLogger(EquipamentosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void alterar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void atualizar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deletar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
