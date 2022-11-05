package com.wassabi.frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class CadastroProduto extends JPanel {
	private JTextField TF_produto_nome;
	private JTextField TF_produtoPreco;

	/**
	 * Create the panel.
	 */
	public CadastroProduto() {
		setFont(new Font("Arial", Font.PLAIN, 16));
		setBounds(100, 100, 1000, 606);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{500, 500, 0};
		gridBagLayout.rowHeights = new int[]{606, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		add(panel_2, gbc_panel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Categoria do Produto");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		JList list = new JList();
		list.setFont(new Font("Arial", Font.BOLD, 14));
		list.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setVisibleRowCount(10);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"asdsad", "sadsadsa", "asdasd", "asdasd"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setSelectedIndex(1);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(30)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(161)
							.addComponent(lblNewLabel_2_1)))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(80)
					.addComponent(lblNewLabel_2_1)
					.addGap(18)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 448, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(43, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		JTextArea TA_produtoDescricao = new JTextArea();
		TA_produtoDescricao.setColumns(30);
		TA_produtoDescricao.setRows(30);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Nome do Produto");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel);
		
		TF_produto_nome = new JTextField();
		TF_produto_nome.setFont(new Font("Arial", Font.PLAIN, 12));
		TF_produto_nome.setHorizontalAlignment(SwingConstants.CENTER);
		TF_produto_nome.setToolTipText("");
		TF_produto_nome.setColumns(50);
		panel.add(TF_produto_nome);
		
		JLabel lblNewLabel_2 = new JLabel("Preço do Produto");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel_2);
		
		TF_produtoPreco = new JTextField();
		TF_produtoPreco.setToolTipText("");
		TF_produtoPreco.setHorizontalAlignment(SwingConstants.CENTER);
		TF_produtoPreco.setFont(new Font("Arial", Font.PLAIN, 12));
		TF_produtoPreco.setColumns(50);
		panel.add(TF_produtoPreco);
		
		JLabel lblNewLabel_1 = new JLabel("Descrição do Produto");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel_1);
		panel.add(TA_produtoDescricao);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 2, 100, 0));
		
		JButton BT_salvar = new JButton("Salvar");
		panel_1.add(BT_salvar);
		
		JButton BT_cancelar = new JButton("Cancelar");
		panel_1.add(BT_cancelar);
	}

}
