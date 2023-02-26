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
import model.editores;

/**
 *
 * @author Matheus
 */
public class EditoresDAO {
    private final Connection connection;

    public EditoresDAO(Connection connection) {
        this.connection = connection;
    }
    public void insert (editores editores) throws SQLException{
        String sql;
        sql = "insert into editores values ('"+editores.getNome_editor()+"','"+editores.getDt_contrato()+"')";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
     
    public void update (editores editores) throws SQLException{
        if(validar(editores)){
            String sql;
            sql = "update editores set dt_contrato = '"+editores.getDt_contrato()+"' WHERE nome_editor = '"+editores.getNome_editor()+"'";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();   
        }
        else{
            insert(editores);
        }
     
    }
    
     public void delete(editores editores) throws SQLException{
        String sql;
        sql = "delete from editores where nome_editor = '"+editores.getNome_editor()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
     
     public ArrayList<editores> selectALL() throws SQLException {
        String sql;
        sql = "select * from editores";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);
    }
    
    public ArrayList<editores> readDesc(String descricao) throws SQLException {
        String sql;
        sql = "select * from editores WHERE nome_editor LIKE '%"+descricao+"%'";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);
    }

    private ArrayList<editores> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<editores> editores = new ArrayList<>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            String nome_editor;
            String dt_contrato = resultSet.getString("dt_contrato");
            nome_editor = resultSet.getString("nome_editor");
            editores editorcomDados = new editores(nome_editor, dt_contrato);
            editores.add(editorcomDados);
        }
        
        return editores;
    }

    public boolean validar(editores editores) throws SQLException {
        String sql = "select * from editores where nome_editor = '"+editores.getNome_editor()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        //pegar o resultado do select
        ResultSet resultSet = statement.getResultSet();
        //se existe é verdadeiro
        return resultSet.next();   
    }
}
