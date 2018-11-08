/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Estado;
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
public class EstadoDAO {

    private final String SELECT_ALL = "SELECT * FROM tb_estado;";
    private final String SELECT = "SELECT * FROM tb_estado WHERE id_estado = ?;";

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<Estado> listarEstados() throws SQLException {

        List<Estado> lista = new ArrayList<Estado>();

        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Estado aux = new Estado();
                aux.setIdEstado(rs.getInt(1));
                aux.setNomeEstado(rs.getString(2));
                aux.setSiglaEstado(rs.getString(3));
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

    public Estado buscaEstado(int id) {
        Estado aux = new Estado();
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(SELECT);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                aux.setIdEstado(rs.getInt(1));
                aux.setNomeEstado(rs.getString(2));
                aux.setSiglaEstado(rs.getString(3));
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
