/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Matheus
 */
public class degustadores {
    private String nome_degust;
    private String dt_contrato;

    public degustadores(String nome_degust, String dt_contrato) {
        this.nome_degust = nome_degust;
        this.dt_contrato = dt_contrato;
    }

    public degustadores() {
    }

    public String getNome_degust() {
        return nome_degust;
    }

    public void setNome_degust(String nome_degust) {
        this.nome_degust = nome_degust;
    }

    public String getDt_contrato() {
        return dt_contrato;
    }

    public void setDt_contrato(String dt_contrato) {
        this.dt_contrato = dt_contrato;
    }
}
