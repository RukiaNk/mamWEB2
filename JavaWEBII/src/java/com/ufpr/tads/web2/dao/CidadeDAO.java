/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Cidade;
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
public class CidadeDAO {

    private final String SELECT_ALL = "SELECT * FROM tb_cidade;";
    private final String SELECT_ALL_BY_STATE = "SELECT * FROM tb_cidade WHERE id_estado = ?;";
    private final String SELECT = "SELECT * FROM tb_cidade WHERE id_cidade = ?;";

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<Cidade> listarCidades() throws SQLException {

        List<Cidade> lista = new ArrayList<Cidade>();

        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cidade aux = new Cidade();
                aux.setIdCidade(rs.getInt(1));
                aux.setNomeCidade(rs.getString(2));
                aux.setIdEstado(rs.getInt(3));
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

    public Cidade buscaCidade(int id) {
        Cidade aux = new Cidade();
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(SELECT);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                aux.setIdCidade(rs.getInt(1));
                aux.setNomeCidade(rs.getString(2));
                aux.setIdEstado(rs.getInt(3));
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

    public List<Cidade> listarPorEstado(int estado) throws SQLException {
        List<Cidade> lista = new ArrayList<Cidade>();

        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(SELECT_ALL_BY_STATE);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cidade aux = new Cidade();
                aux.setIdCidade(rs.getInt(1));
                aux.setNomeCidade(rs.getString(2));
                aux.setIdEstado(rs.getInt(3));
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

}
