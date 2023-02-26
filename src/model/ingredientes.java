/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Matheus
 */
public class ingredientes {
    private int cod_ingrediente;

    public int getCod_ingrediente() {
        return cod_ingrediente;
    }

    public void setCod_ingrediente(int cod_ingrediente) {
        this.cod_ingrediente = cod_ingrediente;
    }

    public String getNome_ingrediente() {
        return nome_ingrediente;
    }

    public void setNome_ingrediente(String nome_ingrediente) {
        this.nome_ingrediente = nome_ingrediente;
    }

    public ingredientes(int cod_ingrediente, String nome_ingrediente) {
        this.cod_ingrediente = cod_ingrediente;
        this.nome_ingrediente = nome_ingrediente;
    }

    public ingredientes() {
    }
    private String nome_ingrediente;
}
