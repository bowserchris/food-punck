/**
 * @author bowserchris
 */
package com.smash.food_punk.models;

import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class representing a product or item
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

	private String name;
	private double price;

	// @Data provides constructor, getters, setters & toString methods

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
		return new EqualsBuilder().append(this.name, other.getName())
				.append(Double.doubleToLongBits(this.price), Double.doubleToLongBits(other.getPrice())).isEquals();
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}


}
