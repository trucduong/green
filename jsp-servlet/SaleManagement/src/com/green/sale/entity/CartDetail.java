package com.green.sale.entity;

public class CartDetail {
	private int code;
	private int cartCode;
	private int productCode;
	private int quantity;
	private long price;
	private long total;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCartCode() {
		return cartCode;
	}

	public void setCartCode(int cartCode) {
		this.cartCode = cartCode;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

}
