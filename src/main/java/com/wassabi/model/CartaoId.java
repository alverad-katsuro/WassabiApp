package com.wassabi.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CartaoId generated by hbm2java
 */
@Embeddable
public class CartaoId implements java.io.Serializable {

	private int cartaoId;
	private int cartaoCliente;

	public CartaoId() {
	}

	public CartaoId(int cartaoId, int cartaoCliente) {
		this.cartaoId = cartaoId;
		this.cartaoCliente = cartaoCliente;
	}

	
    /** 
     * @return int
     */
    @Column(name = "cartao_id", nullable = false)
	public int getCartaoId() {
		return this.cartaoId;
	}

	
    /** 
     * @param cartaoId
     */
    public void setCartaoId(int cartaoId) {
		this.cartaoId = cartaoId;
	}

	
    /** 
     * @return int
     */
    @Column(name = "cartao_cliente", nullable = false)
	public int getCartaoCliente() {
		return this.cartaoCliente;
	}

	
    /** 
     * @param cartaoCliente
     */
    public void setCartaoCliente(int cartaoCliente) {
		this.cartaoCliente = cartaoCliente;
	}

	
    /** 
     * @param other
     * @return boolean
     */
    public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CartaoId))
			return false;
		CartaoId castOther = (CartaoId) other;

		return (this.getCartaoId() == castOther.getCartaoId())
				&& (this.getCartaoCliente() == castOther.getCartaoCliente());
	}

	
    /** 
     * @return int
     */
    public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCartaoId();
		result = 37 * result + this.getCartaoCliente();
		return result;
	}

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "CartaoId [cartaoId=" + cartaoId + ", cartaoCliente=" + cartaoCliente + "]";
    }

}
