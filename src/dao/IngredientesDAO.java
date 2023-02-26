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
import model.ingredientes;

/**
 *
 * @author Matheus
 */
public class IngredientesDAO {
    private final Connection connection;

    public IngredientesDAO(Connection connection) {
        this.connection = connection;
    }
    public void insert (ingredientes ingredientes) throws SQLException{
        String sql;
        sql = "insert into ingredientes values ('"+ingredientes.getCod_ingrediente()+"','"+ingredientes.getNome_ingrediente()+"')";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
     
    public void update (ingredientes ingredientes) throws SQLException{
        if(validar(ingredientes)){
            String sql;
            sql = "update ingredientes set nome_ingrediente = '"+ingredientes.getNome_ingrediente()+"' WHERE cod_ingrediente = '"+ingredientes.getCod_ingrediente()+"'";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();   
        }
        else{
            insert(ingredientes);
        }
     
    }
    
     public void delete(ingredientes ingredientes) throws SQLException{
        String sql;
        sql = "delete from ingredientes where cod_ingrediente = '"+ingredientes.getCod_ingrediente()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
     
     public ArrayList<ingredientes> selectALL() throws SQLException {
        String sql;
        sql = "select * from ingredientes";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);
    }
    
    public ArrayList<ingredientes> readDesc(String descricao) throws SQLException {
        String sql;
        sql = "select * from ingredientes WHERE nome_ingrediente LIKE '%"+descricao+"%'";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);
    }

    private ArrayList<ingredientes> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<ingredientes> ingredientes = new ArrayList<>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            int cod_ingrediente = resultSet.getInt("cod_ingrediente");
            String nome = resultSet.getString("nome_ingrediente");
            ingredientes ingredientescomDados = new ingredientes(cod_ingrediente, nome);
            ingredientes.add(ingredientescomDados);
        }
        
        return ingredientes;
    }

    public boolean validar(ingredientes ingredientes) throws SQLException {
        String sql = "select * from ingredientes where cod_ingrediente = '"+ingredientes.getCod_ingrediente()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        //pegar o resultado do select
        ResultSet resultSet = statement.getResultSet();
        //se existe é verdadeiro
        return resultSet.next();   
    }
}
