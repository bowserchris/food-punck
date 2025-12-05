/**
 * @author bowserchris
 */
package com.smash.food_punk.models;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.smash.food_punk.controllers.UserController;

import lombok.NoArgsConstructor;

/**
 * Class that will compare attributes between 2 products and return a result
 */
@NoArgsConstructor
public class ProductComparator implements Comparator<Product> {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Override
	public int compare(Product product1, Product product2) {
		logger.info("Within ProductComparator.compare() method");
		return Double.compare(product1.getPrice(), product2.getPrice());
	}

	// TODO keep an eye on this method as it will need to change on further
	// implementations
	/**
	 * Takes a list of products and returns the sorted list by lowest price
	 * 
	 * @param productList - from 1 list/store
	 * @return productList - sorted by lowest price
	 */
	public List<Product> returnSortedListByLowestPrice(List<Product> productList) {
		logger.info("Within ProductComparator.returnSortedListByLowestPrice() method");
		return productList.stream().sorted(Comparator.comparing(p -> p.getPrice())).collect(Collectors.toList());
	}

}
