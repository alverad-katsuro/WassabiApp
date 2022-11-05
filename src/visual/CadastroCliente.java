package visual;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CadastroCliente extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroCliente() {
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("CADASTRO CLIENTE");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(159)
					.addComponent(lblNewLabel_1)
					.addContainerGap(176, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Concluir");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(btnNewButton_3);
		
		JPanel panel_1_1 = new JPanel();
		getContentPane().add(panel_1_1, BorderLayout.WEST);
		
		JTextPane txtpnNomeCompleto = new JTextPane();
		txtpnNomeCompleto.setSize(100, 200);
		txtpnNomeCompleto.setText("Nome completo");
		
		JLabel lblNewLabel = new JLabel("Nome completo");
		
		JLabel lblCpf = new JLabel("CPF");
		
		JTextPane txtpnNomeCompleto_1 = new JTextPane();
		txtpnNomeCompleto_1.setText(". . . -");
		
		JLabel lblEndereo = new JLabel("Endereço");
		
		JTextPane txtpnRua = new JTextPane();
		txtpnRua.setText("Rua");
		
		JTextPane txtpnN = new JTextPane();
		txtpnN.setText("Nº");
		
		JTextPane txtpnBairro = new JTextPane();
		txtpnBairro.setText("Bairro");
		
		JLabel lblCarto = new JLabel("Cartão");
		
		JTextPane txtpnNCarto = new JTextPane();
		txtpnNCarto.setText("Nº Cartão");
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGap(173)
					.addComponent(lblNewLabel)
					.addContainerGap(203, Short.MAX_VALUE))
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGap(200)
					.addComponent(lblCpf, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(210, Short.MAX_VALUE))
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGap(187)
					.addComponent(lblEndereo, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(203, Short.MAX_VALUE))
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGap(186)
					.addComponent(lblCarto, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(204, Short.MAX_VALUE))
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addContainerGap(53, Short.MAX_VALUE)
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtpnNomeCompleto_1, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnNomeCompleto, GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1_1.createSequentialGroup()
							.addGap(19)
							.addComponent(txtpnRua, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtpnN, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtpnBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(86))
				.addGroup(Alignment.LEADING, gl_panel_1_1.createSequentialGroup()
					.addGap(103)
					.addComponent(txtpnNCarto, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(137, Short.MAX_VALUE))
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_1.createSequentialGroup()
					.addGap(17)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnNomeCompleto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCpf)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnNomeCompleto_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEndereo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1_1.createSequentialGroup()
							.addComponent(txtpnRua, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCarto))
						.addComponent(txtpnBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtpnNCarto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_1_1.setLayout(gl_panel_1_1);

	}
}
