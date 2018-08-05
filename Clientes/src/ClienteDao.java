


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao extends GenericDao {

    public void salvar(Cliente cliente) throws SQLException {
        String insert = "INSERT INTO CLIENTES(cpf, nome, idade, endereco) VALUES(?,?,?,?)";
        save(insert, cliente.getCpf(), cliente.getNome(), cliente.getIdade(), cliente.getEndereco());
    }

    public void alterar(Cliente cliente) throws SQLException {
        String update = "UPDATE CLIENTES " +
                "SET nome = ?, idade = ?, endereco = ? " +
                "WHERE cpf = ?";
        update(update, cliente.getCpf(), cliente.getNome(), cliente.getIdade(), cliente.getEndereco());
    }

    public void excluir(String cpf) throws SQLException {
        String delete = "DELETE FROM CLIENTES WHERE cpf = ?";
        delete(delete, cpf);
    }

    public List<Cliente> findContatos() throws SQLException {
        List<Cliente> contatos = new ArrayList<Cliente>();
        
        String select = "SELECT * FROM CLIENTES";

        PreparedStatement stmt = getConnection().prepareStatement(select);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Cliente contato = new Cliente();
            contato.setCpf(rs.getString("cpf"));
            contato.setNome(rs.getString("nome"));
            contato.setIdade(rs.getInt("idade"));
            contato.setEndereco(rs.getString("endereco"));
            contatos.add(contato);
        }

        rs.close();
        stmt.close();

        return contatos;
    }

    public Cliente findByName(String nome) throws SQLException {
        String select = "SELECT * FROM CLIENTES WHERE nome = ?";
        Cliente contato = null;
        PreparedStatement stmt = getConnection().prepareStatement(select);
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            contato = new Cliente();
            contato.setCpf(rs.getString("cpf"));
            contato.setNome(rs.getString("nome"));
            contato.setIdade(rs.getInt("idade"));
            contato.setEndereco(rs.getString("endereco"));
        }

        rs.close();
        stmt.close();
        return contato; 
    }
    
    public Cliente findByCpf(String cpf) throws SQLException {
        String select = "SELECT * FROM CLIENTES WHERE cpf = ?";
        Cliente contato = null;
        PreparedStatement stmt = getConnection().prepareStatement(select);
        stmt.setString(1, cpf);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            contato = new Cliente();
            contato.setCpf(rs.getString("cpf"));
            contato.setNome(rs.getString("nome"));
            contato.setIdade(rs.getInt("idade"));
            contato.setEndereco(rs.getString("endereco"));
        }

        rs.close();
        stmt.close();
        return contato; 
    }
}