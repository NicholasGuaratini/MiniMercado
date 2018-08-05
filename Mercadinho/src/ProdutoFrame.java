import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

public class ProdutoFrame extends JFrame {
	
	private JLabel lblIdProduto, lblCodBarras, lblNome, lblPrecoVenda, lblNcm;
	private JTextField txtIdProduto, txtCodBarras, txtNome, txtPrecoVenda, txtNcm, txtLocalizar;
    private JButton btnSalvar, btnAlterar, btnExcluir, btnClear, btnLocalizar;

    private List<Produto> produtoList = new ProdutoController().listaContatos();
    private int registroAtual = 0;

    public ProdutoFrame() {
        super("Produtos");
        Container tela = getContentPane();
        setLayout(null);
        lblIdProduto = new JLabel("Id Produto");
        lblCodBarras = new JLabel("Codigo Barras");
        lblNome = new JLabel("Nome");
        lblPrecoVenda = new JLabel("Preço de Venda");
        lblNcm = new JLabel("NCM");

        lblIdProduto.setBounds(10,55,240,15);
        lblCodBarras.setBounds(10,105,240,15);
        lblNome.setBounds(10, 155, 240, 15);
        lblPrecoVenda.setBounds(10, 205, 240, 15);
        lblNcm.setBounds(10, 255, 240, 15);
        
        lblIdProduto.setForeground(Color.BLACK);
        lblCodBarras.setForeground(Color.BLACK);
        lblNome.setForeground(Color.BLACK);
        lblPrecoVenda.setForeground(Color.BLACK);
        lblNcm.setForeground(Color.BLACK);

        lblIdProduto.setFont(new Font("Courier New", Font.BOLD, 14));
        lblCodBarras.setFont(new Font("Courier New", Font.BOLD, 14));
        lblNome.setFont(new Font("Courier New", Font.BOLD, 14));
        lblPrecoVenda.setFont(new Font("Courier New", Font.BOLD, 14));
        lblNcm.setFont(new Font("Courier New", Font.BOLD, 14));

        tela.add(lblIdProduto);
        tela.add(lblCodBarras);
        tela.add(lblNome);
        tela.add(lblPrecoVenda);
        tela.add(lblNcm);
        
        txtIdProduto = new JTextField();
        txtCodBarras = new JTextField();
        txtNome = new JTextField();
        txtPrecoVenda = new JTextField();
        txtNcm = new JTextField();

        txtIdProduto.setBounds(10, 70, 265, 20);
        txtCodBarras.setBounds(10, 120, 265, 20);
        txtNome.setBounds(10, 170, 265, 20);
        txtPrecoVenda.setBounds(10, 220, 265, 20);
        txtNcm.setBounds(10, 270, 265, 20);
        
        tela.add(txtIdProduto);
        tela.add(txtCodBarras);
        tela.add(txtNome);
        tela.add(txtPrecoVenda);
        tela.add(txtNcm);

        btnSalvar = new JButton("Salvar");        
        btnAlterar = new JButton("Alterar");
        btnExcluir = new JButton("Excluir");
        btnClear = new JButton("Limpar");
       
        btnSalvar.setBounds(20, 350, 80, 20);
        btnAlterar.setBounds(110, 350, 80, 20);
        btnExcluir.setBounds(200, 350, 80, 20);
        btnClear.setBounds(290, 350, 80, 20);

        tela.add(btnSalvar);
        tela.add(btnAlterar);
        tela.add(btnExcluir);
        tela.add(btnClear);


        JLabel lblLocalizar = new JLabel("Localizar por Código de Barras");
        lblLocalizar.setBounds(10, 7, 220, 20);

        txtLocalizar = new JTextField();
        txtLocalizar.setBounds(10, 25, 220, 20);

        btnLocalizar = new JButton("Ir");
        btnLocalizar.setBounds(230, 25, 55, 20);

        tela.add(lblLocalizar);
        tela.add(txtLocalizar);
        tela.add(btnLocalizar);


        setSize(400, 500);
        setVisible(true);
        setLocationRelativeTo(null);
    
    
	    btnSalvar.addActionListener(
	            new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    onClickSalvar();
	                }
	            }
	    );
	
	    btnAlterar.addActionListener(
	            new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    onClickAlterar();
	                }
	            }
	    );
	
	    btnExcluir.addActionListener(
	            new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    onClickExcluir();
	                }
	            }
	    );
	    
	    btnLocalizar.addActionListener(
	            new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                   onClickLocalizar();
	                }
	            }
	    );
	    
	    btnClear.addActionListener(
	            new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    clearFields();
	                    registroAtual = 0;
	                }
	            }
	    );
    }
    
    private void onClickExcluir() {
    	ProdutoController pp = new ProdutoController();
    	int idProd = (produtoList.get(registroAtual).getIdProduto());
        try {
        	pp.excluir(idProd);
            JOptionPane.showMessageDialog(this, "Produto excluido com sucesso!");
            clearFields();
            produtoList = new ProdutoController().listaContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel excluir o produto!\n" + e.getLocalizedMessage());
        }
    }
    
    private void onClickSalvar() {
    	ProdutoController pp = new ProdutoController();
        try {
        	pp.salvar(new Integer(txtCodBarras.getText()).intValue(),txtNome.getText(), new BigDecimal(txtPrecoVenda.getText()), txtNcm.getText());
            JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
            clearFields();
            produtoList = new ProdutoController().listaContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel salvar o produto!\n" + e.getLocalizedMessage());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Data possui formato inválido!\n" + e.getLocalizedMessage());
        }
    }
    
    private void onClickAlterar() {
    	ProdutoController pp = new ProdutoController();
        int idProd = (produtoList.get(registroAtual).getIdProduto());
        try {
        	pp.alterar(Integer.parseInt(txtIdProduto.getText()), Integer.parseInt(txtCodBarras.getText()),txtNome.getText(), new BigDecimal ((txtPrecoVenda.getText())), txtNcm.getText());
    		
            JOptionPane.showMessageDialog(this, "Produto alterado com sucesso!");
            
            //Limpa o codigo do texto localizar
            clearFields();
            produtoList = new ProdutoController().listaContatos();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel alterar contato!\n" + e.getLocalizedMessage());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Dados possui formato inválido!\n" + e.getLocalizedMessage());
        }
    }
    
    private void onClickLocalizar() {
        ProdutoController pp = new ProdutoController();
        try {
            Produto c = pp.buscaContatoPorCodBarras(Integer.parseInt(txtLocalizar.getText()));
            //Limpa o codigo do texto localizar
            txtLocalizar.setText("");
            
            //Adiciona os dados do produto nos TextBoxs
            txtIdProduto.setText(Integer.toString(c.getIdProduto()));
            txtIdProduto.enable(false);
            txtCodBarras.setText(Integer.toString(c.getCodBarras()));
            txtNome.setText(c.getNome());
            txtNcm.setText(c.getNcm());
            DecimalFormat df = new DecimalFormat("0.00##");   
            String angleFormated = df.format(c.getPrecoVenda());
            txtPrecoVenda.setText(angleFormated);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro, tente novamente!\n" + e.getLocalizedMessage());
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(this, "Contato não localizado ou não existe!\n" + e.getLocalizedMessage());
        }
    }  
    
    private void clearFields() {
    	txtIdProduto.setText("");
    	txtIdProduto.enable(true);
    	txtCodBarras.setText("");
        txtNome.setText("");
        txtPrecoVenda.setText("");
        txtNcm.setText("");
        txtLocalizar.setText("");
    }
    
    public static void main(String[] args) {
       ProdutoFrame frame = new ProdutoFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
