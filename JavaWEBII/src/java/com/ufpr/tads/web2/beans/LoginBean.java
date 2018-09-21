/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.io.Serializable;

/**
 *
 * @author ananicole
 */
public class LoginBean implements Serializable {
    private String id;
    private String nome;

    public LoginBean() { //Construtor em Bean não tem parâmetros
    }

    public LoginBean(int id, String toUpperCase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
}
