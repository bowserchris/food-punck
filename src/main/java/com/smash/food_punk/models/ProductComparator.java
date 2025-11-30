/**
 * @author bowserchris
 */
package com.smash.food_punk.models;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.NoArgsConstructor;

/**
 * Class that will compare attributes between 2 products and return a result
 */
@NoArgsConstructor
public class ProductComparator implements Comparator<Product> {

	@Override
	public int compare(Product product1, Product product2) {
		return Double.compare(product1.getPrice(), product2.getPrice());
	}

	// TODO keep an eye on this method as it will need to change on further
	// implementations
	/**
	 * Takes a list of similar products and returns the lowest priced product
	 * 
	 * @param productList - from 1 list/store
	 * @return product - lowest priced product
	 */
	public Product returnSortedLowestPrice(List<Product> productList) {
		return productList.stream().sorted(Comparator.comparing(p -> p.getPrice()))
				.collect(Collectors.toList()).get(0);
	}

}
