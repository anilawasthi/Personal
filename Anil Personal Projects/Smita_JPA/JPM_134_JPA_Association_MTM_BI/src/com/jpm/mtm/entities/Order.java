package com.jpm.mtm.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ORDER_MTM")
public class Order {
	
		@Id
		@Column(name = "order_id")
		private Long orderId;
		
		@Temporal(TemporalType.DATE) //required for Date and Calendar Types
		@Column(name = "order_date")
		private Date purchaseDate;
//Step 1: Many to Many relationship
		@ManyToMany(cascade=CascadeType.ALL)
//Step 2: Join table
		@JoinTable(name="ORDER_PRODUCT_MTM", 
//Step 3: joinColumns
		joinColumns= {@JoinColumn(name="OEDER_ID")}, 
//Step 4: inverseJoinColumns
		inverseJoinColumns={@JoinColumn(name="PRODUCT_ID")})
		
		
		private Set<Product> products = new HashSet<>();

		public Order() {
			
		}

		public Long getOrderId() {
			return orderId;
		}

		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}

		public Date getPurchaseDate() {
			return purchaseDate;
		}

		public void setPurchaseDate(Date purchaseDate) {
			this.purchaseDate = purchaseDate;
		}

		public Set<Product> getProducts() {
			return products;
		}

		public void setProducts(Set<Product> products) {
			this.products = products;
		}

		@Override
		public String toString() {
			return "Order [orderId=" + orderId + ", purchaseDate=" + purchaseDate + ", products=" + products + "]";
		}
}
