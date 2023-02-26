/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Matheus
 */
public class ingredientes_receita {
    private int cod_ereceita;
    private String nome_fantasia_co;
    private String nome_ingrediente;
    private int coid_ngredientee;
    private int quant_ingredientee;

    public ingredientes_receita(int cod_ereceita, String nome_fantasia_co, String nome_ingrediente, int coid_ngredientee, int quant_ingredientee) {
        this.cod_ereceita = cod_ereceita;
        this.nome_fantasia_co = nome_fantasia_co;
        this.nome_ingrediente = nome_ingrediente;
        this.coid_ngredientee = coid_ngredientee;
        this.quant_ingredientee = quant_ingredientee;
    }

    public int getCod_ereceita() {
        return cod_ereceita;
    }

    public void setCod_ereceita(int cod_ereceita) {
        this.cod_ereceita = cod_ereceita;
    }

    public String getNome_fantasia_co() {
        return nome_fantasia_co;
    }

    public void setNome_fantasia_co(String nome_fantasia_co) {
        this.nome_fantasia_co = nome_fantasia_co;
    }

    public String getNome_ingrediente() {
        return nome_ingrediente;
    }

    public void setNome_ingrediente(String nome_ingrediente) {
        this.nome_ingrediente = nome_ingrediente;
    }

    public int getCoid_ngredientee() {
        return coid_ngredientee;
    }

    public void setCoid_ngredientee(int coid_ngredientee) {
        this.coid_ngredientee = coid_ngredientee;
    }

    public int getQuant_ingredientee() {
        return quant_ingredientee;
    }

    public void setQuant_ingredientee(int quant_ingredientee) {
        this.quant_ingredientee = quant_ingredientee;
    }

  
}
