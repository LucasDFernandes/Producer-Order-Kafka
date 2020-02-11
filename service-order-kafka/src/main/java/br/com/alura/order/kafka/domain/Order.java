package br.com.alura.order.kafka.domain;

import java.math.BigDecimal;

public class Order {

	private String orderId;
	private BigDecimal amount;

	public Order() {
		super();
	}

	public Order(String orderId, BigDecimal amount) {
		super();
		this.orderId = orderId;
		this.amount = amount;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
