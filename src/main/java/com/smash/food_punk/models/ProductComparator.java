/**
 * @author bowserchris
 */
package com.smash.food_punk.models;

import java.util.Comparator;

import lombok.NoArgsConstructor;

/**
 * Class that will compare attributes between 2 products and return a result
 */
@NoArgsConstructor
public class ProductComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return Double.compare(o1.getPrice(), o2.getPrice());
	}

}
