/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Matheus
 */
public class receitas {
    private int cod_receita;
    private String nome_receita;
    private String dt_criacao;
    private cozinheiro cozinheiro;
    private categoria categoria;

    public int getCod_receita() {
        return cod_receita;
    }

    public void setCod_receita(int cod_receita) {
        this.cod_receita = cod_receita;
    }

    public String getNome_receita() {
        return nome_receita;
    }

    public void setNome_receita(String nome_receita) {
        this.nome_receita = nome_receita;
    }

    public String getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(String dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    public cozinheiro getCozinheiro() {
        return cozinheiro;
    }

    public void setCozinheiro(cozinheiro cozinheiro) {
        this.cozinheiro = cozinheiro;
    }

    public categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(categoria categoria) {
        this.categoria = categoria;
    }

    public receitas(int cod_receita, String nome_receita, String dt_criacao, cozinheiro cozinheiro, categoria categoria) {
        this.cod_receita = cod_receita;
        this.nome_receita = nome_receita;
        this.dt_criacao = dt_criacao;
        this.cozinheiro = cozinheiro;
        this.categoria = categoria;
    }
    
}
