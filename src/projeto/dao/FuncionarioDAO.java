
package projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projeto.factory.jdbc.ConnectionFactory;
import projeto.model.Clientes;
import projeto.model.Funcionario;


public class FuncionarioDAO {
    
    private Connection con; //criamos o variavel con

    public FuncionarioDAO() {
        this.con = new ConnectionFactory().getConnection(); // fizemos a cenecao com o banco de dado
    }
    
     // cadastrar Funcionario
    public void cadastrarFuncionario(Funcionario obj) {

        try {
            // 1 primeiro passo criar o comando sql
            String sql = "insert tb_funcionarios(nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            // 2 passo conectar com o banco de dado e organizar o comamndo sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
            stmt.setString(2, obj.getRg()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getTelemovel());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());

            // 3 passo Executar comando sql
            stmt.execute();
            stmt.close(); // para ele fechar a conexao apos a execucaoo
            JOptionPane.showMessageDialog(null, "cadastrado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO" + erro);

        }

    }
    
    // metodo Alterar funcionario
    
       public void alterarFuncionario(Funcionario obj) {
        
        try {
            // 1 primeiro passo criar o comando sql
            String sql = "update tb_funcionarios set nome=?,rg=?,cpf=?,email=?,senha=?,cargo=?,nivel_acesso=?,telefone=?,celular=?"
                    + ",cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?";

            // 2 passo conectar com o banco de dado e organizar o comamndo sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
            stmt.setString(2, obj.getRg()); // isto colacar na primeira intorugacao o que vier dentro de atrebuto obj.jetNome
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getTelemovel());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());
            stmt.setInt(17, obj.getId());

            // 3 passo Executar comando sql
            stmt.execute();
            stmt.close(); // para ele fechar a conexao apos a execucaoo
            JOptionPane.showMessageDialog(null, "Alterado  com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ERRO" + erro);

        }

    }
    // Metodo excluir funcionario
       
    public void excluirFuncionario(Funcionario obj) {
        
        try {
            // 1 primeiro passo criar o comando sql
            String sql = "delete from tb_funcionarios where id= ?";

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
    public List<Funcionario> listaFuncionario() {
        try {
            // 1  primeiro passo criar a lista
            List<Funcionario> lista = new ArrayList<>();

            // 2 criar o sql, organizar e executar
            String sql = "select *from tb_funcionarios";

            PreparedStatement stmt = con.prepareStatement(sql);

            // quando se usa um liste o resultado da execucao e guardado neste variavel "ResultSet" 
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) { // equndo ele precurer os registe que ele encpntro rs ele vai criar um objeto do tipo cliente vamos capturar e passar para objetos em baixo

                Funcionario obj = new Funcionario();

                obj.setId(rs.getInt("id")); // estou fala para ele pegar o que ele encontrar na coluna id que é do tipo int e armazenar dentro do meu objeto no atrebuto setId 
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
