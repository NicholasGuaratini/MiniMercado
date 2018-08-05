import java.math.BigDecimal;

public class Produto {
    
	private int IdProduto;
	private int CodBarras;
	private String Nome;
    private BigDecimal PrecoVenda;
    private String NCM;
    
    //gere os métodos getters and setters
    
    //IdProduto
    public int getIdProduto() {
		return IdProduto;
	}
	public void setIdProduto(int idProduto) {
		this.IdProduto = idProduto;
	}
	
	//CodBarras
    public int getCodBarras() {
		return CodBarras;
	}
	public void setCodBarras(int codBarras) {
		this.CodBarras = codBarras;
	}
	
	//Nome
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		this.Nome = nome;
	}
	
	//PrecoVenda
	public BigDecimal getPrecoVenda() {
		return PrecoVenda;
	}
	public void setPrecoVenda(BigDecimal bigDecimal) {
		this.PrecoVenda = bigDecimal;
	}
	
	//NCM
	public String getNcm() {
		return NCM;
	}
	public void setNcm(String ncm) {
		this.NCM = ncm;
	}
}