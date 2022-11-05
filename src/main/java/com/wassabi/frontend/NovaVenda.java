package com.wassabi.frontend;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.wassabi.App;
import com.wassabi.dao.ClienteDAO;
import com.wassabi.dao.ProdutoDAO;
import com.wassabi.dao.VendaDAO;
import com.wassabi.model.Cliente;
import com.wassabi.model.Produto;
import com.wassabi.model.Venda;

public class NovaVenda extends JFrame {

	private JPanel contentPane;
	private JTextField produto_quantidade;
    private static NovaVenda novavenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovaVenda frame = new NovaVenda();
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
	public NovaVenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblProdutos = new JLabel("Produtos");
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		
		produto_quantidade = new JTextField();
		produto_quantidade.setColumns(10);


		JList lista_clientes = new JList(ClienteDAO.readClientes().toArray());
		lista_clientes.setSelectedIndex(0);
		JList lista_produtos = new JList(ProdutoDAO.readProdutos().toArray());
		lista_produtos.setSelectedIndex(0);

		JButton btnFinalizar = new JButton("Finalizar");
        btnFinalizar.addActionListener(ev -> {
            Venda venda = new Venda((Cliente) lista_clientes.getSelectedValue());
            if (produto_quantidade.getText().length() == 0) {
                venda.addProduto((Produto)lista_produtos.getSelectedValue(), 1);
            } else {
                venda.addProduto((Produto)lista_produtos.getSelectedValue(), Integer.parseInt(produto_quantidade.getText()));
            }
            VendaDAO.createVenda(venda);
            JOptionPane.showMessageDialog(this, "Venda Realizada com sucesso");
            App.getApp().setVisible(true);
            App.getApp().atualizaTable();
        });
		
		JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(ev -> {
            setVisible(false);
            dispose();
            App.getApp().setVisible(true);
        });
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblClientes = new JLabel("Clientes");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(98)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblClientes)
						.addComponent(produto_quantidade, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuantidade)
						.addComponent(lblProdutos)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(193, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(242, Short.MAX_VALUE)
					.addComponent(btnFinalizar)
					.addGap(49)
					.addComponent(btnCancelar)
					.addGap(282))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addComponent(lblProdutos)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblQuantidade)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(produto_quantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblClientes)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFinalizar)
						.addComponent(btnCancelar))
					.addGap(54))
		);
		
		
		
		scrollPane_1.setViewportView(lista_clientes);
		
		scrollPane.setViewportView(lista_produtos);
		contentPane.setLayout(gl_contentPane);
	}

    public static NovaVenda getNovavenda() {
        if (novavenda == null) {
            return new NovaVenda();
        } else {
            return novavenda;
        }
    }

    public static void setNovavenda(NovaVenda novavenda) {
        NovaVenda.novavenda = novavenda;
    }
    
}
