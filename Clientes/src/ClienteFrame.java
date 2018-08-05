

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ClienteFrame extends JFrame {

    private JLabel lbNome, lbIdade, lbEndereco, lbCpf;
    private JTextField txtNome, txtEndereco, txtLocalizar, txtIdade, txtCpf;
    private JButton btnSalvar, btnAlterar, btnExcluir, btnClear, btnLocalizar;
    private JButton btnPrimeiro, btnProximo, btnAnterior, btnUltimo;

    private List<Cliente> contatoList = new ClienteController().listaContatos();
    private int registroAtual = 0;

    public ClienteFrame() {
        super("Clientes");
        Container tela = getContentPane();
        setLayout(null);
        lbNome = new JLabel("Nome");
        lbIdade = new JLabel("Idade");
        lbEndereco = new JLabel("Endereco");
        lbCpf = new JLabel("CPF");

        lbCpf.setBounds(10,5,240,15);
        lbNome.setBounds(10, 55, 240, 15);
        lbIdade.setBounds(10, 105, 240, 15);
        lbEndereco.setBounds(10, 155, 240, 15);
        

        lbNome.setForeground(Color.BLACK);
        lbIdade.setForeground(Color.BLACK);
        lbEndereco.setForeground(Color.BLACK);
        lbCpf.setForeground(Color.BLACK);

        lbNome.setFont(new Font("Courier New", Font.BOLD, 14));
        lbIdade.setFont(new Font("Courier New", Font.BOLD, 14));
        lbEndereco.setFont(new Font("Courier New", Font.BOLD, 14));
        lbCpf.setFont(new Font("Courier New", Font.BOLD, 14));

        tela.add(lbNome);
        tela.add(lbIdade);
        tela.add(lbEndereco);
        tela.add(lbCpf);
        txtNome = new JTextField();
        txtEndereco = new JTextField();
        txtIdade = new JTextField();
        txtCpf = new JTextField();

        txtCpf.setBounds(10, 20, 265, 20);
        txtNome.setBounds(10, 70, 265, 20);
        txtIdade.setBounds(10, 120, 265, 20);
        txtEndereco.setBounds(10, 180, 265, 20);
        

        tela.add(txtNome);
        tela.add(txtIdade);
        tela.add(txtEndereco);
        tela.add(txtCpf);

        btnSalvar = new JButton("Salvar");
        btnAlterar = new JButton("Alterar");
        btnExcluir = new JButton("Excluir");
        btnClear = new JButton("Limpar");
        btnPrimeiro = new JButton("|<");
        btnAnterior = new JButton("<<");
        btnProximo = new JButton(">>");
        btnUltimo = new JButton(">|");

        btnSalvar.setBounds(280, 25, 80, 20);
        btnAlterar.setBounds(280, 65, 80, 20);
        btnExcluir.setBounds(280, 105, 80, 20);

        tela.add(btnSalvar);
        tela.add(btnAlterar);
        tela.add(btnExcluir);

        btnPrimeiro.setBounds(10, 335, 50, 20);
        btnAnterior.setBounds(60, 335, 50, 20);
        btnClear.setBounds(110, 335, 75, 20);
        btnProximo.setBounds(185, 335, 50, 20);
        btnUltimo.setBounds(235, 335, 50, 20);

        tela.add(btnPrimeiro);
        tela.add(btnAnterior);
        tela.add(btnClear);
        tela.add(btnProximo);
        tela.add(btnUltimo);

        JLabel lbLocalizar = new JLabel("Localizar por CPF");
        lbLocalizar.setBounds(10, 360, 220, 20);

        txtLocalizar = new JTextField();
        txtLocalizar.setBounds(10, 380, 220, 20);

        btnLocalizar = new JButton("Ir");
        btnLocalizar.setBounds(230, 380, 55, 20);

        tela.add(lbLocalizar);
        tela.add(txtLocalizar);
        tela.add(btnLocalizar);


        setSize(400, 650);
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

        btnClear.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        clearFields();
                        registroAtual = 0;
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

        btnPrimeiro.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickPrimeiro();
                    }
                }
        );
        btnAnterior.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickAnterior();
                    }
                }
        );

        btnProximo.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickProximo();
                    }
                }
        );

        btnUltimo.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        onClickUltimo();
                    }
                }
        );
    }

    private void onClickUltimo() {
        registroAtual = contatoList.size() - 1;
        getValores(registroAtual);
    }

    private void onClickProximo() {
        if (registroAtual != contatoList.size() - 1) {
            getValores(++registroAtual);
        }
    }

    private void onClickAnterior() {
        if (registroAtual != 0) {
            getValores(--registroAtual);
        }
    }

    private void onClickPrimeiro() {
        registroAtual = 0;
        getValores(registroAtual);
    }

    private void getValores(int index) {
        if (index <= contatoList.size() - 1) {
            Cliente contatoAtual = contatoList.get(index);
            txtCpf.setText(contatoAtual.getCpf());
            txtNome.setText(contatoAtual.getNome());
            txtEndereco.setText(contatoAtual.getEndereco());
            txtIdade.setText(new Integer(contatoAtual.getIdade()).toString());  
        }
    }

    private void onClickAlterar() {
        ClienteController cc = new ClienteController();
        String cpf = contatoList.get(registroAtual).getCpf();
        try {
            cc.alterar(cpf, txtNome.getText(), new Integer(txtIdade.getText()).intValue(), txtEndereco.getText());
            JOptionPane.showMessageDialog(this, "Contato alterado com sucesso!");
            clearFields();
            contatoList = new ClienteController().listaContatos();            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel alterar contato!\n" + e.getLocalizedMessage());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Data possui formato inválido!\n" + e.getLocalizedMessage());
        }
    }

    private void onClickSalvar() {
        ClienteController cc = new ClienteController();
        try {
            cc.salvar(txtCpf.getText(),txtNome.getText(), new Integer(txtIdade.getText()).intValue(), txtEndereco.getText());
            JOptionPane.showMessageDialog(this, "Contato salvo com sucesso!");
            clearFields();
            contatoList = new ClienteController().listaContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel salvar contato!\n" + e.getLocalizedMessage());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Data possui formato inválido!\n" + e.getLocalizedMessage());
        }
    }

    private void onClickExcluir() {
        ClienteController cc = new ClienteController();
        String cpf = contatoList.get(registroAtual).getCpf();
        try {
            cc.excluir(cpf);
            JOptionPane.showMessageDialog(this, "Contato excluido com sucesso!");
            clearFields();
            contatoList = new ClienteController().listaContatos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Nao foi possivel excluir o contato!\n" + e.getLocalizedMessage());
        }
    }

    private void onClickLocalizar() {
        ClienteController cc = new ClienteController();
        try {
            Cliente c = cc.buscaContatoPorCpf(txtLocalizar.getText());
            txtCpf.setText(c.getCpf());
            txtNome.setText(c.getNome());
            txtEndereco.setText(c.getEndereco());
            txtIdade.setText(new Integer(c.getIdade()).toString());
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro, tente novamente!\n" + e.getLocalizedMessage());
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(this, "Contato não localizado ou não existe!\n" + e.getLocalizedMessage());
        }
    }   

    private void clearFields() {
    	txtCpf.setText("");
        txtNome.setText("");
        txtIdade.setText("");
        txtEndereco.setText("");
        txtLocalizar.setText("");
    }

    public static void main(String[] args) {
        ClienteFrame frame = new ClienteFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}