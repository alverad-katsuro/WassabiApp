package com.wassabi.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Venda generated by hbm2java
 */
@Entity
@Table(name = "Venda", catalog = "wassabi")
public class Venda implements java.io.Serializable {

	private Integer vendaId;
	private Cliente cliente;
	private double vendaTotal = 0.0;
    private Calendar vendaData;
	private Set<VendaHasProduto> vendaHasProdutos = new HashSet<VendaHasProduto>(0);

	public Venda() {
	}

	public Venda(Cliente cliente) {
		this.cliente = cliente;
        this.vendaData = Calendar.getInstance();
	}

	public Venda(Cliente cliente, double vendaTotal, Set<VendaHasProduto> vendaHasProdutos) {
		this.cliente = cliente;
		this.vendaTotal = vendaTotal;
		this.vendaHasProdutos = vendaHasProdutos;
        this.vendaData = Calendar.getInstance();
	}

	
    /** 
     * @return Integer
     */
    @Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "venda_id", unique = true, nullable = false)
	public Integer getVendaId() {
		return this.vendaId;
	}

	
    /** 
     * @param vendaId
     */
    public void setVendaId(Integer vendaId) {
		this.vendaId = vendaId;
	}

	
    /** 
     * @return Cliente
     */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "venda_cliente", nullable = false)
	public Cliente getCliente() {
		return this.cliente;
	}

	
    /** 
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
    /** 
     * @return double
     */
    @Column(name = "venda_total", nullable = false, precision = 30)
	public double getVendaTotal() {
		return this.vendaTotal;
	}

	
    /** 
     * @param vendaTotal
     */
    public void setVendaTotal(double vendaTotal) {
		this.vendaTotal = vendaTotal;
	}

    
    /** 
     * @return Date
     */
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "venda_data", nullable = false, length = 19)
	public Calendar getVendaData() {
		return this.vendaData;
	}

	
    /** 
     * @param vendaData
     */
    public void setVendaData(Calendar vendaData) {
		this.vendaData = vendaData;
	}

	
    /** 
     * @return Set<VendaHasProduto>
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<VendaHasProduto> getVendaHasProdutos() {
		return this.vendaHasProdutos;
	}

	
    /** 
     * @param vendaHasProdutos
     */
    public void setVendaHasProdutos(Set<VendaHasProduto> vendaHasProdutos) {
		this.vendaHasProdutos = vendaHasProdutos;
	}


    
    /** 
     * Adiciona um Produto a venda e atualiza o valor da venda.
     * @param produto
     */
    public void addProduto(VendaHasProduto produto){
        produto.setVenda(this);
        this.vendaHasProdutos.add(produto);
        this.vendaTotal += produto.getProduto().getProdutoPreco() * produto.getQuantidade();
    }


    
    /** 
     * Adiciona um Produto a venda e atualiza o valor da venda.
     * @param produto
     */
    public void addProduto(Produto produto){
        VendaHasProduto vhpi = new VendaHasProduto(produto, 1);
        vhpi.setVenda(this);
        this.vendaHasProdutos.add(vhpi);
        this.vendaTotal += produto.getProdutoPreco();
    }


    
    /** 
     * Adiciona um Produto a venda e atualiza o valor da venda.
     * @param produto
     * @param quantidade
     */
    public void addProduto(Produto produto, int quantidade){
        VendaHasProduto vhpi = new VendaHasProduto(produto, quantidade);
        vhpi.setVenda(this);
        this.vendaHasProdutos.add(vhpi);
        this.vendaTotal += produto.getProdutoPreco() * quantidade;
    }

    /*
     * Esta função tem como objetivo ser uma rotina interna do VendaDAO.create pois a ID do VendaHasProduto não está atualizando.
     */
    public void updateProdutosID(){
        this.vendaHasProdutos.forEach(produto -> {
            produto.getId().setVendaId(this.vendaId);
        });
    }
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Venda [vendaId=" + vendaId + ", cliente=" + cliente + ", vendaTotal=" + vendaTotal + "]";
    }

}
