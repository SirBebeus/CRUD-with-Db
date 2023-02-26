/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ingredientes_receita;


/**
 *
 * @author Matheus
 */
public class Ingredientes_receitaDAO {
     private final Connection connection;

    //so vou conseguir acessar categoriaDAO se tiver conectado no banco
    public Ingredientes_receitaDAO(Connection connection) {
        this.connection = connection;
    }
    public void insert (ingredientes_receita ingre) throws SQLException{
        String sql;
        sql = "insert into ingredientes_receita values ('"+ingre.getCod_ereceita()+"','"+ingre.getNome_fantasia_co()+"','"+ingre.getCoid_ngredientee()+"', '"+ingre.getQuant_ingredientee()+"', '"+ingre.getNome_ingrediente()+"')";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
    public void update (ingredientes_receita ingre) throws SQLException{
        String sql;
        sql = "update ingredientes_receita set quant_ingrediente = '"+ingre.getQuant_ingredientee()+"' WHERE coid_ngredientee = '"+ingre.getCoid_ngredientee()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();   
    }
    
    public ArrayList<ingredientes_receita> selectALL(String desc) throws SQLException {
        String sql;
        sql = "select irr.cod_ereceita,czs.nome_cozinheiro, irr.coid_ngredientee, irr.nome_ingrediente, irr.quant_ingrediente from ingredientes_receita irr inner join cozinheiros czs ON irr.nome_fantasia_co = czs.nome_fantasia  where cod_ereceita = '"+desc+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        ArrayList<ingredientes_receita> ingre = new ArrayList<>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            int cod_receita = resultSet.getInt("cod_ereceita");
            int qtd = resultSet.getInt("quant_ingrediente");
            int cod_ingrediente = resultSet.getInt("coid_ngredientee");
            String nome_ingrediente = resultSet.getString("nome_ingrediente");
            String nome_cozinheiro = resultSet.getString("nome_cozinheiro");
            ingredientes_receita ingrecomDados = new ingredientes_receita(cod_receita,nome_cozinheiro,nome_ingrediente,cod_ingrediente,qtd);
            ingre.add(ingrecomDados);
        }
        return ingre;
    }
    
     public void delete(ingredientes_receita ingre) throws SQLException{
        String sql;
        sql = "delete from ingredientes_receita where cod_ereceita = '"+ingre.getCod_ereceita()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
}
