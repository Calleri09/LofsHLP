package entitiess;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private Date momento;
	private OrderStatus status;
	private Client client;

	private List<OrderItem> item = new ArrayList<>();

	public Order() {

	}

	public Order(Date momento, OrderStatus status, Client client) {
		this.momento = momento;
		this.status = status;
		this.client = client;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItem() {
		return item;
	}

	public void addItem(OrderItem item) {
		this.item.add(item);
	}

	public void removeItem(OrderItem item) {
		this.item.remove(item);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Double total() {
		Double sum = 0.0;
		for (OrderItem c : item) {

			sum += c.subTotal();
		}
		return sum;

	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (OrderItem c : item) {
			sb.append(c.getProduct());
			sb.append(c.getQuantity());
			sb.append(c.subTotal());
		}
		
		return sb.toString();
	}

}
