package com.wassabi.model;
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
 * Cartao generated by hbm2java
 */
@Entity
@Table(name = "Cartao", catalog = "wassabi")
public class Cartao implements java.io.Serializable {

	private CartaoId id;
	private Cliente cliente;
	private String cartaoNumero;

	public Cartao() {
	}

	public Cartao(CartaoId id, Cliente cliente, String cartaoNumero) {
		this.id = id;
		this.cliente = cliente;
		this.cartaoNumero = cartaoNumero;
	}

	
    /** 
     * @return CartaoId
     */
    @EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "cartaoId", column = @Column(name = "cartao_id", nullable = false)),
			@AttributeOverride(name = "cartaoCliente", column = @Column(name = "cartao_cliente", nullable = false)) })
	public CartaoId getId() {
		return this.id;
	}

	
    /** 
     * @param id
     */
    public void setId(CartaoId id) {
		this.id = id;
	}

	
    /** 
     * @return Cliente
     */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cartao_cliente", nullable = false, insertable = false, updatable = false)
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
     * @return String
     */
    @Column(name = "cartao_numero", nullable = false, length = 16)
	public String getCartaoNumero() {
		return this.cartaoNumero;
	}

	
    /** 
     * @param cartaoNumero
     */
    public void setCartaoNumero(String cartaoNumero) {
		this.cartaoNumero = cartaoNumero;
	}

}