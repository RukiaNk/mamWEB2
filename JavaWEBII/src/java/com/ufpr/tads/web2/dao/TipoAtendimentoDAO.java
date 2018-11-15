/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.TipoAtendimento;
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
public class TipoAtendimentoDAO {

    private final String SELECT_ALL = "SELECT * FROM tb_tipo_atendimento;";
    private final String SELECT = "SELECT * FROM tb_tipo_atendimento WHERE id_tipo_atendimento = ?;";

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<TipoAtendimento> listarTipoAtend() throws SQLException {

        List<TipoAtendimento> lista = new ArrayList<TipoAtendimento>();

        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                TipoAtendimento aux = new TipoAtendimento();
                aux.setIdTipo(rs.getInt(1));
                aux.setTipoAtend(rs.getString(2));
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

    public TipoAtendimento buscaTipoAtend(int idAtendimento) {
        TipoAtendimento aux = new TipoAtendimento();
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(SELECT);
            stmt.setInt(1, idAtendimento);
            rs = stmt.executeQuery();
            if (rs.next()) {
                aux.setIdTipo(rs.getInt(1));
                aux.setTipoAtend(rs.getString(2));
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
