/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Matheus
 */
public class cozinheiro {
    private String nome_cozinheiro;
    private String nome_fantasia;
    private String dt_contrato;

    public cozinheiro(String nome_cozinheiro, String nome_fantasia, String dt_contrato) {
        this.nome_cozinheiro = nome_cozinheiro;
        this.nome_fantasia = nome_fantasia;
        this.dt_contrato = dt_contrato;
    }

    public cozinheiro() {
    }

    public String getNome_cozinheiro() {
        return nome_cozinheiro;
    }

    public void setNome_cozinheiro(String nome_cozinheiro) {
        this.nome_cozinheiro = nome_cozinheiro;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getDt_contrato() {
        return dt_contrato;
    }

    public void setDt_contrato(String dt_contrato) {
        this.dt_contrato = dt_contrato;
    }
}
