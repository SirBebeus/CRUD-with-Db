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
import model.restaurantes;

/**
 *
 * @author Matheus
 */
public class RestaurantesDAO {
    private final Connection connection;

    public RestaurantesDAO(Connection connection) {
        this.connection = connection;
    }
    public void insert (restaurantes restaurantes) throws SQLException{
        String sql;
        sql = "insert into restaurantes values ('"+restaurantes.getNome_restaurante()+"', '"+restaurantes.getDt_criacao()+"')";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
    
    public void update (restaurantes restaurantes) throws SQLException{
        if(validar(restaurantes)){
            String sql;
            sql = "update restaurantes set dt_criacao = '"+restaurantes.getDt_criacao()+"' where nome_restaurante = '"+restaurantes.getNome_restaurante()+"'";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
        }else{
            insert(restaurantes);
        }
    }
    
 
    
    public void delete(restaurantes restaurantes) throws SQLException{
        String sql;
        sql = "delete from restaurantes where nome_restaurante = '"+restaurantes.getNome_restaurante()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
    
    public ArrayList<restaurantes> selectALL() throws SQLException {
        String sql;
        sql = "select * from restaurantes";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);
    }
    
    public ArrayList<restaurantes> readDesc(String descricao) throws SQLException {
        String sql;
        sql = "select * from restaurantes WHERE nome_restaurante LIKE '%"+descricao+"%'";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);
    }
    

    private ArrayList<restaurantes> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<restaurantes> restaurantes = new ArrayList<>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            String nome = resultSet.getString("nome_restaurante");
            String criacao = resultSet.getString("dt_criacao");
            restaurantes restaurantescomDados = new restaurantes(nome, criacao);
            restaurantes.add(restaurantescomDados);
        }
        
        return restaurantes;
    }

    public boolean validar(restaurantes restaurantes) throws SQLException {
        String sql = "select * from restaurantes where nome_restaurante = '"+restaurantes.getNome_restaurante()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        //pegar o resultado do select
        ResultSet resultSet = statement.getResultSet();
        //se existe é verdadeiro
        return resultSet.next();   
    }
}
