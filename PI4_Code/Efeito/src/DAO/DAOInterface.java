/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author deive
 */
public interface DAOInterface {

	public void inserir(Object obj);
        public void alterar(Object obj);
	public void atualizar(Object obj);
	public void deletar(Object obj);
	public Object getById(int id);
	public List<Object> getAll();

}
