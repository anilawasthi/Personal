/**
 * 
 */
package com.jpm.mtm.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Administrator
 *
 */
@Entity
@Table(name="PRODUCT_MTM")
public class Product {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="product_id")
	private Long product_Id;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_price")
	private Double productPrice;

	/*fetch Type we have made LAZY
	 * FetchType.EAGER loading of collection means that they are fetched
	 * fully at the time their parent is fetched. The FetchType.LAZY tells 
	 * Hibernate to only fetch the related entities from the 
	 * database when you use the relationship
	 */
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="products")
	private Set<Order> orders = new HashSet<>();

	public Product() {
		super();
	}
	
	public Long getProduct_Id() {
		return product_Id;
	}
	
	public void setProduct_Id(Long product_Id) {
		this.product_Id = product_Id;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Double getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
}
