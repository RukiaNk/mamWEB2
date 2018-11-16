/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.dao.AtendimentoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ufpr.tads.web2.beans.Atendimento;
import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.beans.Produto;
import com.ufpr.tads.web2.beans.TipoAtendimento;
import com.ufpr.tads.web2.dao.ProdutoDAO;
import com.ufpr.tads.web2.dao.TipoAtendimentoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcos
 */
public class AtendimentoFacade {

    public static ArrayList<List<?>> form() {
        ArrayList<List<?>> form = new ArrayList<List<?>>();
        try {
            //Busca clientes
            List<Cliente> clientes = ClienteFacade.selectAll();
            form.add(clientes);
            //Busca produtos
            List<Produto> produtos = ProdutoFacade.searchAll();
            List<TipoAtendimento> tiposAtendimento = TipoAtendimentoFacade.searchAll();
            form.add(tiposAtendimento);
            form.add(produtos);
            //Busca tipos de atendimentos
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return form;
    }

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

    public static Atendimento search(int id) {
        return new AtendimentoDAO().buscaAtendimento(id);
    }

    public static TipoAtendimento selectTipo(int id) {
        //Busca id do produto a ser visualizado no parametro da página
        TipoAtendimentoDAO dao = new TipoAtendimentoDAO();
        TipoAtendimento c = dao.buscaTipoAtend(id);
        return c;
    }

    public static List<Atendimento> searchAll(int id) {
        AtendimentoDAO dao = new AtendimentoDAO();
        List<Atendimento> lAtend = new ArrayList<>();
        try {
            lAtend = dao.listarAtendimentos(id);
        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lAtend;
    }
}
