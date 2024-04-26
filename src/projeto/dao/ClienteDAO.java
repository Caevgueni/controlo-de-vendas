/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.dao;

import java.sql.Connection;
import projeto.factory.jdbc.ConnectionFactory;
import projeto.model.Clientes;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class ClienteDAO {

    private Connection con; //criamos o variavel con

    public ClienteDAO() {
        this.con = new ConnectionFactory().getConnection(); // fizemos a cenecao com o banco de dado
    }

    // cadastrar Cliente
    public void cadastrarCliente(Clientes obj) {

        try {
            // 1 primeiro passo criar o comando sql
            String sql = "insert tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            // 2 passo conectar com o banco de dado e organizar o comamndo sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
            stmt.setString(2, obj.getRg()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getTelemovel());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());

            // 3 passo Executar comando sql
            stmt.execute();
            stmt.close(); // para ele fechar a conexao apos a execucaoo
            JOptionPane.showMessageDialog(null, "cadastrado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO" + erro);

        }

    }

    // alterar cliente
    public void alterarCliente(Clientes obj) {
        
        try {
            // 1 primeiro passo criar o comando sql
            String sql = "update tb_clientes set nome=?,rg=?,cpf=?,email=?,telefone=?,celular=?"
                    + ",cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?";

            // 2 passo conectar com o banco de dado e organizar o comamndo sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
            stmt.setString(2, obj.getRg()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getTelemovel());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());
            stmt.setInt(14, obj.getId());

            // 3 passo Executar comando sql
            stmt.execute();
            stmt.close(); // para ele fechar a conexao apos a execucaoo
            JOptionPane.showMessageDialog(null, "Alterado  com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO" + erro);

        }

    }
    // excluir ciente

    public void excluirCliente(Clientes obj) {
        
        try {
            // 1 primeiro passo criar o comando sql
            String sql = "delete from tb_clientes where id= ?";

            // 2 passo conectar com o banco de dado e organizar o comamndo sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
            

            // 3 passo Executar comando sql
            stmt.execute();
            stmt.close(); // para ele fechar a conexao apos a execucaoo
            JOptionPane.showMessageDialog(null, "Ecluido com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO" + erro);

        }

    }

    // metodo Listar todos os clientes 
    public List<Clientes> listaClisentes() {
        try {
            // 1  primeiro passo criar a lista
            List<Clientes> lista = new ArrayList<>();

            // 2 criar o sql, organizar e executar
            String sql = "select *from tb_clientes";

            PreparedStatement stmt = con.prepareStatement(sql);

            // quando se usa um liste o resultado da execucao e guardado neste variavel "ResultSet" 
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) { // equndo ele precurer os registe que ele encpntro rs ele vai criar um objeto do tipo cliente vamos capturar e passar para objetos em baixo

                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id")); // estou fala para ele pegar o que ele encontrar na coluna id que é do tipo int e armazenar dentro do meu objeto no atrebuto setId 
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setTelemovel(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                // uma vez montado objetos pricisamos de lhe colocar o mesmo na lista

                // fica de seguinte maneira
                lista.add(obj);
            }
            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null; // isto é para ele nao retornar nada caso haja erro
        }
    }
    // metodo ConsultaCliente por nome ATENCAO!!! ESTE METODO PARA FOMELARIO DE CADASTROS
    public Clientes consultaPorNome(String nome){
        try {
            // 1 criar o sql, organizar e executar
            String sql = "select * from tb_clientes where nome=?";

            PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setString(1, nome);
              ResultSet rs = stmt.executeQuery();
               Clientes obj = new Clientes();
              if (rs.next()) { 

               

                obj.setId(rs.getInt("id")); // estou fala para ele pegar o que ele encontrar na coluna id que é do tipo int e armazenar dentro do meu objeto no atrebuto setId 
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setTelemovel(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                // uma vez montado objetos pricisamos de lhe colocar o mesmo na lista

                // fica de seguinte maneira
              }return obj;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Cleinte nao encontrado" + e);
            return null;
        }
    }
    // metodo ConsultaCliente por cpf ATENCAO!!! ESTE METODO PARA FOMELARIO DE CADASTROS
    public Clientes consultaPorCpf(String cpf){
        try {
            // 1 criar o sql, organizar e executar
            String sql = "select * from tb_clientes where cpf=?";

            PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setString(1, cpf);
              ResultSet rs = stmt.executeQuery();
               Clientes obj = new Clientes();
              if (rs.next()) { 

               

                obj.setId(rs.getInt("id")); // estou fala para ele pegar o que ele encontrar na coluna id que é do tipo int e armazenar dentro do meu objeto no atrebuto setId 
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setTelemovel(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                // uma vez montado objetos pricisamos de lhe colocar o mesmo na lista

                // fica de seguinte maneira
              }return obj;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Cleinte nao encontrado" + e);
            return null;
        }
    }
    
    
    // Buscar cliente pelo nome NA TABELA!!
    public List<Clientes> buscaClientePorNome(String nome) {
        try {
            // 1  primeiro passo criar a lista
            List<Clientes> lista = new ArrayList<>();

            // 2 criar o sql, organizar e executar
            String sql = "select * from tb_clientes where nome like?";

            PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) { 

                Clientes obj = new Clientes();

                obj.setId(rs.getInt("id")); // estou fala para ele pegar o que ele encontrar na coluna id que é do tipo int e armazenar dentro do meu objeto no atrebuto setId 
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setTelemovel(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                // uma vez montado objetos pricisamos de lhe colocar o mesmo na lista

                // fica de seguinte maneira
                lista.add(obj);
            }
            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null; // isto é para ele nao retornar nada caso haja erro
        }
    }

}
