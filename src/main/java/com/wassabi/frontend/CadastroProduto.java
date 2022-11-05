package com.wassabi.frontend;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.wassabi.dao.CategoriaDAO;
import com.wassabi.dao.ProdutoDAO;
import com.wassabi.model.Categoria;
import com.wassabi.model.Produto;
import javax.swing.ListSelectionModel;

public class CadastroProduto extends JFrame {

	private JPanel contentPane;
	private JTextField produto_nome;
	private JTextField produto_preco;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroProduto frame = new CadastroProduto();
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
	public CadastroProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.BOLD, 14));
		
		produto_nome = new JTextField();
		produto_nome.setColumns(10);
		
		JLabel lblNome_1_1 = new JLabel("Preço");
		lblNome_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		produto_preco = new JTextField();
		produto_preco.setColumns(10);
		
		JLabel lblNome_1 = new JLabel("Categoria");
		lblNome_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		JList categoria_lista = new JList(CategoriaDAO.readCategorias().toArray());
		categoria_lista.setSelectedIndex(1);
		categoria_lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Object[] categorias = CategoriaDAO.readCategorias().toArray();
		
		JLabel lblNome_1_1_1 = new JLabel("Descrição");
		lblNome_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		
		JTextArea produto_descricao = new JTextArea();
		
		JButton B_salvar = new JButton("Salvar");
        B_salvar.addActionListener(ev -> {
            Produto produto = new Produto((Categoria)categoria_lista.getSelectedValue(), produto_nome.getText(), Double.parseDouble(produto_preco.getText()), produto_descricao.getText());
            ProdutoDAO.createProduto(produto);
            JOptionPane.showMessageDialog(this, "Dados Armazenados com sucesso", "Dados Gravados", JOptionPane.INFORMATION_MESSAGE);
        });
		
		JButton B_cancelar = new JButton("Cancelar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(181)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
								.addComponent(produto_nome, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblNome_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNome_1_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addComponent(produto_preco, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
									.addComponent(categoria_lista, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(175)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(produto_descricao, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome_1_1_1, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(300)
							.addComponent(B_salvar)
							.addGap(18)
							.addComponent(B_cancelar)))
					.addContainerGap(218, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNome)
					.addGap(3)
					.addComponent(produto_nome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(lblNome_1_1)
					.addGap(5)
					.addComponent(produto_preco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(lblNome_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(categoria_lista)
					.addGap(28)
					.addComponent(lblNome_1_1_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(produto_descricao, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(B_salvar)
						.addComponent(B_cancelar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
