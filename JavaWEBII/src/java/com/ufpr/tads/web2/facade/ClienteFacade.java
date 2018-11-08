/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.Cidade;
import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.beans.Estado;
import com.ufpr.tads.web2.dao.CidadeDAO;
import com.ufpr.tads.web2.dao.ClienteDAO;
import com.ufpr.tads.web2.dao.EstadoDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ananicole
 */
public class ClienteFacade implements Serializable {

    public static List<Cliente> selectAll() throws InstantiationException, IllegalAccessException {
        //Busca lista de clientes no banco de dados e retorna um List<Cliente>
        ClienteDAO dao = new ClienteDAO();
        List<Cliente> lista = new ArrayList<Cliente>();
        try {
            lista = dao.listarClientes();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClienteFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public static Cliente select(int id) {
        //Busca id do cliente a ser visualizado no parametro da página
        ClienteDAO dao = new ClienteDAO();
        Cliente c = dao.buscarCliente(id);
        return c;
    }

    public static void insert(Cliente c) throws InstantiationException, IllegalAccessException {
        ClienteDAO dao = new ClienteDAO();
        dao.adicionarCliente(c);
    }

    public static void update(Cliente c) {
        ClienteDAO dao = new ClienteDAO();
        dao.alterarCliente(c);
    }

    public static void delete(int id) throws InstantiationException, IllegalAccessException {
        try {
            //Busca cliente no banco de dados e deleta do banco de dados
            ClienteDAO dao = new ClienteDAO();
            dao.deletarCliente(id);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Estado> listarEstados() throws SQLException {
        EstadoDAO eDao = new EstadoDAO();
        return eDao.listarEstados();
    }

    public static Cidade buscarCidade(int id) throws SQLException {
        CidadeDAO cDao = new CidadeDAO();
        return cDao.buscaCidade(id);
    }
}
