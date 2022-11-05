package com.wassabi;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.wassabi.dao.VendaDAO;
import com.wassabi.frontend.CadastroCategoria;
import com.wassabi.model.Venda;

import net.miginfocom.swing.MigLayout;

/*
 * Está e classe principal que sera chamada para iniciar a aplicação
 */
public class App extends JFrame {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WassabiApp");

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		setResizable(false);
		setFont(new Font("Arial", Font.PLAIN, 16));
		setTitle("Wassabi App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 606);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu JM_inicio = new JMenu("Inicio");
		JM_inicio.setFont(new Font("Arial", Font.BOLD, 14));
		menuBar.add(JM_inicio);
		
		JMenu JM_cliente = new JMenu("Cliente");
		JM_cliente.setFont(new Font("Dialog", Font.BOLD, 14));
		menuBar.add(JM_cliente);
		
		JMenuItem cadastrarCliente = new JMenuItem("Cadastrar");
		cadastrarCliente.setFont(new Font("Dialog", Font.BOLD, 14));
		JM_cliente.add(cadastrarCliente);
		
		JMenu JM_cliente_1 = new JMenu("Pedidos");
		JM_cliente_1.setFont(new Font("Dialog", Font.BOLD, 14));
		menuBar.add(JM_cliente_1);
		
		JMenuItem cadastrarCliente_1 = new JMenuItem("Cadastrar");
		cadastrarCliente_1.setFont(new Font("Dialog", Font.BOLD, 14));
		JM_cliente_1.add(cadastrarCliente_1);
		
		JMenu JM_cliente_1_1 = new JMenu("Produtos");
		JM_cliente_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		menuBar.add(JM_cliente_1_1);
		
		JMenuItem cadastrarCliente_1_1 = new JMenuItem("Cadastrar");
		cadastrarCliente_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		JM_cliente_1_1.add(cadastrarCliente_1_1);
		
		JMenu JM_cliente_1_1_1 = new JMenu("Categorias");
		JM_cliente_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		menuBar.add(JM_cliente_1_1_1);
		
		JMenuItem cadastrarCliente_1_1_1 = new JMenuItem("Cadastrar");
		cadastrarCliente_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		JM_cliente_1_1_1.add(cadastrarCliente_1_1_1);
		
		JMenu JM_cliente_1_1_1_1 = new JMenu("Cardapio");
		JM_cliente_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		menuBar.add(JM_cliente_1_1_1_1);
		
		JMenuItem cadastrarCliente_1_1_1_1 = new JMenuItem("Cadastrar");
		cadastrarCliente_1_1_1_1.setFont(new Font("Dialog", Font.BOLD, 14));
		JM_cliente_1_1_1_1.add(cadastrarCliente_1_1_1_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
            criaListaVendas(),
			new String[] {"Venda Nº", "Cliente", "Valor Total R$", "Data"}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[149px][149px]", "[88px][88px][88px][88px][88px][88px]"));
		
		JButton B_novoPedido = new JButton("Novo Pedido");
		panel.add(B_novoPedido, "cell 0 0,grow");
		
		JButton B_novoProduto = new JButton("Novo Produto");
		panel.add(B_novoProduto, "cell 1 0,grow");
		
		JButton B_atualizarProduto = new JButton("Atualizar Produto");
		panel.add(B_atualizarProduto, "cell 0 1,grow");
		
		JButton B_deletarProduto = new JButton("Deletar Produto");
		panel.add(B_deletarProduto, "cell 1 1,grow");
		
		JButton B_buscarProduto = new JButton("Buscar Produto");
		panel.add(B_buscarProduto, "cell 0 2,grow");
		
		JButton B_atualizarCliente = new JButton("Atualizar Cliente");
		panel.add(B_atualizarCliente, "cell 1 2,grow");
		
		JButton B_novoCliente = new JButton("Novo Cliente");
		panel.add(B_novoCliente, "cell 0 3,grow");
		
		JButton B_novoCategoria = new JButton("Nova Categoria");
        B_novoCategoria.addActionListener(ev -> {
            System.out.println("aaaaaaaaaaa");
            this.contentPane.removeAll();
            JPanel cadastro = new CadastroCategoria();
            this.contentPane = cadastro;
            this.contentPane.revalidate();
            this.contentPane.repaint();
        });
		panel.add(B_novoCategoria, "cell 1 3,grow");
		
		JButton B_atualizarCategoria = new JButton("Atualizar Categoria");
		panel.add(B_atualizarCategoria, "cell 0 4,grow");
		
		JButton B_deletarCategoria = new JButton("Excluir Categoria");
		panel.add(B_deletarCategoria, "cell 1 4,grow");
		
		JButton B_abrirCardapio = new JButton("Abrir Cardapio");
		panel.add(B_abrirCardapio, "cell 0 5,grow");
		
	}
	
	public Object[][] criaListaVendas() {
		List<Venda> vendas = VendaDAO.readVendas();
		Object [][] matriz = new Object[vendas.size()][4];
        for (int i = 0; i < vendas.size(); i++) {
            Venda venda = vendas.get(i);
            matriz[i][0] = venda.getVendaId();
            matriz[i][1] = venda.getCliente().getClienteNomeCompleto();
            matriz[i][2] = venda.getVendaTotal();
            matriz[i][3] = LocalDateTime.ofInstant(venda.getVendaData().toInstant(), venda.getVendaData().getTimeZone().toZoneId()).toString().replace("T", " ");
        }
        return matriz;
	}

	/** 
     * @return EntityManagerFactory
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    } 
}
