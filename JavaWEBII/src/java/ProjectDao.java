
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

    private static ConnectionFactory conexao = new ConnectionFactory();

    public static List<Usuario> getUsuarios() {
        try {
            conexao.conectar();
            conexao.selecionar("SELECT * FROM usuario");

            List<Usuario> lista = new ArrayList();
            while (conexao.resultset.next()) {
                String nome = conexao.resultset.getString("nome");
                String login = conexao.resultset.getString("login");
                String senha = conexao.resultset.getString("senha");
                Usuario u = new Usuario(nome, login, senha);
                lista.add(u);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insere(Usuario newUser) {
        conexao.conectar();
        String sql = "INSERT INTO usuario (login, senha, nome) "                
                + " VALUES ( '" + newUser.getLogin()+ "' , '" + newUser.getSenha()
                +"', '" + newUser.getNome()+"' )";
        conexao.atualizar(sql);
    }

    public static boolean validaLogin(String login, String senha) {
        boolean ok = false;
        List<Usuario> users = getUsuarios();        
        for(Usuario u : users) {
            if(login.equals(u.getLogin()) && senha.equals(u.getSenha())) {
                ok = true;
                System.out.println("DEU");
                break;
            }
        }
        return ok;
    }
}
