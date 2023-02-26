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
import model.cozinheiro;

/**
 *
 * @author Matheus
 */
public class CozinheiroDAO {
     private final Connection connection;

    public CozinheiroDAO(Connection connection) {
        this.connection = connection;
    }
     public void insert (cozinheiro cozinheiro) throws SQLException{
        String sql;
        sql = "insert into cozinheiros values ('"+cozinheiro.getNome_cozinheiro()+"','"+cozinheiro.getNome_fantasia()+"','"+cozinheiro.getDt_contrato()+"')";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
     
    public void update (cozinheiro cozinheiro) throws SQLException{
        if(validar(cozinheiro)){
            String sql;
            sql = "update cozinheiros set nome_cozinheiro = '"+cozinheiro.getNome_cozinheiro()+"', dt_contrato = '"+cozinheiro.getDt_contrato()+"' WHERE nome_fantasia = '"+cozinheiro.getNome_fantasia()+"'";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();   
        }
        else{
            insert(cozinheiro);
        }
     
    }
    
     public void delete(cozinheiro cozinheiro) throws SQLException{
        String sql;
        sql = "delete from cozinheiros where nome_fantasia = '"+cozinheiro.getNome_fantasia()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
     
     public ArrayList<cozinheiro> selectALL() throws SQLException {
        String sql;
        sql = "select * from cozinheiros";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);
    }
    
    public ArrayList<cozinheiro> readDesc(String descricao) throws SQLException {
        String sql;
        sql = "select * from cozinheiros WHERE nome_fantasia LIKE '%"+descricao+"%'";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);
    }

    private ArrayList<cozinheiro> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<cozinheiro> cozinheiros = new ArrayList<>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            String nome_cozinheiro;
            String nome_fantasia;
            String dt_contrato = resultSet.getString("dt_contrato");
            nome_cozinheiro = resultSet.getString("nome_cozinheiro");
            nome_fantasia = resultSet.getString("nome_fantasia");
            cozinheiro cozinheirocomDados = new cozinheiro(nome_cozinheiro, nome_fantasia, dt_contrato);
            cozinheiros.add(cozinheirocomDados);
        }
        
        return cozinheiros;
    }

    public boolean validar(cozinheiro cozinheiro) throws SQLException {
        String sql = "select * from cozinheiros where nome_fantasia = '"+cozinheiro.getNome_fantasia()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        //pegar o resultado do select
        ResultSet resultSet = statement.getResultSet();
        //se existe é verdadeiro
        return resultSet.next();   
    }

    
}
