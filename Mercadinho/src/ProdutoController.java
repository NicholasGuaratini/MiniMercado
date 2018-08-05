import javax.swing.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ProdutoController {

    private Date formatarData(String data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return new Date( formatter.parse(data).getTime() );
    }

    public void salvar(Integer codBarras, String nome, BigDecimal precoVenda, String ncm) throws SQLException, ParseException {
        Produto contato = new Produto();
        contato.setCodBarras(codBarras);
        contato.setNome(nome);
        contato.setPrecoVenda(precoVenda);
        contato.setNcm(ncm);

        new ProdutoDao().salvar(contato);
    }

    public void alterar(Integer idProduto, Integer codBarras, String nome, BigDecimal precoVenda, String ncm) throws ParseException, SQLException {
    	Produto contato = new Produto();
    	contato.setIdProduto(idProduto);
    	contato.setCodBarras(codBarras);
    	contato.setNome(nome);
        contato.setPrecoVenda(precoVenda);
        contato.setNcm(ncm);

        new ProdutoDao().alterar(contato);
    }

    public List<Produto> listaContatos() {
    	ProdutoDao dao = new ProdutoDao();
        try {
            return dao.findProdutos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas ao localizar contato\n" + e.getLocalizedMessage());
        }
        return null;
    }

    public void excluir(int idproduto) throws SQLException {
        new ProdutoDao().excluir(idproduto);
    }

    public Produto buscaContatoPorCodBarras(int codBarras) throws SQLException {
    	ProdutoDao dao = new ProdutoDao();
        return dao.findByCodBarras(codBarras);
    }
}