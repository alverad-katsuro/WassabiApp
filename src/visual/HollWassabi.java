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

public class HollWassabi extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HollWassabi frame = new HollWassabi();
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
	public HollWassabi() {
		setTitle("Holl Wassabi");
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Wasabi holl met");
		
		JCheckBox chckbxPromo = new JCheckBox("Holl tartar de salmao met");
		
		JCheckBox chckbxPromo_1 = new JCheckBox("Holl tartar de salmao");
		
		JCheckBox chckbxPromo_2 = new JCheckBox("Kasai met");
		
		JLabel lblNewLabel = new JLabel("5 peças de holl de salmao");
		lblNewLabel.setIcon(new ImageIcon(HollWassabi.class.getResource("/imagens/semfoto.jpg")));
		
		JLabel lblSashimiDe = new JLabel("5 peças de holl de salmao");
		lblSashimiDe.setIcon(new ImageIcon(HollWassabi.class.getResource("/imagens/semfoto.jpg")));
		
		JLabel lblNewLabel_2 = new JLabel("10 peças de holl de salmao");
		lblNewLabel_2.setIcon(new ImageIcon(HollWassabi.class.getResource("/imagens/hollwasabi03.jpg")));
		
		JLabel lblHotDe = new JLabel("5 peças de holl de camarao");
		lblHotDe.setIcon(new ImageIcon(TemakiEspecial.class.getResource("/imagens/semfoto.jpg")));
		
		JLabel lblNewLabel_1 = new JLabel("R$ 23,50");
		
		JLabel lblNewLabel_1_1 = new JLabel("R$ 24,50");
		
		JLabel lblNewLabel_1_2 = new JLabel("R$ 46,50");
		
		JLabel lblNewLabel_1_3 = new JLabel("R$ 23,50");
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
