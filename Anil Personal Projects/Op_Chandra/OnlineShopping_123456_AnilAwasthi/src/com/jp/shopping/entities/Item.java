package com.jp.shopping.entities;

public class Item {

	private int itemId;
	private String itemName;
	private String itemCategory;
	private Number itemPrice;

	public Item(int itemId, String itemName, String itemCategory, Number itemPrice) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCategory = itemCategory;
		this.itemPrice = itemPrice;
	}

	public Item() {
		super();
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public Number getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Number itemPrice) {
		this.itemPrice = itemPrice;
	}

	@Override
	public String toString() {
		return "Shopping [itemId=" + itemId + ", itemName=" + itemName + ", itemCategory=" + itemCategory
				+ ", itemPrice=" + itemPrice + "]";
	}
}
