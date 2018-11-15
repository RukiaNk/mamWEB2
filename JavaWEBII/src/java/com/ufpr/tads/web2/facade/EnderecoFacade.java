/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import java.sql.SQLException;
import java.util.List;

import com.ufpr.tads.web2.beans.Cidade;
import com.ufpr.tads.web2.beans.Estado;
import com.ufpr.tads.web2.dao.CidadeDAO;
import com.ufpr.tads.web2.dao.EstadoDAO;

public class EnderecoFacade {
    public static List<Estado> listarEstados() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
        EstadoDAO dao = new EstadoDAO();
        List<Estado> estados = dao.listarEstados();
        return estados;
    }

    public static List<Cidade> listarCidades(int idEstado) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
    	CidadeDAO dao = new CidadeDAO();
		List<Cidade> cidades = dao.listarCidades();
		return cidades;
    }
    
    public static Estado buscarEstado(int idEstado) throws InstantiationException, IllegalAccessException, SQLException {
    	EstadoDAO dao = new EstadoDAO();
    	Estado estado = dao.buscaEstado(idEstado);
    	return estado;
    }
    
    public static Cidade buscarCidade(int idCidade) throws InstantiationException, IllegalAccessException, SQLException {
    	CidadeDAO dao = new CidadeDAO();
    	Cidade cidade = dao.buscaCidade(idCidade);
    	return cidade;
    }
}

