
public class Estoque {

	private int IdProduto;
	private int IdFornecedor;
	private String NomeProduto;
	private String NomeFantasia;
    private int Quantidade;
    private Boolean Ativo;
    
  //IdProduto
    public int getIdProduto() {
		return IdProduto;
	}
	public void setIdProduto(int idProduto) {
		this.IdProduto = idProduto;
	}
	
	//IdFornecedor
    public int getIdFornecedor() {
		return IdFornecedor;
	}
	public void setIdFornecedor(int idFornecedor) {
		this.IdFornecedor = idFornecedor;
	}
	
	//NomeProduto
    public String getNomeProduto() {
		return NomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.NomeProduto = nomeProduto;
	}
	
	//NomeFantasia
	public String getNomeFantasia() {
		return NomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.NomeFantasia = nomeFantasia;
	}
	
	//Quantidade
    public int getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.Quantidade = quantidade;
	}
	
	//Ativo
    public Boolean getAtivo() {
		return Ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.Ativo = ativo;
	}
}
