import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDao extends GenericDao{

	public void salvar(Estoque estoque) throws SQLException {
        String insert = "INSERT INTO ESTOQUE(idproduto, idfornecedor, nomeproduto, nomefantasia, quantidade, ativo) VALUES(?,?,?,?,?,?)";
        save(insert, estoque.getIdProduto(), estoque.getIdFornecedor(), estoque.getNomeProduto(), estoque.getNomeFantasia(), estoque.getQuantidade(), estoque.getAtivo());
    }

    public void alterar(Estoque estoque) throws SQLException {
        String update = "UPDATE ESTOQUE " +
                "SET quantidade = ?, ativo = ?" +
                "WHERE idproduto? AND idfornecedor = ?";
        update(update, estoque.getIdProduto(), estoque.getIdFornecedor(), estoque.getQuantidade(), estoque.getAtivo());
    }
    
    public void excluir(int idproduto, int idfornecedor) throws SQLException {
        String delete = "DELETE FROM ESTOQUE WHERE idproduto = ? AND idfornecedor = ?";
        delete(delete, idproduto, idfornecedor);
    }
    
    public List<Estoque> findEstoque() throws SQLException {
        List<Estoque> estoque = new ArrayList<Estoque>();
        
        String select = "SELECT * FROM ESTOQUE";

        PreparedStatement stmt = getConnection().prepareStatement(select);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	Estoque esto = new Estoque();
        	esto.setIdProduto(rs.getInt("idproduto"));
        	esto.setIdFornecedor(rs.getInt("idfornecedor"));
        	esto.setNomeProduto((rs.getString("nomeproduto")));
        	esto.setNomeFantasia((rs.getString("nomefantasia")));
        	esto.setQuantidade((rs.getInt("quantidade")));
        	esto.setAtivo((rs.getBoolean("ativo")));
        	estoque.add(esto);
        }

        rs.close();
        stmt.close();

        return estoque;
    }
    
    public Estoque buscaEstoques(String nomeproduto) throws SQLException {
        String select = "SELECT * FROM ESTOQUE WHERE nomeproduto = ?";
        Estoque esto = null;
        PreparedStatement stmt = getConnection().prepareStatement(select);
        stmt.setString(1, nomeproduto);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	esto = new Estoque();
        	esto.setIdProduto(rs.getInt("idproduto"));
        	esto.setIdFornecedor(rs.getInt("idfornecedor"));
        	esto.setNomeProduto((rs.getString("nomeproduto")));
        	esto.setNomeFantasia((rs.getString("nomefantasia")));
        	esto.setQuantidade((rs.getInt("quantidade")));
        	esto.setAtivo((rs.getBoolean("ativo")));        	
        }

        rs.close();
        stmt.close();
        return esto; 
    }
}
