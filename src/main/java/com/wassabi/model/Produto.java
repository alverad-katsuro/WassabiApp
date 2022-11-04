package com.wassabi.model;
// Generated 4 de nov. de 2022 18:11:25 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Produto generated by hbm2java
 */
@Entity
@Table(name = "Produto")
public class Produto implements java.io.Serializable {

	private Integer produtoId;
	private Categoria categoria;
	private String produtoNome;
	private double produtoPreco;
	private String produtoDescricao;
	private Set<VendaHasProduto> vendaHasProdutos = new HashSet<VendaHasProduto>(0);

	public Produto() {
	}

	public Produto(Categoria categoria, String produtoNome, double produtoPreco, String produtoDescricao) {
		this.categoria = categoria;
		this.produtoNome = produtoNome;
		this.produtoPreco = produtoPreco;
		this.produtoDescricao = produtoDescricao;
	}

	public Produto(Categoria categoria, String produtoNome, double produtoPreco, String produtoDescricao,
			Set<VendaHasProduto> vendaHasProdutos) {
		this.categoria = categoria;
		this.produtoNome = produtoNome;
		this.produtoPreco = produtoPreco;
		this.produtoDescricao = produtoDescricao;
		this.vendaHasProdutos = vendaHasProdutos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "produto_id", unique = true, nullable = false)
	public Integer getProdutoId() {
		return this.produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produto_categoria", nullable = false)
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Column(name = "produto_nome", nullable = false, length = 30)
	public String getProdutoNome() {
		return this.produtoNome;
	}

	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}

	@Column(name = "produto_preco", nullable = false, precision = 30)
	public double getProdutoPreco() {
		return this.produtoPreco;
	}

	public void setProdutoPreco(double produtoPreco) {
		this.produtoPreco = produtoPreco;
	}

	@Column(name = "produto_descricao", nullable = false, length = 80)
	public String getProdutoDescricao() {
		return this.produtoDescricao;
	}

	public void setProdutoDescricao(String produtoDescricao) {
		this.produtoDescricao = produtoDescricao;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	public Set<VendaHasProduto> getVendaHasProdutos() {
		return this.vendaHasProdutos;
	}

	public void setVendaHasProdutos(Set<VendaHasProduto> vendaHasProdutos) {
		this.vendaHasProdutos = vendaHasProdutos;
	}

    @Override
    public String toString() {
        return "Produto [produtoId=" + produtoId + ", categoria=" + categoria + ", produtoNome=" + produtoNome
                + ", produtoPreco=" + produtoPreco + ", produtoDescricao=" + produtoDescricao + "]";
    }

}
