package com.wassabi.model;
// Generated 4 de nov. de 2022 15:43:42 by Hibernate Tools 4.3.6.Final

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
 * Cliente generated by hbm2java
 */
@Entity
@Table(name = "Cliente", catalog = "wassabi")
public class Cliente implements java.io.Serializable {

	private Integer clienteId;
	private Endereco endereco;
	private String clienteNome;
	private String clienteSobrenome;
	private String clienteCpf;
	private String clienteTelefone;
	private Set<Venda> vendas = new HashSet<Venda>(0);
	private Set<Cartao> cartaos = new HashSet<Cartao>(0);

	public Cliente() {
	}

	public Cliente(Endereco endereco, String clienteNome, String clienteSobrenome, String clienteCpf,
			String clienteTelefone) {
		this.endereco = endereco;
		this.clienteNome = clienteNome;
		this.clienteSobrenome = clienteSobrenome;
		this.clienteCpf = clienteCpf;
		this.clienteTelefone = clienteTelefone;
	}

	public Cliente(Endereco endereco, String clienteNome, String clienteSobrenome, String clienteCpf,
			String clienteTelefone, Set<Venda> vendas, Set<Cartao> cartaos) {
		this.endereco = endereco;
		this.clienteNome = clienteNome;
		this.clienteSobrenome = clienteSobrenome;
		this.clienteCpf = clienteCpf;
		this.clienteTelefone = clienteTelefone;
		this.vendas = vendas;
		this.cartaos = cartaos;
	}

	
    /** 
     * @return Integer
     */
    @Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "cliente_id", unique = true, nullable = false)
	public Integer getClienteId() {
		return this.clienteId;
	}

	
    /** 
     * @param clienteId
     */
    public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	
    /** 
     * @return Endereco
     */
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_endereco", nullable = false)
	public Endereco getEndereco() {
		return this.endereco;
	}

	
    /** 
     * @param endereco
     */
    public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
    /** 
     * @return String
     */
    @Column(name = "cliente_nome", nullable = false, length = 30)
	public String getClienteNome() {
		return this.clienteNome;
	}

	
    /** 
     * @param clienteNome
     */
    public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}

	
    /** 
     * @return String
     */
    @Column(name = "cliente_sobrenome", nullable = false, length = 60)
	public String getClienteSobrenome() {
		return this.clienteSobrenome;
	}

	
    /** 
     * @param clienteSobrenome
     */
    public void setClienteSobrenome(String clienteSobrenome) {
		this.clienteSobrenome = clienteSobrenome;
	}

	
    /** 
     * @return String
     */
    @Column(name = "cliente_cpf", nullable = false, length = 14)
	public String getClienteCpf() {
		return this.clienteCpf;
	}

	
    /** 
     * @param clienteCpf
     */
    public void setClienteCpf(String clienteCpf) {
		this.clienteCpf = clienteCpf;
	}

	
    /** 
     * @return String
     */
    @Column(name = "cliente_telefone", nullable = false, length = 15)
	public String getClienteTelefone() {
		return this.clienteTelefone;
	}

	
    /** 
     * @param clienteTelefone
     */
    public void setClienteTelefone(String clienteTelefone) {
		this.clienteTelefone = clienteTelefone;
	}

	
    /** 
     * @return Set<Venda>
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public Set<Venda> getVendas() {
		return this.vendas;
	}

	
    /** 
     * @param vendas
     */
    public void setVendas(Set<Venda> vendas) {
		this.vendas = vendas;
	}

	
    /** 
     * @return Set<Cartao>
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public Set<Cartao> getCartaos() {
		return this.cartaos;
	}

	
    /** 
     * @param cartaos
     */
    public void setCartaos(Set<Cartao> cartaos) {
		this.cartaos = cartaos;
	}

}