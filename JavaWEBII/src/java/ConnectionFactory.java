/**
 *
 * @author Marcos
 */
import java.sql.*;
import javax.swing.*;

public class ConnectionFactory {

    //Preparando as variáveis de conexão
    final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://localhost/bd_web2";
    final private String usuario = "root";
    final private String senha = "";
    private Connection conexao;
    public Statement statement;
    public ResultSet resultset;

    //Para abrir conexão com o SGBD
    public boolean conectar() {
        boolean result = true;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            //System.out.println("Conexao com o SGBD criada com sucesso");
        } catch (ClassNotFoundException d) {
            //JOptionPane.showMessageDialog(null, "Driver não localizado: " + d);
            result = false;
        } catch (SQLException f) {
            //JOptionPane.showMessageDialog(null, "Erro na conexao com o SGBD: " + f);
            result = false;
        }
        return result;
    }

    //fecha/encerra a conexão com o SGBD
    public boolean desconecta() {
        boolean result = true;
        try {
            conexao.close();
            //System.out.println("Conexao SGBD encerrada");
        } catch (SQLException f) {
            //System.out.println("Não foi possível encerrar a conexão com o SGBD: " + f);
            result = false;
        }
    return result;
    }
    
    //para executar os selects
    public void selecionar(String sql) {
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        }catch (SQLException sqlex) {
            //JOptionPane.showMessageDialog(null, "Não foi possivel executar o comando sql de consulta informado: "+sqlex);
        }
    }
    
    //para insert, delete e update
    public void atualizar(String sql) {
        try {
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println("Não foi possivel executar o comando sql de atualização informado: " + ex);
        }
    }
}
