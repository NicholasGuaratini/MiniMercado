import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.swing.JOptionPane;

public class EstoqueController {
	
	
	public void salvar(int idProduto, int idFornecedor, String nomeProduto, String nomeFantasia, int quantidade, Boolean ativo) throws SQLException, ParseException {
    	Estoque est = new Estoque();
    	est.setIdProduto(idProduto);
    	est.setIdFornecedor(idFornecedor);
    	est.setNomeProduto(nomeProduto);
    	est.setNomeFantasia(nomeFantasia);
    	est.setQuantidade(quantidade);
    	est.setAtivo(ativo);

        new EstoqueDao().salvar(est);
    }
	
	public void alterar(int quantidade, Boolean ativo) throws ParseException, SQLException {
		Estoque est = new Estoque();
    	est.setQuantidade(quantidade);
    	est.setAtivo(ativo);

        new EstoqueDao().salvar(est);
    	
    }
	
	public List<Estoque> listaEstoque() {
    	EstoqueDao dao = new EstoqueDao();
        try {
            return dao.findEstoque();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas ao localizar no estoque\n" + e.getLocalizedMessage());
        }
        return null;
    }
	
	public void excluir(int idProduto, int idFornecedor) throws SQLException {
        new EstoqueDao().excluir(idProduto, idFornecedor);
    }

    public Estoque buscaEstoque(String nomeProduto) throws SQLException {
    	EstoqueDao dao = new EstoqueDao();
        return dao.buscaEstoques(nomeProduto);
    }
	
}
