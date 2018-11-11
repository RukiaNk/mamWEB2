/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class ProdutoDAO {

    private final String SELECT_ALL = "SELECT * FROM tb_produto;";
    private final String SELECT = "SELECT * FROM tb_produto WHERE id_produto = ?;";

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<Produto> listarProdutos() throws SQLException {

        List<Produto> lista = new ArrayList<Produto>();

        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto aux = new Produto();
                aux.setIdProd(rs.getInt(1));
                aux.setNomeProd(rs.getString(2));
                lista.add(aux);
            }
            rs.close();
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            con.close();
        }
    }

    public Produto buscaProduto(int id) {
        Produto aux = new Produto();
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(SELECT);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                aux.setIdProd(rs.getInt(1));
                aux.setNomeProd(rs.getString(2));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
        return aux;
    }
}
