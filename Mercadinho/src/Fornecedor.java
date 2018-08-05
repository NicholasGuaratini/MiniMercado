import java.sql.Date;
import java.text.DecimalFormat;

public class Fornecedor {

	private int IdFornecedor;
	private String CNPJ;
	private String RazaoSocial;
	private String NomeFantasia;
	private String Bairro;
	private String Cidade;
	private String Estado;
	private String CEP;
    
    //gere os métodos getters and setters
    
    //IdFornecedor
    public int getIdFornecedor() {
		return IdFornecedor;
	}
	public void setIdFornecedor(int idFornecedor) {
		this.IdFornecedor = idFornecedor;
	}
	
	//CNPJ
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cnpj) {
		this.CNPJ = cnpj;
	}
	
	//RazaoSocial
	public String getRazaoSocial() {
		return RazaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.RazaoSocial = razaoSocial;
	}
	
	//NomeFantasia
	public String getNomeFantasia() {
		return NomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.NomeFantasia = nomeFantasia;
	}
	
	//Bairro
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		this.Bairro = bairro;
	}
	
	//Cidade
	public String getCidade() {
		return Cidade;
	}
	public void setCidade(String cidade) {
		this.Cidade = cidade;
	}
	
	//Estado
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		this.Estado = estado;
	}
	
	//CEP
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cep) {
		this.CEP = cep;
	}
}
