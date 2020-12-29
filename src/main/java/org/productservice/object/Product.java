package org.productservice.object;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Product {

	@Id
	@Column
	private String productId;
	@Column
	private String name;
	@Column
	private String desc;
	@Column
	private int price;
		
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String productId, String name, String desc, int price) {
		super();
		this.productId = productId;
		this.name = name;
		this.desc = desc;
		this.price = price;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}	
}
