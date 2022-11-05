package com.wassabi.frontend;

import java.awt.Font;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;

public class CadastroProduto extends JPanel {
	private JTextField TF_produto_nome;
	private JTextField TF_produtoPreco;

	/**
	 * Create the panel.
	 */
	public CadastroProduto() {
		setFont(new Font("Arial", Font.PLAIN, 16));
		setBounds(100, 100, 1000, 606);
		setLayout(new MigLayout("", "[300px][500px]", "[606px]"));
		
		JList list = new JList();
		add(list, "cell 0 0,grow");
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
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
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 0,grow");
		
		JTextArea TA_produtoDescricao = new JTextArea();
		TA_produtoDescricao.setColumns(30);
		TA_produtoDescricao.setRows(30);
		
		JLabel lblNewLabel_2 = new JLabel("Preço do Produto");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		
		TF_produtoPreco = new JTextField();
		TF_produtoPreco.setToolTipText("");
		TF_produtoPreco.setHorizontalAlignment(SwingConstants.CENTER);
		TF_produtoPreco.setFont(new Font("Arial", Font.PLAIN, 12));
		TF_produtoPreco.setColumns(50);
		
		JLabel lblNewLabel_2_1 = new JLabel("Categoria do Produto");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Nome do Produto");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel, "name_56321835724262");
		
		TF_produto_nome = new JTextField();
		TF_produto_nome.setFont(new Font("Arial", Font.PLAIN, 12));
		TF_produto_nome.setHorizontalAlignment(SwingConstants.CENTER);
		TF_produto_nome.setToolTipText("");
		TF_produto_nome.setColumns(50);
		panel.add(TF_produto_nome, "name_56321849123832");
		panel.add(TA_produtoDescricao, "name_56321862863120");
		panel.add(lblNewLabel_2, "name_56321877236510");
		panel.add(TF_produtoPreco, "name_56321888266549");
		panel.add(lblNewLabel_2_1, "name_56321897405423");
		panel.add(scrollPane, "name_56321904887875");
		
		JLabel lblNewLabel_1 = new JLabel("Descrição do Produto");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel_1, "name_56321912346102");
		
		JButton BT_salvar = new JButton("Salvar");
		panel.add(BT_salvar, "name_56321919856695");
		
		JButton BT_cancelar = new JButton("Cancelar");
		panel.add(BT_cancelar, "name_56321927767148");
	}

}
