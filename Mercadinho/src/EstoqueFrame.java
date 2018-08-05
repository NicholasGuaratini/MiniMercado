import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class EstoqueFrame extends JFrame {

	private JLabel lblIdProduto, lblIdFornecedor, lblNomeProduto, lblNomeFornecedor, lblQuantidade, lblAtivo;
	private JTextField txtIdProduto, txtIdFornecedor, txtNomeProduto, txtNomeFornecedor, txtQuantidade, txtLocalizar;
	private JCheckBox chkAtivo;
	private JButton btnSalvar, btnAlterar, btnExcluir, btnClear, btnLocalizar;
	
	private List<Estoque> estoqueList = new EstoqueController().listaEstoque();
    private int registroAtual = 0;
    
    @SuppressWarnings("deprecation")
	public EstoqueFrame() {
        super("Estoque");
        Container tela = getContentPane();
        setLayout(null);
        
        lblIdProduto = new JLabel("Id Produto");
        lblIdFornecedor = new JLabel("Id Fornecedor");
        lblNomeProduto = new JLabel("Nome Produto");
        lblNomeFornecedor = new JLabel("Nome Fornecedor");
        lblQuantidade = new JLabel("Quantidade");
        lblAtivo = new JLabel("Ativo");
        
        lblIdProduto.setBounds(10,55,240,15);
        lblIdFornecedor.setBounds(10,105,240,15);
        lblNomeProduto.setBounds(10, 155, 240, 15);
        lblNomeFornecedor.setBounds(10, 205, 240, 15);
        lblQuantidade.setBounds(10, 255, 240, 15);
        lblAtivo.setBounds(10, 305, 240, 15);
        
        lblIdProduto.setForeground(Color.BLACK);
        lblIdFornecedor.setForeground(Color.BLACK);
        lblNomeProduto.setForeground(Color.BLACK);
        lblNomeFornecedor.setForeground(Color.BLACK);
        lblQuantidade.setForeground(Color.BLACK);
        lblAtivo.setForeground(Color.BLACK);
        
        lblIdProduto.setFont(new Font("Courier New", Font.BOLD, 14));
        lblIdFornecedor.setFont(new Font("Courier New", Font.BOLD, 14));
        lblNomeProduto.setFont(new Font("Courier New", Font.BOLD, 14));
        lblNomeFornecedor.setFont(new Font("Courier New", Font.BOLD, 14));
        lblQuantidade.setFont(new Font("Courier New", Font.BOLD, 14));
        lblAtivo.setFont(new Font("Courier New", Font.BOLD, 14));
        
        tela.add(lblIdProduto);
        tela.add(lblIdFornecedor);
        tela.add(lblNomeProduto);
        tela.add(lblNomeFornecedor);
        tela.add(lblQuantidade);
        tela.add(lblAtivo);
        
        txtIdProduto = new JTextField();
        txtIdFornecedor = new JTextField();
        txtNomeProduto= new JTextField();
        txtNomeFornecedor = new JTextField();
        txtQuantidade= new JTextField();
        chkAtivo = new JCheckBox();
        
        txtIdProduto.setBounds(10, 70, 265, 20);
        txtIdFornecedor.setBounds(10, 120, 265, 20);
        txtNomeProduto.setBounds(10, 170, 265, 20);
        txtNomeFornecedor.setBounds(10, 220, 265, 20);
        txtQuantidade.setBounds(10, 270, 265, 20);
        chkAtivo.setBounds(10, 320, 265, 20);
        
        tela.add(txtIdProduto);
        tela.add(txtIdFornecedor);
        tela.add(txtNomeProduto);
        tela.add(txtNomeFornecedor);
        tela.add(txtQuantidade);
        tela.add(chkAtivo);
        
        btnSalvar = new JButton("Salvar");
        btnAlterar = new JButton("Alterar");
        btnExcluir = new JButton("Excluir");
        btnClear = new JButton("Limpar");

        btnSalvar.setBounds(20, 450, 80, 20);
        btnAlterar.setBounds(110, 450, 80, 20);
        btnExcluir.setBounds(200, 450, 80, 20);
        btnClear.setBounds(290, 450, 80, 20);
        
        tela.add(btnSalvar);
        tela.add(btnAlterar);
        tela.add(btnExcluir);
        tela.add(btnClear);
        
        JLabel lbLocalizar = new JLabel("Localizar por NomeProduto");
        lbLocalizar.setBounds(10, 7, 220, 20);

        txtLocalizar = new JTextField();
        txtLocalizar.setBounds(10, 25, 220, 20);

        btnLocalizar = new JButton("Ir");
        btnLocalizar.setBounds(230, 25, 55, 20);

        tela.add(lbLocalizar);
        tela.add(txtLocalizar);
        tela.add(btnLocalizar);
        
        setSize(400, 550);
        setVisible(true);
        setLocationRelativeTo(null);
        
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
        
        btnSalvar.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickSalvar();
                    }
                }
        );
        
        
    }
    
    private void onClickSalvar() {
    	EstoqueController ee = new EstoqueController();
        try {
        	boolean selected = chkAtivo.isSelected();
            ee.salvar(Integer.parseInt(txtIdProduto.getText()),Integer.parseInt(txtIdFornecedor.getText()), txtNomeProduto.getText(), txtNomeFornecedor.getText(), Integer.parseInt(txtQuantidade.getText()), selected);
            
            JOptionPane.showMessageDialog(this, "Estoque salvo com sucesso!");
            //Limpa o codigo do texto localizar
            clearFields();
            estoqueList = new EstoqueController().listaEstoque();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel salvar o estoque!\n" + e.getLocalizedMessage());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Data possui formato inválido!\n" + e.getLocalizedMessage());
        }
    }
    
    private void onClickExcluir() {
    	EstoqueController ee = new EstoqueController();
    	int idProd = Integer.parseInt(txtIdProduto.getText());
    	int idForn = Integer.parseInt(txtIdFornecedor.getText());
        try {
            ee.excluir(idProd, idForn);
            JOptionPane.showMessageDialog(this, "Estoque excluido com sucesso!");
            clearFields();
            estoqueList = new EstoqueController().listaEstoque();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel excluir o Estoque!\n" + e.getLocalizedMessage());
        }
    }
    
    private void onClickAlterar() {
    	EstoqueController ee = new EstoqueController();
    	int idProd = (estoqueList.get(registroAtual).getIdProduto());
    	int idForn = (estoqueList.get(registroAtual).getIdFornecedor());
        try {
        	boolean selected = chkAtivo.isSelected();
        	ee.alterar(Integer.parseInt(txtQuantidade.getText()), selected);
    		
            JOptionPane.showMessageDialog(this, "Estoque alterado com sucesso!");
            
            //Limpa o codigo do texto localizar
            clearFields();
            estoqueList = new EstoqueController().listaEstoque();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel alterar o estoque!\n" + e.getLocalizedMessage());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Dados possui formato inválido!\n" + e.getLocalizedMessage());
        }
    }
    
        private void onClickLocalizar() {
        	EstoqueController ee = new EstoqueController();
        	  try {
                  Estoque e = ee.buscaEstoque(txtLocalizar.getText());
                  //Limpa o codigo do texto localizar
                  txtLocalizar.setText("");
                  
                  txtIdProduto.setText(Integer.toString(e.getIdProduto()));
                  txtIdProduto.enable(false);
                  txtIdFornecedor.setText(Integer.toString(e.getIdFornecedor()));
                  txtIdFornecedor.enable(false);
                  txtNomeProduto.setText(e.getNomeProduto());
                  txtNomeProduto.enable(false);
          		  txtNomeFornecedor.setText(e.getNomeFantasia());
          		  txtNomeFornecedor.enable(false);
          		  txtQuantidade.setText(Integer.toString(e.getQuantidade()));
          		  chkAtivo.setSelected((e.getAtivo()));
              	  
    	        } catch (SQLException e) {
    	            JOptionPane.showMessageDialog(this, "Ocorreu um erro, tente novamente!\n");
    	        } catch (NullPointerException e){
    	            JOptionPane.showMessageDialog(this, "Estoque não localizado ou não existe!\n");
    	        }
        }
        
        private void clearFields() {    	
        	
        	txtIdProduto.setText("");
        	txtIdProduto.enable(true);
        	txtIdFornecedor.setText("");
        	txtIdFornecedor.enable(true);
        	txtNomeProduto.setText("");
        	txtNomeProduto.enable(true);
        	txtNomeFornecedor.setText("");
        	txtNomeFornecedor.enable(true);
        	txtQuantidade.setText("");
            chkAtivo.setSelected(false);
            txtLocalizar.setText("");
        }
    
	public static void main(String[] args) {
		EstoqueFrame frame = new EstoqueFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
