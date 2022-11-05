package visual;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Promocao extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Promocao frame = new Promocao();
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
	public Promocao() {
		setTitle("Promoção");
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Promo 01");
		
		JCheckBox chckbxPromo = new JCheckBox("Promo 02");
		
		JCheckBox chckbxPromo_1 = new JCheckBox("Promo 03");
		
		JCheckBox chckbxPromo_2 = new JCheckBox("Promo 04");
		
		JLabel lblNewLabel = new JLabel("10 Hot de salmao grelhado com batata doce");
		lblNewLabel.setIcon(new ImageIcon(Promocao.class.getResource("/imagens/promo01.jpg")));
		
		JLabel lblSashimiDe = new JLabel("4 Sashimi de Salmao, 2 Gunkas Maçaricado");
		lblSashimiDe.setIcon(new ImageIcon(Promocao.class.getResource("/imagens/promo02.jpg")));
		
		JLabel lblNewLabel_2 = new JLabel("5 Makimono skin com pesto de jambu");
		lblNewLabel_2.setIcon(new ImageIcon(Promocao.class.getResource("/imagens/promo03.jpg")));
		
		JLabel lblHotDe = new JLabel("3 Gunkan com patê de polvo");
		lblHotDe.setIcon(new ImageIcon(Promocao.class.getResource("/imagens/Promo04.jpg")));
		
		JLabel lblNewLabel_1 = new JLabel("R$ 40.90");
		
		JLabel lblNewLabel_1_1 = new JLabel("R$ 53,90");
		
		JLabel lblNewLabel_1_2 = new JLabel("R$ 49,90");
		
		JLabel lblNewLabel_1_3 = new JLabel("R$ 48,50");
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
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_1_3))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_1_1))
						.addComponent(chckbxPromo, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSashimiDe, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addComponent(chckbxPromo_2)
						.addComponent(lblHotDe, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
					.addGap(41))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(chckbxPromo)
						.addComponent(chckbxNewCheckBox))
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
