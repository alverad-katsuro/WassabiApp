package model;
// Generated 4 de nov. de 2022 15:43:42 by Hibernate Tools 4.3.6.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * VendaHasProduto generated by hbm2java
 */
@Entity
@Table(name = "venda_has_produto", catalog = "wassabi")
public class VendaHasProduto implements java.io.Serializable {

	private VendaHasProdutoId id;
	private Produto produto;
	private Venda venda;
	private int quantidade;

	public VendaHasProduto() {
	}

	public VendaHasProduto(VendaHasProdutoId id, Produto produto, Venda venda, int quantidade) {
		this.id = id;
		this.produto = produto;
		this.venda = venda;
		this.quantidade = quantidade;
	}

	
    /** 
     * @return VendaHasProdutoId
     */
    @EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "vendaId", column = @Column(name = "venda_id", nullable = false)),
			@AttributeOverride(name = "produtoId", column = @Column(name = "produto_id", nullable = false)) })
	public VendaHasProdutoId getId() {
		return this.id;
	}

	
    /** 
     * @param id
     */
    public void setId(VendaHasProdutoId id) {
		this.id = id;
	}

	
    /** 
     * @return Produto
     */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produto_id", nullable = false, insertable = false, updatable = false)
	public Produto getProduto() {
		return this.produto;
	}

	
    /** 
     * @param produto
     */
    public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
    /** 
     * @return Venda
     */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "venda_id", nullable = false, insertable = false, updatable = false)
	public Venda getVenda() {
		return this.venda;
	}

	
    /** 
     * @param venda
     */
    public void setVenda(Venda venda) {
		this.venda = venda;
	}

	
    /** 
     * @return int
     */
    @Column(name = "quantidade", nullable = false)
	public int getQuantidade() {
		return this.quantidade;
	}

	
    /** 
     * @param quantidade
     */
    public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
