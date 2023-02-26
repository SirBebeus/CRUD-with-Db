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
import model.livro;

/**
 *
 * @author Matheus
 */
public class LivroDAO {
    private final Connection connection;

    public LivroDAO(Connection connection) {
        this.connection = connection;
    }
     public void insert (livro livro) throws SQLException{
        String sql;
        sql = "insert into livros values ('"+livro.getTitulo()+"','"+livro.getIsbn()+"')";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
     
    public void update (livro livro) throws SQLException{
        if(validar(livro)){
            String sql;
            sql = "update livros set isbn = '"+livro.getIsbn()+"' WHERE titulo = '"+livro.getTitulo()+"'";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();   
        }
        else{
            insert(livro);
        }
     
    }
    
     public void delete(livro livro) throws SQLException{
        String sql;
        sql = "delete from livros where titulo = '"+livro.getTitulo()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
     
     public ArrayList<livro> selectALL() throws SQLException {
        String sql;
        sql = "select * from livros";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);
    }
    
    public ArrayList<livro> readDesc(String descricao) throws SQLException {
        String sql;
        sql = "select * from livros WHERE titulo LIKE '%"+descricao+"%'";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);
    }

    private ArrayList<livro> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<livro> livros = new ArrayList<>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            String titulo;
            String isbn;
            titulo = resultSet.getString("titulo");
            isbn = resultSet.getString("isbn");
            livro livrocomdados = new livro(titulo, isbn);
            livros.add(livrocomdados);
        }
        
        return livros;
    }

    public boolean validar(livro livro) throws SQLException {
        String sql = "select * from livros where titulo = '"+livro.getTitulo()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        //pegar o resultado do select
        ResultSet resultSet = statement.getResultSet();
        //se existe é verdadeiro
        return resultSet.next();   
    }

    
}
