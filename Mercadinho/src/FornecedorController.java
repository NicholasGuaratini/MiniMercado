import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class FornecedorController {

    private Date formatarData(String data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return new Date( formatter.parse(data).getTime() );
    }

    public void salvar(int idFornecedor, String cnpj, String razaoSocial, String nomeFantasia, String bairro, String cidade, String estado, String cep) throws SQLException, ParseException {
    	Fornecedor contato = new Fornecedor();
    	contato.setIdFornecedor(idFornecedor);
        contato.setCNPJ(cnpj);
        contato.setRazaoSocial(razaoSocial);
        contato.setNomeFantasia(nomeFantasia);
        contato.setBairro(bairro);
        contato.setCidade(cidade);
        contato.setEstado(estado);
        contato.setCEP(cep);

        new FornecedorDao().salvar(contato);
    }

    public void alterar(Integer idFornecedor, String cnpj, String razaoSocial, String nomeFantasia, String bairro, String cidade, String estado, String cep) throws ParseException, SQLException {
    	Fornecedor contato = new Fornecedor();
    	contato.setIdFornecedor(idFornecedor);
    	contato.setCNPJ(cnpj);
        contato.setRazaoSocial(razaoSocial);
        contato.setNomeFantasia(nomeFantasia);
        contato.setBairro(bairro);
        contato.setCidade(cidade);
        contato.setEstado(estado);
        contato.setCEP(cep);
        new FornecedorDao().alterar(contato);
    }

    public List<Fornecedor> listaContatos() {
    	FornecedorDao dao = new FornecedorDao();
        try {
            return dao.findContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas ao localizar o fornecedor\n" + e.getLocalizedMessage());
        }
        return null;
    }

    public void excluir(int idFornecedor) throws SQLException {
        new FornecedorDao().excluir(idFornecedor);
    }

    public Fornecedor buscaContatoPorCNPJ(String cnpj) throws SQLException {
    	FornecedorDao dao = new FornecedorDao();
        return dao.buscaContatoPorCNPJ(cnpj);
    }
}