/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.Atendimento;
import com.ufpr.tads.web2.beans.Produto;
import com.ufpr.tads.web2.beans.TipoAtendimento;
import com.ufpr.tads.web2.dao.AtendimentoDAO;
import com.ufpr.tads.web2.dao.ProdutoDAO;
import com.ufpr.tads.web2.dao.TipoAtendimentoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class AtendimentoFacade {

    public static List<Atendimento> selectAllAtend(int id) throws InstantiationException, IllegalAccessException {
        //Busca lista de Atendimentos no banco de dados e retorna um List<Atendimento>
        AtendimentoDAO dao = new AtendimentoDAO();
        List<Atendimento> lista = new ArrayList<Atendimento>();
        try {
            lista = dao.listarAtendimentos(id);
        } catch (SQLException ex) {
            System.out.println("Falha de comunicação com o banco: " + ex);
        }
        return lista;
    }

    public static Atendimento selectAtend(int id) {
        //Busca id do Atendimento a ser visualizado no parametro da página
        AtendimentoDAO dao = new AtendimentoDAO();
        Atendimento c = dao.buscaAtendimento(id);
        return c;
    }

    public static void insert(Atendimento c) throws InstantiationException, IllegalAccessException {
        AtendimentoDAO dao = new AtendimentoDAO();
        dao.adicionarAtendimento(c);
    }

    public static List<Produto> selectAllProd() throws InstantiationException, IllegalAccessException {
        //Busca lista de produttos no banco de dados e retorna um List<Produto>
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> lista = new ArrayList<Produto>();
        try {
            lista = dao.listarProdutos();
        } catch (SQLException ex) {
            System.out.println("Falha de comunicação com o banco: " + ex);
        }
        return lista;
    }

    public static Produto selectProd(int id) {
        //Busca id do produto a ser visualizado no parametro da página
        ProdutoDAO dao = new ProdutoDAO();
        Produto c = dao.buscaProduto(id);
        return c;
    }
    
    public static List<TipoAtendimento> selectAllTipo() throws InstantiationException, IllegalAccessException {
        //Busca lista de produttos no banco de dados e retorna um List<Produto>
        TipoAtendimentoDAO dao = new TipoAtendimentoDAO();
        List<TipoAtendimento> lista = new ArrayList<TipoAtendimento>();
        try {
            lista = dao.listarTipoAtend();
        } catch (SQLException ex) {
            System.out.println("Falha de comunicação com o banco: " + ex);
        }
        return lista;
    }
    
    public static TipoAtendimento selectTipo(int id) {
        //Busca id do produto a ser visualizado no parametro da página
        TipoAtendimentoDAO dao = new TipoAtendimentoDAO();
        TipoAtendimento c = dao.buscaTipoAtend(id);
        return c;
    }

}
