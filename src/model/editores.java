/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Matheus
 */
public class editores {
    private String nome_editor;
    private String dt_contrato;

    public String getNome_editor() {
        return nome_editor;
    }

    public void setNome_editor(String nome_editor) {
        this.nome_editor = nome_editor;
    }

    public String getDt_contrato() {
        return dt_contrato;
    }

    public void setDt_contrato(String dt_contrato) {
        this.dt_contrato = dt_contrato;
    }

    public editores() {
    }

    public editores(String nome_editor, String dt_contrato) {
        this.nome_editor = nome_editor;
        this.dt_contrato = dt_contrato;
    }
    
}
