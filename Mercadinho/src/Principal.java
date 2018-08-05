import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Principal extends JFrame{
	
	private JLabel lblProjeto, lblAutores1, lblAutores2, lblFaculAno;
	
	public Principal() {
		setTitle("MERCADINHO - MENU PRINCIPAL");
		setSize(500,500);
		Container tela = getContentPane();
        setLayout(null);
        
		lblProjeto = new JLabel("PROJETO MERCADINHO");
		lblProjeto.setBounds(100,100,300,100);
		lblProjeto.setForeground(Color.BLACK);
		lblProjeto.setFont(new Font("Courier New", Font.BOLD, 24));
		
		lblAutores1 = new JLabel("Autor: Raquel Figueiredo RA: 21910");
		lblAutores1.setBounds(100,200,300,100);
		lblAutores1.setForeground(Color.BLACK);
		lblAutores1.setFont(new Font("Courier New", Font.BOLD, 12));
		
		lblAutores2 = new JLabel("Autor: Nícholas Guaratini RA: 21912");
		lblAutores2.setBounds(100,220,300,100);
		lblAutores2.setForeground(Color.BLACK);
		lblAutores2.setFont(new Font("Courier New", Font.BOLD, 12));
		
		lblFaculAno = new JLabel("FACCAMP - @2017 - 7º Semestre - Ciências da Computação");
		lblFaculAno.setBounds(50,360,500,100);
		lblFaculAno.setForeground(Color.BLACK);
		lblFaculAno.setFont(new Font("Courier New", Font.BOLD, 12));
		
		
		tela.add(lblProjeto);
		tela.add(lblAutores1);
		tela.add(lblAutores2);
		tela.add(lblFaculAno);
		//CRIA A BARRA DE MENUS
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//ADICIONA UM MENU A BARRA DE MENUS
		JMenu cadastroMenu = new JMenu("Cadastro");
		menuBar.add(cadastroMenu);
		
		//ADICIONA O ITEM NO MENU CRIADO
		JMenuItem produtosMenu = new JMenuItem("Cadastro de Produtos");
		JMenuItem fornecedoresMenu = new JMenuItem("Cadastro de Fornecedores");
		JMenuItem estoqueMenu = new JMenuItem("Cadastro de Estoque");
		JMenuItem sairMenu = new JMenuItem("Sair");
		cadastroMenu.add(produtosMenu);
		cadastroMenu.add(fornecedoresMenu);
		cadastroMenu.add(estoqueMenu);
		cadastroMenu.addSeparator();
		cadastroMenu.add(sairMenu);
		
		produtosMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProdutoFrame produtoFrame = new ProdutoFrame();
				
			}
		});
		
		fornecedoresMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FornecedorFrame fornecedorFrame = new FornecedorFrame();
				
			}
		});
		
		estoqueMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EstoqueFrame estoqueFrame = new EstoqueFrame();
				
			}
		});
		
		sairMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		Principal principal = new Principal();
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		principal.setVisible(true);
    }
}
