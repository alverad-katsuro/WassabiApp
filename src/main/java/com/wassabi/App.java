package com.wassabi;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
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
import com.wassabi.frontend.NovaVenda;
import com.wassabi.model.Venda;

//import net.miginfocom.swing.MigLayout;

/*
 * Está e classe principal que sera chamada para iniciar a aplicação
 */
public class App extends JFrame {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WassabiApp");
    private static App app;

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
        app = this;
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
		
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
            criaListaVendas(),
			new String[] {"Venda Nº", "Cliente", "Valor Total R$", "Data"}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		JPanel panel = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(scrollPane, BorderLayout.CENTER);
		contentPane.add(panel, BorderLayout.WEST);
		//panel.setLayout(new MigLayout("", "[149px][149px]", "[88px][88px][88px][88px][88px][88px]"));
		
		JButton B_novoPedido = new JButton("Novo Pedido");
        B_novoPedido.addActionListener(ev -> {
            this.setVisible(false);
            NovaVenda.getNovavenda().setVisible(true);
        });
		
		JButton B_novoProduto = new JButton("Novo Produto");
		
		JButton B_atualizarProduto = new JButton("Atualizar Produto");
		
		JButton B_deletarProduto = new JButton("Deletar Produto");
		
		JButton B_buscarProduto = new JButton("Buscar Produto");
		
		JButton B_atualizarCliente = new JButton("Atualizar Cliente");
		
		JButton B_novoCliente = new JButton("Novo Cliente");
		
		JButton B_novoCategoria = new JButton("Nova Categoria");
		
		JButton B_atualizarCategoria = new JButton("Atualizar Categoria");
		
		JButton B_deletarCategoria = new JButton("Excluir Categoria");
		
		JButton B_abrirCardapio = new JButton("Abrir Cardapio");
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		panel.add(B_novoPedido);
		panel.add(B_novoProduto);
		panel.add(B_atualizarProduto);
		panel.add(B_deletarProduto);
		panel.add(B_buscarProduto);
		panel.add(B_atualizarCliente);
		panel.add(B_novoCliente);
		panel.add(B_novoCategoria);
		panel.add(B_atualizarCategoria);
		panel.add(B_deletarCategoria);
		panel.add(B_abrirCardapio);
		
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

    public static App getApp() {
        if (app == null) {
            return new App();
        } else {
            return app;
        }
    }

    public static void setApp(App app) {
        App.app = app;
    }

    public void atualizaTable(){
        this.table.setFont(new Font("Arial", Font.PLAIN, 14));
		this.table.setModel(new DefaultTableModel(
            criaListaVendas(),
			new String[] {"Venda Nº", "Cliente", "Valor Total R$", "Data"}
		));
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    } 

    
}