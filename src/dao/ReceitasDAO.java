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
import model.cozinheiro;
import model.receitas;

/**
 *
 * @author Matheus
 */
public class ReceitasDAO {
    private final Connection connection;

    //so vou conseguir acessar categoriaDAO se tiver conectado no banco
    public ReceitasDAO(Connection connection) {
        this.connection = connection;
    }
    public void insert (receitas receitas) throws SQLException{
        String sql;
        sql = "insert into receitas values ('"+receitas.getCod_receita()+"', '"+receitas.getNome_receita()+"', '"+receitas.getCozinheiro().getNome_fantasia()+"', '"+receitas.getCategoria().getCod_categoria()+"', '"+receitas.getDt_criacao()+"')";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
    public void update (receitas receitas) throws SQLException{
        if(validar(receitas)){
            String sql;
            sql = "update receitas as r set nome_receita ='"+receitas.getNome_receita()+"', nome_chef ='"+receitas.getCozinheiro().getNome_fantasia()+"', cod_categoria ='"+receitas.getCategoria().getCod_categoria()+"', dt_criacao ='"+receitas.getDt_criacao()+"' where cod_receita = '"+receitas.getCod_receita()+"'";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
        }else{
            insert(receitas);
        }
    }
     public boolean validar(receitas receitas) throws SQLException {
        String sql = "select * from receitas where cod_receita = '"+receitas.getCod_receita()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        //pegar o resultado do select
        ResultSet resultSet = statement.getResultSet();
        //se existe é verdadeiro
        return resultSet.next();   
    }
    
 
    public void delete(receitas receitas) throws SQLException{
        String sql;
        sql = "delete from receitas where cod_receita = '"+receitas.getCod_receita()+"'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }
    public ArrayList<receitas> selectALL() throws SQLException {
        String sql;
        sql = "select cod_receita, nome_receita, nome_chef, r.cod_categoria as rcod, dt_criacao from receitas as r inner join cozinheiros as co on co.nome_fantasia = r.nome_chef  inner join categoria as cat on cat.cod_categoria = r.cod_categoria;";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);
    }
    public ArrayList<receitas> relatorio() throws SQLException {
        String sql;
        sql = "select crr.nome_fantasia as Chef from receitas rtt inner join cozinheiros crr on rtt.nome_chef = crr.nome_fantasia where rtt.dt_criacao  BETWEEN  '01-01-2022' and '31-12-2022'   group by crr.nome_fantasia having count (crr.nome_fantasia)>=2";
        PreparedStatement statement = connection.prepareStatement(sql);
        ArrayList<receitas> receitas = new ArrayList<>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            int cod_receita = 0;
            String nome_receita = "";
            String dt_criacao = "";
            cozinheiro cozinheiro = new cozinheiro();
            cozinheiro.setNome_fantasia(resultSet.getString("Chef"));
            categoria categoria = new categoria();
            receitas receitascomDados = new receitas(cod_receita, nome_receita, dt_criacao, cozinheiro, categoria);
            receitas.add(receitascomDados);
        }
        
        return receitas;
        
    }
    
    public ArrayList<receitas> readDesc(String descricao) throws SQLException {
        String sql;
        sql = "select cod_receita, nome_receita, nome_chef, r.cod_categoria as rcod, dt_criacao from receitas as r inner join cozinheiros as co on co.nome_fantasia = r.nome_chef  inner join categoria as cat on cat.cod_categoria = r.cod_categoria WHERE r.nome_receita LIKE '%"+descricao+"%'";
        PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);
    }
    public ArrayList<receitas> Consulta(String descricao) throws SQLException{
        String sql;
        sql = "select rts.cod_receita,rts.nome_receita,css.nome_cozinheiro from receitas  rts inner join cozinheiros css on css.nome_fantasia = rts.nome_chef where rts.cod_categoria ='"+descricao+"' ";
        PreparedStatement statement = connection.prepareStatement(sql);
        ArrayList<receitas> receitas = new ArrayList<>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            int cod_receita = resultSet.getInt("cod_receita");
            String nome_receita = resultSet.getString("nome_receita");
            String dt_criacao = "";
            cozinheiro cozinheiro = new cozinheiro();
            cozinheiro.setNome_fantasia(resultSet.getString("nome_cozinheiro"));
            categoria categoria = new categoria();
            receitas receitascomDados = new receitas(cod_receita, nome_receita, dt_criacao, cozinheiro, categoria);
            receitas.add(receitascomDados);
        }
        
        return receitas;
    }

    private ArrayList<receitas> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<receitas> receitas = new ArrayList<receitas>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while(resultSet.next()){
            int cod_receita = resultSet.getInt("cod_receita");
            String nome_receita = resultSet.getString("nome_receita");
            String dt_criacao = resultSet.getString("dt_criacao");
            
            cozinheiro cozinheiro = new cozinheiro();
            cozinheiro.setNome_fantasia(resultSet.getString("nome_chef"));
            categoria categoria = new categoria();
            categoria.setCod_categoria(resultSet.getInt("rcod"));
            receitas receitascomDados = new receitas(cod_receita, nome_receita, dt_criacao, cozinheiro, categoria);
            receitas.add(receitascomDados);
        }
        
        return receitas;
    }
}
