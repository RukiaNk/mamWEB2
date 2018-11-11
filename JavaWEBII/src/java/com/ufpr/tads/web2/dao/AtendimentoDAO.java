/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Atendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class AtendimentoDAO {

    private final String SELECT_ALL = "SELECT * FROM tb_atendimento WHERE id_usuario = ?;";
    private final String SELECT = "SELECT * FROM tb_atendimento WHERE id_atendimento = ?;";
    private final String INSERT = "INSERT INTO tb_atendimento (dt_hr_atendimento, dsc_atendimento, id_produto, "
            + "id_tipo_atendimento, id_usuario, id_cliente, res_atendimento) VALUES (?,?,?,?,?,?,?);";

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public List<Atendimento> listarAtendimentos(int id) throws SQLException {

        List<Atendimento> lista = new ArrayList<Atendimento>();

        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(SELECT_ALL);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Atendimento aux = new Atendimento();
                aux.setIdAtendimento(rs.getInt(1));
                aux.setDatahora(rs.getTimestamp(2).toLocalDateTime());
                aux.setDescricao(rs.getString(3));
                aux.setIdProd(rs.getInt(4));
                aux.setIdTipoAtendimento(rs.getInt(5));
                aux.setIdUsuario(rs.getInt(6));
                aux.setIdCliente(rs.getInt(7));
                aux.setIsSolved(rs.getString(8));
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

    public Atendimento buscaAtendimento(int id) {
        Atendimento aux = new Atendimento();
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(SELECT);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                aux.setIdAtendimento(rs.getInt(1));
                aux.setDatahora(rs.getTimestamp(2).toLocalDateTime());
                aux.setDescricao(rs.getString(3));
                aux.setIdProd(rs.getInt(4));
                aux.setIdTipoAtendimento(rs.getInt(5));
                aux.setIdUsuario(rs.getInt(6));
                aux.setIdCliente(rs.getInt(7));
                aux.setIsSolved(rs.getString(8));
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

    public void adicionarAtendimento(Atendimento a) {
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(INSERT);
            stmt.setInt(1, a.getIdAtendimento());
            stmt.setTimestamp(2, Timestamp.valueOf(a.getDatahora()));
            stmt.setString(3, a.getDescricao());
            stmt.setInt(4, a.getIdProd());
            stmt.setInt(5, a.getIdTipoAtendimento());
            stmt.setInt(6, a.getIdUsuario());
            stmt.setInt(7, a.getIdCliente());
            stmt.setString(8, a.getIsSolved());
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                con.close();
            } catch (Exception e) {
            }
        }
    }
}
