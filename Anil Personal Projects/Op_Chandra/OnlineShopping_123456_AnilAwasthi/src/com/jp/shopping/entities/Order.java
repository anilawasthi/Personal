package com.jp.shopping.entities;

public class Order {

	private int customerId;
	private int orderId;
	private int itemOId;

	public Order(int customerId, int orderId, int itemOId) {
		super();
		this.customerId = customerId;
		this.orderId = orderId;
		this.itemOId = itemOId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getItemOId() {
		return itemOId;
	}

	public void setItemOId(int itemOId) {
		this.itemOId = itemOId;
	}

	@Override
	public String toString() {
		return "Order [customerId=" + customerId + ", orderId=" + orderId + ", itemOId=" + itemOId + "]";
	}
}
