package visual;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.BorderLayout;

public class Entradas extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entradas frame = new Entradas();
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
	public Entradas() {
		setTitle("Entradas");
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Salmão em consumer");
		
		JCheckBox chckbxPromo = new JCheckBox("Lula em anéis Grelhada");
		
		JCheckBox chckbxPromo_1 = new JCheckBox("Bolinhas de Salmao fritas");
		
		JCheckBox chckbxPromo_2 = new JCheckBox("Camarao empanado");
		
		JLabel lblNewLabel = new JLabel("Salmao em consumer");
		lblNewLabel.setIcon(new ImageIcon(Entradas.class.getResource("/imagens/entrada01.jpg")));
		
		JLabel lblSashimiDe = new JLabel("4 Sashimi de Salmao, 2 Gunkas Maçaricado");
		lblSashimiDe.setIcon(new ImageIcon(Entradas.class.getResource("/imagens/entrada02.jpg")));
		
		JLabel lblNewLabel_2 = new JLabel("10 unidades de salmao");
		lblNewLabel_2.setIcon(new ImageIcon(Entradas.class.getResource("/imagens/entada03.jpg")));
		
		JLabel lblHotDe = new JLabel("Camarao empanado frito");
		lblHotDe.setIcon(new ImageIcon(Entradas.class.getResource("/imagens/entrada04.jpg")));
		
		JLabel lblNewLabel_1 = new JLabel("R$ 39.00");
		
		JLabel lblNewLabel_1_1 = new JLabel("R$ 41,00");
		
		JLabel lblNewLabel_1_2 = new JLabel("R$ 28,00");
		
		JLabel lblNewLabel_1_3 = new JLabel("R$ 43,50");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(chckbxNewCheckBox)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxPromo_1)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_1_2)))
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_1_3))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_1_1))
						.addComponent(lblSashimiDe, GroupLayout.PREFERRED_SIZE, 126, Short.MAX_VALUE)
						.addComponent(chckbxPromo_2)
						.addComponent(lblHotDe, GroupLayout.PREFERRED_SIZE, 126, Short.MAX_VALUE)
						.addComponent(chckbxPromo))
					.addGap(32))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(chckbxNewCheckBox)
						.addComponent(chckbxPromo))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSashimiDe, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_1_1))
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chckbxPromo_1)
						.addComponent(chckbxPromo_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHotDe, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2)
						.addComponent(lblNewLabel_1_3))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

	}
}
