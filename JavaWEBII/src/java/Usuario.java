
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author michellynk
 */
public class Usuario {
    String nome, login, senha;

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    public String getNome() {
    return nome;
    }
 
    public String getLogin() {
    return login;
    }
 
    public String getSenha() {
    return senha;
    }
    
    public void setNome(String nomeUs){
    this.nome = nomeUs;
    }
    
    public void setLogin(String loginUs){
    this.login = loginUs;
    }
        
    public void setSenha(String senhaUs){
    this.senha = senhaUs;
    }
}
