import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TesteFrame extends JFrame{

	
	private JButton btnSalvar;
	
	public TesteFrame() {
		btnSalvar = new JButton("Salvar");
		
	}
	
	public static void main(String[] args) {
		TesteFrame frame = new TesteFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
