/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import java.sql.SQLException;
import java.util.List;

import com.ufpr.tads.web2.beans.TipoAtendimento;
import com.ufpr.tads.web2.dao.TipoAtendimentoDAO;

/**
 *
 * @author ananicole
 */
public class TipoAtendimentoFacade {
    public static List<TipoAtendimento> searchAll() {
		TipoAtendimentoDAO dao = new TipoAtendimentoDAO();
		try {
			return dao.listarTipoAtend();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static TipoAtendimento search(int idAtendimento) {
		try {
			return new TipoAtendimentoDAO().buscaTipoAtend((idAtendimento));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
