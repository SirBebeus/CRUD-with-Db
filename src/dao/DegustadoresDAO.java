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
import model.degustadores;

/**
 *
 * @author Matheus
 */
public class DegustadoresDAO {
     private final Connection connection;

    public DegustadoresDAO(Connection connection) {
        this.connection = connection;
    }
    public void insert (degustadores degustadores) throws SQLException{
        String sql;
        sql = "insert into degustadores values ('"+degustadores.getNome_degust()+"', '"+degustadores.getDt_contrato()+"')";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
    
    public void update (degustadores degustadores) throws SQLException{
        if(validar(degustadores)){
            String sql;
            sql = "update degustadores set dt_contrato = '"+degustadores.getDt_contrato()+"' where nome_degust = '"+degustadores.getNome_degust()+"'";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
        }else{
            insert(degustadores);
        }
    }
    
 
    
    public void delete(degustadores degustadores) throws SQLException{
        String sql;
        sql = "delete from degustadores where nome_degust = '"+degustadores.getNome_degust()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
    
    public ArrayList<degustadores> selectALL() throws SQLException {
        String sql;
        sql = "select * from degustadores";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);
    }
    
    public ArrayList<degustadores> readDesc(String descricao) throws SQLException {
        String sql;
        sql = "select * from degustadores WHERE nome_degust LIKE '%"+descricao+"%'";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);
    }

    private ArrayList<degustadores> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<degustadores> degustadores = new ArrayList<>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            String nome = resultSet.getString("nome_degust");
            String contrato = resultSet.getString("dt_contrato");
            degustadores degustadorescomDados = new degustadores(nome, contrato);
            degustadores.add(degustadorescomDados);
        }
        
        return degustadores;
    }

    public boolean validar(degustadores degustadores) throws SQLException {
        String sql = "select * from degustadores where nome_degust = '"+degustadores.getNome_degust()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        //pegar o resultado do select
        ResultSet resultSet = statement.getResultSet();
        //se existe é verdadeiro
        return resultSet.next();   
    }
}
