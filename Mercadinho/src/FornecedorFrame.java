

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class FornecedorFrame extends JFrame {

    private JLabel lbIdFornecedor, lbCnpj, lbRazaosocial, lbNomefantasia, lbBairro, lbCidade, lbEstado, lbCep;
    private JTextField txtIdFornecedor, txtCNPJ, txtRazaosocial, txtNomefantasia, txtBairro, txtCidade, txtEstado, txtCep, txtLocalizar;
    private JButton btnSalvar, btnAlterar, btnExcluir, btnClear, btnLocalizar;
    private JButton btnPrimeiro, btnProximo, btnAnterior, btnUltimo;

    private List<Fornecedor> fornecedorList = new FornecedorController().listaContatos();
    private int registroAtual = 0;

    public FornecedorFrame() {
        super("Fornecedores");
        Container tela = getContentPane();
        setLayout(null);
        
        lbIdFornecedor = new JLabel("Id Fornecedor:");
        lbCnpj = new JLabel("CNPJ");
        lbRazaosocial = new JLabel("Razão Social");
        lbNomefantasia = new JLabel("Nome Fantasia");
        lbBairro = new JLabel("Bairro");
        lbCidade = new JLabel("Cidade");
        lbEstado = new JLabel("Estado");
        lbCep = new JLabel("CEP");

        lbIdFornecedor.setBounds(10,55,240,15);
        lbCnpj.setBounds(10,105,240,15);
        lbRazaosocial.setBounds(10, 155, 240, 15);
        lbNomefantasia.setBounds(10, 205, 240, 15);
        lbBairro.setBounds(10, 255, 240, 15);
        lbCidade.setBounds(10, 305, 240, 15);
        lbEstado.setBounds(10, 355, 240, 15);
        lbCep.setBounds(10, 405, 240, 15);

        lbIdFornecedor.setForeground(Color.BLACK);
        lbCnpj.setForeground(Color.BLACK);
        lbRazaosocial.setForeground(Color.BLACK);
        lbNomefantasia.setForeground(Color.BLACK);
        lbBairro.setForeground(Color.BLACK);
        lbCidade.setForeground(Color.BLACK);
        lbEstado.setForeground(Color.BLACK);
        lbCep.setForeground(Color.BLACK);

        lbIdFornecedor.setFont(new Font("Courier New", Font.BOLD, 14));
        lbCnpj.setFont(new Font("Courier New", Font.BOLD, 14));
        lbRazaosocial.setFont(new Font("Courier New", Font.BOLD, 14));
        lbNomefantasia.setFont(new Font("Courier New", Font.BOLD, 14));
        lbBairro.setFont(new Font("Courier New", Font.BOLD, 14));
        lbCidade.setFont(new Font("Courier New", Font.BOLD, 14));
        lbEstado.setFont(new Font("Courier New", Font.BOLD, 14));
        lbCep.setFont(new Font("Courier New", Font.BOLD, 14));

        tela.add(lbIdFornecedor);
        tela.add(lbCnpj);
        tela.add(lbRazaosocial);
        tela.add(lbNomefantasia);
        tela.add(lbBairro);
        tela.add(lbCidade);
        tela.add(lbEstado);
        tela.add(lbCep);
        
        txtIdFornecedor = new JTextField();
        txtCNPJ = new JTextField();
        txtRazaosocial = new JTextField();
        txtNomefantasia = new JTextField();
        txtBairro = new JTextField();
        txtCidade = new JTextField();
        txtEstado = new JTextField();
        txtCep = new JTextField();

        txtIdFornecedor.setBounds(10, 70, 265, 20);
        txtCNPJ.setBounds(10, 120, 265, 20);
        txtRazaosocial.setBounds(10, 170, 265, 20);
        txtNomefantasia.setBounds(10, 220, 265, 20);
        txtBairro.setBounds(10, 270, 265, 20);
        txtCidade.setBounds(10, 320, 265, 20);
        txtEstado.setBounds(10, 370, 265, 20);
        txtCep.setBounds(10, 420, 265, 20);
        
        tela.add(txtIdFornecedor);
        tela.add(txtCNPJ);
        tela.add(txtRazaosocial);
        tela.add(txtNomefantasia);
        tela.add(txtBairro);
        tela.add(txtCidade);
        tela.add(txtEstado);
        tela.add(txtCep);

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
        
        JLabel lbLocalizar = new JLabel("Localizar por CNPJ");
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
        
        btnAlterar.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickAlterar();
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
        
        btnSalvar.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickSalvar();
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
    }

    private void onClickExcluir() {
    	FornecedorController ff = new FornecedorController();
    	int idForn = Integer.parseInt(txtIdFornecedor.getText());
        try {
            ff.excluir(idForn);
            JOptionPane.showMessageDialog(this, "Fornecedor excluido com sucesso!");
            clearFields();
            fornecedorList = new FornecedorController().listaContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel excluir o contato!\n" + e.getLocalizedMessage());
        }
    }
   
    private void onClickSalvar() {
    	FornecedorController ff = new FornecedorController();
        try {
            ff.salvar(Integer.parseInt(txtIdFornecedor.getText()), txtCNPJ.getText(), txtRazaosocial.getText(), txtNomefantasia.getText(), 
    				txtBairro.getText(), txtCidade.getText(), txtEstado.getText(), txtCep.getText());
            
            JOptionPane.showMessageDialog(this, "Fornecedor salvo com sucesso!");
            //Limpa o codigo do texto localizar
            clearFields();
            fornecedorList = new FornecedorController().listaContatos();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel salvar o fornecedor!\n" + e.getLocalizedMessage());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Data possui formato inválido!\n" + e.getLocalizedMessage());
        }
    }
    
    private void onClickAlterar() {
    	FornecedorController ff = new FornecedorController();
        int idForn = (fornecedorList.get(registroAtual).getIdFornecedor());
        try {
        	ff.alterar(Integer.parseInt(txtIdFornecedor.getText()), txtCNPJ.getText(), txtRazaosocial.getText(), txtNomefantasia.getText(), 
    				txtBairro.getText(), txtCidade.getText(), txtEstado.getText(), txtCep.getText());
    		
            JOptionPane.showMessageDialog(this, "Fornecedor alterado com sucesso!");
            
            //Limpa o codigo do texto localizar
            clearFields();
            fornecedorList = new FornecedorController().listaContatos();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel alterar o fornecedor!\n" + e.getLocalizedMessage());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Dados possui formato inválido!\n" + e.getLocalizedMessage());
        }
    }
    
    private void onClickLocalizar() {
    	FornecedorController ff = new FornecedorController();
    	  try {
              Fornecedor f = ff.buscaContatoPorCNPJ(txtLocalizar.getText());
              //Limpa o codigo do texto localizar
              txtLocalizar.setText("");
              
              txtIdFornecedor.setText(Integer.toString(f.getIdFornecedor()));
              txtIdFornecedor.enable(false);
              txtCNPJ.setText(f.getCNPJ());
              txtRazaosocial.setText(f.getRazaoSocial());
      		  txtNomefantasia.setText(f.getNomeFantasia());
      		  txtBairro.setText(f.getBairro());
      		  txtCidade.setText(f.getCidade());
      		  txtEstado.setText(f.getEstado());
      		  txtCep.setText(f.getCEP());
          	  
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(this, "Ocorreu um erro, tente novamente!\n");
	        } catch (NullPointerException e){
	            JOptionPane.showMessageDialog(this, "Fornecedor não localizado ou não existe!\n");
	        }
    }
	    

    private void clearFields() {    	
    	txtIdFornecedor.setText("");
    	txtIdFornecedor.enable(true);
        txtCNPJ.setText("");
        txtRazaosocial.setText("");
        txtNomefantasia.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        txtEstado.setText("");
        txtCep.setText("");
        txtLocalizar.setText("");
    }

    public static void main(String[] args) {
        FornecedorFrame frame = new FornecedorFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}