package com.wassabi.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Categoria generated by hbm2java
 */
@Entity
@Table(name = "Categoria", catalog = "wassabi")
public class Categoria implements java.io.Serializable {

	private Integer categoriaId;
	private String categoriaDescricao;
    private String categoriaNome;
	private Set<Produto> produtos = new HashSet<Produto>(0);

	public Categoria() {
	}

	public Categoria(String categoriaNome, String categoriaDescricao) {
		this.categoriaNome = categoriaNome;
		this.categoriaDescricao = categoriaDescricao;
	}
    
	public Categoria(String categoriaNome, String categoriaDescricao, Set<Produto> produtos) {
        this.categoriaNome = categoriaNome;
		this.categoriaDescricao = categoriaDescricao;
		this.produtos = produtos;
	}

	
    /** 
     * @return Integer
     */
    @Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "categoria_id", unique = true, nullable = false)
	public Integer getCategoriaId() {
		return this.categoriaId;
	}

	
    /** 
     * @param categoriaId
     */
    public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}


    /** 
     * @return String
     */
    @Column(name = "categoria_nome", nullable = false, length = 30)
	public String getCategoriaNome() {
		return this.categoriaNome;
	}

	
    /** 
     * @param categoriaNome
     */
    public void setCategoriaNome(String categoriaNome) {
		this.categoriaNome = categoriaNome;
	}

	
    /** 
     * @return String
     */
    @Column(name = "categoria_descricao", nullable = false, length = 60)
	public String getCategoriaDescricao() {
		return this.categoriaDescricao;
	}

	
    /** 
     * @param categoriaDescricao
     */
    public void setCategoriaDescricao(String categoriaDescricao) {
		this.categoriaDescricao = categoriaDescricao;
	}

	
    /** 
     * @return Set<Produto>
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Produto> getProdutos() {
		return this.produtos;
	}

	
    /** 
     * @param produtos
     */
    public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "Categoria [categoriaId=" + categoriaId + ", categoriaDescricao=" + categoriaDescricao + "]";
    }

}
