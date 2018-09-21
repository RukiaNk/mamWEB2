package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectDao {

    public static List<Usuario> getUsuarios() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        String sql = ("SELECT * FROM usuario");

        try {
            conn = new ConnectionFactory().getConnection();
            stmt = conn.prepareStatement(sql);
            ResultSet stmtResult = stmt.executeQuery();
            List<Usuario> lista = new ArrayList();
            while (stmtResult.next()) {
                String nome = stmtResult.getString("nome");
                String login = stmtResult.getString("login");
                String senha = stmtResult.getString("senha");
                Usuario u = new Usuario(nome, login, senha);
                lista.add(u);
            }
            return lista;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            stmt.close();
            conn.close();
        }
    }

    public void insere(Usuario newUser) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        String sql = "INSERT INTO usuario (login, senha, nome) VALUES (?,?,?)";
        try {
            conn = new ConnectionFactory().getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, newUser.getLogin());
            stmt.setString(2, newUser.getSenha());
            stmt.setString(3, newUser.getNome());
            stmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            stmt.close();
            conn.close();
        }
    }

    public boolean validaLogin(String login, String senha) throws SQLException {
        boolean isOk = false;
        List<Usuario> users = getUsuarios();
        for (Usuario u : users) {
            if (login.equals(u.getLogin()) && senha.equals(u.getSenha())) {
                isOk = true;
                break;
            }
        }
        return isOk;
    }
}
