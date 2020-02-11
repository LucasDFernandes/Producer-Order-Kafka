package br.com.alura.order.kafka.dto;

import java.util.List;

import br.com.alura.order.kafka.domain.Order;

public class OrderDTO {

	private List<Order> listaOrders;

	public List<Order> getListaOrders() {
		return listaOrders;
	}

	public void setListaOrders(List<Order> listaOrders) {
		this.listaOrders = listaOrders;
	}

}
