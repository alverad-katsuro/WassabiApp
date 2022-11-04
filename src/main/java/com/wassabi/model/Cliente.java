package com.wassabi.model;
// Generated 4 de nov. de 2022 18:11:25 by Hibernate Tools 4.3.6.Final

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
 * Cliente generated by hbm2java
 */
@Entity
@Table(name = "Cliente")
public class Cliente implements java.io.Serializable {

	private Integer clienteId;
	private int enderecoCliente;
	private String clienteNome;
	private String clienteSobrenome;
	private String clienteCpf;
	private String clienteTelefone;
	private Set<Venda> vendas = new HashSet<Venda>(0);
	private Set<Cartao> cartaos = new HashSet<Cartao>(0);
	private Set<Endereco> enderecos = new HashSet<Endereco>(0);

	public Cliente() {
	}

	public Cliente(int enderecoCliente, String clienteNome, String clienteSobrenome, String clienteCpf,
			String clienteTelefone) {
		this.enderecoCliente = enderecoCliente;
		this.clienteNome = clienteNome;
		this.clienteSobrenome = clienteSobrenome;
		this.clienteCpf = clienteCpf;
		this.clienteTelefone = clienteTelefone;
	}

	public Cliente(int enderecoCliente, String clienteNome, String clienteSobrenome, String clienteCpf,
			String clienteTelefone, Set<Venda> vendas, Set<Cartao> cartaos, Set<Endereco> enderecos) {
		this.enderecoCliente = enderecoCliente;
		this.clienteNome = clienteNome;
		this.clienteSobrenome = clienteSobrenome;
		this.clienteCpf = clienteCpf;
		this.clienteTelefone = clienteTelefone;
		this.vendas = vendas;
		this.cartaos = cartaos;
		this.enderecos = enderecos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "cliente_id", unique = true, nullable = false)
	public Integer getClienteId() {
		return this.clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	@Column(name = "endereco_cliente", nullable = false)
	public int getEnderecoCliente() {
		return this.enderecoCliente;
	}

	public void setEnderecoCliente(int enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	@Column(name = "cliente_nome", nullable = false, length = 30)
	public String getClienteNome() {
		return this.clienteNome;
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}

	@Column(name = "cliente_sobrenome", nullable = false, length = 60)
	public String getClienteSobrenome() {
		return this.clienteSobrenome;
	}

	public void setClienteSobrenome(String clienteSobrenome) {
		this.clienteSobrenome = clienteSobrenome;
	}

	@Column(name = "cliente_cpf", nullable = false, length = 14)
	public String getClienteCpf() {
		return this.clienteCpf;
	}

	public void setClienteCpf(String clienteCpf) {
		this.clienteCpf = clienteCpf;
	}

	@Column(name = "cliente_telefone", nullable = false, length = 15)
	public String getClienteTelefone() {
		return this.clienteTelefone;
	}

	public void setClienteTelefone(String clienteTelefone) {
		this.clienteTelefone = clienteTelefone;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	public Set<Venda> getVendas() {
		return this.vendas;
	}

	public void setVendas(Set<Venda> vendas) {
		this.vendas = vendas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	public Set<Cartao> getCartaos() {
		return this.cartaos;
	}

	public void setCartaos(Set<Cartao> cartaos) {
		this.cartaos = cartaos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade = CascadeType.ALL)
	public Set<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

    @Override
    public String toString() {
        return "Cliente [clienteId=" + clienteId + ", enderecoCliente=" + enderecoCliente + ", clienteNome="
                + clienteNome + ", clienteSobrenome=" + clienteSobrenome + ", clienteCpf=" + clienteCpf
                + ", clienteTelefone=" + clienteTelefone + ", enderecos=" + enderecos + "]";
    }

}
