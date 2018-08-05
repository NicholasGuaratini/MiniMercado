import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDao extends GenericDao {

    public void salvar(Fornecedor fornecedor) throws SQLException {
        String insert = "INSERT INTO FORNECEDOR(idfornecedor, cnpj, razaosocial, nomefantasia, bairro, cidade, estado,cep) VALUES(?,?,?,?,?,?,?,?)";
        save(insert, fornecedor.getIdFornecedor(), fornecedor.getCNPJ(), fornecedor.getRazaoSocial(), fornecedor.getNomeFantasia(), fornecedor.getBairro(), fornecedor.getCidade(), fornecedor.getEstado(), fornecedor.getCEP());
    }

    public void alterar(Fornecedor fornecedor) throws SQLException {
        String update = "UPDATE FORNECEDOR " +
                "SET cnpj = ?, razaosocial = ?, nomefantasia = ?, bairro = ?, cidade = ?, estado = ?, cep = ? " +
                "WHERE idfornecedor = ?";
        update(update, fornecedor.getIdFornecedor(), fornecedor.getCNPJ(), fornecedor.getRazaoSocial(), fornecedor.getNomeFantasia(), fornecedor.getBairro(), fornecedor.getCidade(), fornecedor.getEstado(), fornecedor.getCEP());
    }

    public void excluir(int idfornecedor) throws SQLException {
        String delete = "idfornecedor = ?;"
        		+ "SET @IDFORNECEDOR = idfornecedor;"
        		+ "DELETE FROM fornecedor WHERE NOT EXISTS ("
        		+ " SELECT * FROM estoque inner join fornecedor f on (estoque.IdFornecedor = f.IdFornecedor and estoque.IdFornecedor = @IDFORNECEDOR)"         
        		;
        
        delete(delete, idfornecedor);
    }

    public List<Fornecedor> findContatos() throws SQLException {
        List<Fornecedor> contatos = new ArrayList<Fornecedor>();
        
        String select = "SELECT * FROM FORNECEDOR";

        PreparedStatement stmt = getConnection().prepareStatement(select);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	Fornecedor contato = new Fornecedor();
        	contato.setIdFornecedor(rs.getInt("idfornecedor"));
        	contato.setRazaoSocial((rs.getString("razaosocial")));
        	contato.setNomeFantasia((rs.getString("nomefantasia")));
        	contato.setBairro((rs.getString("bairro")));
        	contato.setCidade((rs.getString("cidade")));
        	contato.setEstado((rs.getString("estado")));
        	contato.setCEP((rs.getString("cep")));
            contatos.add(contato);
        }

        rs.close();
        stmt.close();

        return contatos;
    }
    
    public Fornecedor buscaContatoPorCNPJ(String cnpj) throws SQLException {
        String select = "SELECT * FROM FORNECEDOR WHERE cnpj = ?";
        Fornecedor contato = null;
        PreparedStatement stmt = getConnection().prepareStatement(select);
        stmt.setString(1, cnpj);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            contato = new Fornecedor();
            contato.setIdFornecedor(rs.getInt("idfornecedor"));
            contato.setCNPJ((rs.getString("cnpj")));
        	contato.setRazaoSocial((rs.getString("razaosocial")));
        	contato.setNomeFantasia((rs.getString("nomefantasia")));
        	contato.setBairro((rs.getString("bairro")));
        	contato.setCidade((rs.getString("cidade")));
        	contato.setEstado((rs.getString("estado")));
        	contato.setCEP((rs.getString("cep")));
        }

        rs.close();
        stmt.close();
        return contato; 
    }
}