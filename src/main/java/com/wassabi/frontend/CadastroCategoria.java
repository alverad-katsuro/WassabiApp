package com.wassabi.frontend;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class CadastroCategoria extends JPanel {
	private JTextField TF_categoria_nome;

	/**
	 * Create the panel.
	 */
	public CadastroCategoria() {
		setFont(new Font("Arial", Font.PLAIN, 16));
		setBounds(100, 100, 1000, 606);
		setLayout(new MigLayout("", "[250px][500px:n][250px:250px]", "[][][][][::500px][200px]"));
		
		JLabel lblNewLabel = new JLabel("Nome da Categoria");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		add(lblNewLabel, "cell 1 1,alignx left,aligny center");
		
		TF_categoria_nome = new JTextField();
		TF_categoria_nome.setFont(new Font("Arial", Font.PLAIN, 12));
		TF_categoria_nome.setHorizontalAlignment(SwingConstants.CENTER);
		TF_categoria_nome.setToolTipText("");
		add(TF_categoria_nome, "cell 1 2,alignx center,aligny center");
		TF_categoria_nome.setColumns(50);
		
		JLabel lblNewLabel_1 = new JLabel("Descrição Categoria");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		add(lblNewLabel_1, "flowy,cell 1 4,alignx left,aligny center");
		
		JTextArea TA_categoria_descricao = new JTextArea();
		TA_categoria_descricao.setColumns(50);
		TA_categoria_descricao.setRows(30);
		add(TA_categoria_descricao, "cell 1 4,alignx center,aligny center");
		
		JButton BT_salvar = new JButton("Salvar");
		add(BT_salvar, "flowx,cell 1 5,alignx center,aligny center");
		
		JButton BT_cancelar = new JButton("Cancelar");
		add(BT_cancelar, "cell 1 5,alignx center,aligny center");
	}

}
