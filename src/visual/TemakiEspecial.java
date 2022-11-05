package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TemakiEspecial extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemakiEspecial frame = new TemakiEspecial();
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
	public TemakiEspecial() {
		setTitle("Temaki Especial");
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Temaki exotic");
		
		JCheckBox chckbxPromo = new JCheckBox("Temaki poró");
		
		JCheckBox chckbxPromo_1 = new JCheckBox("Temaki salmao especial");
		
		JCheckBox chckbxPromo_2 = new JCheckBox("Temaki Super Wasabi");
		
		JLabel lblNewLabel = new JLabel("Salmao, kani, shimeji");
		lblNewLabel.setIcon(new ImageIcon(TemakiEspecial.class.getResource("/imagens/temaki01.jpg")));
		
		JLabel lblSashimiDe = new JLabel("Salmao misturado com alho");
		lblSashimiDe.setIcon(new ImageIcon(TemakiEspecial.class.getResource("/imagens/temaki02.jpg")));
		
		JLabel lblNewLabel_2 = new JLabel("Salmao grelhado na casquinha");
		lblNewLabel_2.setIcon(new ImageIcon(TemakiEspecial.class.getResource("/imagens/temaki03.jpg")));
		
		JLabel lblHotDe = new JLabel("Salmao, camarao e kani");
		lblHotDe.setIcon(new ImageIcon(TemakiEspecial.class.getResource("/imagens/semfoto.jpg")));
		
		JLabel lblNewLabel_1 = new JLabel("R$ 41,50");
		
		JLabel lblNewLabel_1_1 = new JLabel("R$ 42,50");
		
		JLabel lblNewLabel_1_2 = new JLabel("R$ 43,50");
		
		JLabel lblNewLabel_1_3 = new JLabel("R$ 45,50");
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
