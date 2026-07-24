/**
 * @author bowserchris
 */
package com.smash.food_punk.models;

import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Class representing a product/item
 */
public class Product {

	private int id;
	private String name;
	private double price;

	public Product() {
	}

	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Product)) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		// TODO might need to rethink if name is included or not. What if its 2
		// different names but same type, eg granny smith apple and fujj, but i still
		// want to see the difference
		// EqualsBuilder used to easily update and add new lines to product when needed
		Product other = (Product) obj;
		return new EqualsBuilder().append(this.id, other.getId()).append(this.name, other.getName())
				.append(Double.doubleToLongBits(this.price), Double.doubleToLongBits(other.getPrice())).isEquals();
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.price);
	}
}
