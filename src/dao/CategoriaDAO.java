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
import model.categoria;


/**
 *
 * @author Matheus
 */
public class CategoriaDAO {
    private final Connection connection;

    //so vou conseguir acessar categoriaDAO se tiver conectado no banco
    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert (categoria categoria) throws SQLException{
        String sql;
        sql = "insert into categoria (cod_categoria,desc_categoria) values ('"+categoria.getCod_categoria()+"', '"+categoria.getDesc_categoria()+"')";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
    
    public void update (categoria categoria) throws SQLException{
        if(validar(categoria)){
            String sql;
            sql = "update categoria set desc_categoria = '"+categoria.getDesc_categoria()+"' where cod_categoria = '"+categoria.getCod_categoria()+"'";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
        }else{
            insert(categoria);
        }
    }
    
 
    
    public void delete(categoria categoria) throws SQLException{
        String sql;
        sql = "delete from categoria where cod_categoria = '"+categoria.getCod_categoria()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
    
    public ArrayList<categoria> selectALL() throws SQLException {
        String sql;
        sql = "select * from categoria";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);
    }
    
    public ArrayList<categoria> readDesc(String descricao) throws SQLException {
        String sql;
        sql = "select * from categoria WHERE desc_categoria LIKE '%"+descricao+"%'";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);
    }

    private ArrayList<categoria> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<categoria> categorias = new ArrayList<categoria>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            int cod_categoria = resultSet.getInt("cod_categoria");
            String desc = resultSet.getString("desc_categoria");
            categoria categoriacomDados = new categoria(cod_categoria, desc);
            categorias.add(categoriacomDados);
        }
        
        return categorias;
    }

    public boolean validar(categoria categoria) throws SQLException {
        String sql = "select * from categoria where cod_categoria = '"+categoria.getCod_categoria()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        //pegar o resultado do select
        ResultSet resultSet = statement.getResultSet();
        //se existe é verdadeiro
        return resultSet.next();   
    }
}
