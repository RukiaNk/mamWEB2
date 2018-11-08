package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ananicole
 */
public class ClienteDAO {

    private final String SELECT_ALL = "SELECT * FROM tb_cliente;";
    private final String SELECT = "SELECT * FROM tb_cliente WHERE id_cliente = ?;";

    private final String INSERT = "INSERT INTO tb_cliente(cpf_cliente, nome_cliente, email_cliente, "
            + "data_cliente, rua_cliente, nr_cliente, cep_cliente, cidade_cliente) values (?,?,?,?,?,?,?,?);";
    private final String UPDATE = "UPDATE tb_cliente SET cpf_cliente = ?, nome_cliente = ?, email_cliente = ?, "
            + "data_cliente = ?, rua_cliente = ?, nr_cliente = ?, cep_cliente = ?, cidade_cliente = ? WHERE id_cliente = ?;";
    private final String DELETE = "DELETE FROM tb_cliente WHERE id_cliente=?;";

    private final String VERIFY_CPF = "SELECT cpf_cliente FROM tb_cliente WHERE cpf_cliente = ?;";
    private final String VERIFY_EMAIL = "SELECT email_cliente FROM tb_cliente WHERE email_cliente = ?;";
    private final SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public ClienteDAO() {
    }

    public List<Cliente> listarClientes() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {

        List<Cliente> lista = new ArrayList<Cliente>();

        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(SELECT_ALL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente aux = new Cliente();
                aux.setIdCliente(rs.getInt(1));
                aux.setCpfCliente(rs.getString(2));
                aux.setNomeCliente(rs.getString(3));
                aux.setEmailCliente(rs.getString(4));
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

    public Cliente buscarCliente(int id) {
        Cliente aux = new Cliente();
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(SELECT);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                aux.setIdCliente(rs.getInt(1));
                aux.setCpfCliente(rs.getString(2));
                aux.setNomeCliente(rs.getString(3));
                aux.setEmailCliente(rs.getString(4));
                aux.setDataCliente(rs.getDate(5));
                aux.setRuaCliente(rs.getString(6));
                aux.setNrCliente(rs.getInt(7));
                aux.setCepCliente(rs.getString(8));
                aux.setIdCidade(rs.getInt(9));
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

    public void adicionarCliente(Cliente cliente) {
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(INSERT);
            stmt.setString(1, cliente.getCpfCliente());
            stmt.setString(2, cliente.getNomeCliente());
            stmt.setString(3, cliente.getEmailCliente());
            java.sql.Date data = new java.sql.Date(fmt.parse(cliente.getDataCliente()).getTime());
            stmt.setDate(4, data);
            stmt.setString(5, cliente.getRuaCliente());
            stmt.setInt(6, cliente.getNrCliente());
            stmt.setString(7, cliente.getCepCliente());
            stmt.setInt(8, cliente.getIdCidade());
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

    public void alterarCliente(Cliente cliente) {
        try {
            con = new ConnectionFactory().getConnection();
            stmt = con.prepareStatement(UPDATE);
            stmt.setString(1, cliente.getCpfCliente());
            stmt.setString(2, cliente.getNomeCliente());
            stmt.setString(3, cliente.getEmailCliente());
            java.sql.Date data = new java.sql.Date(fmt.parse(cliente.getDataCliente()).getTime());
            stmt.setDate(4, data);
            stmt.setString(5, cliente.getRuaCliente());
            stmt.setInt(6, cliente.getNrCliente());
            stmt.setString(7, cliente.getCepCliente());
            stmt.setInt(8, cliente.getIdCidade());
            stmt.setInt(9, cliente.getIdCliente());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }

    public void deletarCliente(int idCliente) throws SQLException, InstantiationException, IllegalAccessException {
        con = new ConnectionFactory().getConnection();
        stmt = con.prepareStatement(DELETE);
        try {
            stmt.setInt(1, idCliente);
            stmt.executeUpdate();
        } finally {
            stmt.close();
        }
    }

}
