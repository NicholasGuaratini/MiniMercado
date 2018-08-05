

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ClienteController {

    private Date formatarData(String data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return new Date( formatter.parse(data).getTime() );
    }

    public void salvar(String cpf, String nome, int idade, String endereco) throws SQLException, ParseException {
        Cliente contato = new Cliente();
        contato.setCpf(cpf);
        contato.setNome(nome);
        contato.setIdade(idade);
        contato.setEndereco(endereco);

        new ClienteDao().salvar(contato);
    }

    public void alterar(String cpf, String nome, int idade, String endereco) throws ParseException, SQLException {
        Cliente contato = new Cliente();
        contato.setCpf(cpf);
        contato.setNome(nome);
        contato.setIdade(idade);
        contato.setEndereco(endereco);

        new ClienteDao().alterar(contato);
    }

    public List<Cliente> listaContatos() {
        ClienteDao dao = new ClienteDao();
        try {
            return dao.findContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas ao localizar contato\n" + e.getLocalizedMessage());
        }
        return null;
    }

    public void excluir(String cpf) throws SQLException {
        new ClienteDao().excluir(cpf);
    }

    public Cliente buscaContatoPorNome(String nome) throws SQLException {
        ClienteDao dao = new ClienteDao();
        return dao.findByName(nome);
    }
    public Cliente buscaContatoPorCpf(String cpf) throws SQLException {
        ClienteDao dao = new ClienteDao();
        return dao.findByCpf(cpf);
    }
}