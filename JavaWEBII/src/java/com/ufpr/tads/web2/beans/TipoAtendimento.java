/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

/**
 *
 * @author Marcos
 */
public class TipoAtendimento {

    private int idTipo;
    private String tipoAtend;

    public TipoAtendimento() {
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipoAtend() {
        return tipoAtend;
    }

    public void setTipoAtend(String tipoAtend) {
        this.tipoAtend = tipoAtend;
    }

}
