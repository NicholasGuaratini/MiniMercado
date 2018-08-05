import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao extends GenericDao {

    public void salvar(Produto produto) throws SQLException {
        String insert = "INSERT INTO PRODUTO(codbarras, nome, precovenda, ncm) VALUES(?,?,?,?)";
        save(insert, produto.getCodBarras(), produto.getNome(), produto.getPrecoVenda(), produto.getNcm());
    }

    public void alterar(Produto produto) throws SQLException {
        String update = "UPDATE PRODUTO " +
                "SET codbarras = ?, nome = ?, precovenda = ?, NCM = ? " +
                "WHERE idproduto = ?";
        update(update, produto.getIdProduto(), produto.getCodBarras(), produto.getNome(), produto.getPrecoVenda(), produto.getNcm());
    }

    public void excluir(int idproduto) throws SQLException {
        String delete = "DELETE FROM PRODUTO WHERE idproduto = ?";
        delete(delete, idproduto);
    }

    public List<Produto> findProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<Produto>();
        
        String select = "SELECT * FROM PRODUTO";

        PreparedStatement stmt = getConnection().prepareStatement(select);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	Produto produto = new Produto();
        	produto.setIdProduto(rs.getInt("idproduto"));
        	produto.setCodBarras(rs.getInt("codBarras"));
        	produto.setNome(rs.getString("nome"));
        	produto.setPrecoVenda(rs.getBigDecimal("precovenda"));
        	produto.setNcm(rs.getString("ncm"));
        	produtos.add(produto);
        }

        rs.close();
        stmt.close();

        return produtos;
    }
    
    public Produto findByCodBarras(int codBarras) throws SQLException {
        String select = "SELECT * FROM PRODUTO WHERE codbarras = ?";
        Produto contato = null;
        PreparedStatement stmt = getConnection().prepareStatement(select);
        stmt.setInt(1, codBarras);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            contato = new Produto();
            contato.setIdProduto(rs.getInt("idproduto"));
            contato.setCodBarras(rs.getInt("codBarras"));
            contato.setNome(rs.getString("nome"));
            contato.setPrecoVenda(rs.getBigDecimal(("precovenda")));
            contato.setNcm(rs.getString("ncm"));
        }

        rs.close();
        stmt.close();
        return contato; 
    }
}