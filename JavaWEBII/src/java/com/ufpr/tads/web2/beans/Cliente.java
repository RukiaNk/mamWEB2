/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ananicole
 */
public class Cliente implements Serializable {

    private int idCliente;
    private String cpfCliente;
    private String nomeCliente;
    private String emailCliente;
    private LocalDate dataCliente;
    private String ruaCliente;
    private int nrCliente;
    private String cepCliente;
    private int idCidade;
    private String Cidade;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//private DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getDataCliente() {
        //Formatando data do bean
        String data = dtf.format(this.dataCliente);
        return data;
    }

    public void setDataCliente(String dataCliente) {
        LocalDate d = LocalDate.parse(dataCliente, dtf);
        this.dataCliente = d;
    }

    public void setDataCliente(java.sql.Date dataCliente) {
        LocalDate d = dataCliente.toLocalDate();
        this.dataCliente = d;
    }

    public String getRuaCliente() {
        return ruaCliente;
    }

    public void setRuaCliente(String ruaCliente) {
        this.ruaCliente = ruaCliente;
    }

    public int getNrCliente() {
        return nrCliente;
    }

    public void setNrCliente(int nrCliente) {
        this.nrCliente = nrCliente;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public void setCidadeCliente(String Cidade) {
        this.Cidade = Cidade;
    }

}
