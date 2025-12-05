/**
 * @author bowserchris
 */
package com.smash.food_punk.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.smash.food_punk.controllers.UserController;
import com.smash.food_punk.models.Product;
import com.smash.food_punk.models.ProductComparator;

/**
 * Service layer for User
 */
@Service
public class UserService {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	private static ProductComparator productComparator;
	private List<Product> userRepo;

	// TODO work on resource file for test data
	public UserService() {
		this.userRepo = new ArrayList<Product>();
		userRepo.addAll(Arrays.asList(new Product(1, "granny smith apple", 1.5), new Product(2, "fuji apple", 1.50),
				new Product(3, "iphone 15", 1200.00), new Product(4, "iphone 12", 999.99),
				new Product(5, "sweet pineapple", 2.75), new Product(6, "sweet pineapple", 1.55)));
	}

	/**
	 * @return list of all products in database
	 */
	public List<Product> getProducts() {
		logger.info("Within UserService.getProducts() method. Returning full list");
		return userRepo;
	}

	/**
	 * @param id of the product
	 * @return optional<product> with the id or null
	 */
	public Optional<Product> getProductById(int id) {
		logger.info("Within UserService.getProductById() method. Returning one product with id " + id);
		Product check = new Product();
		check.setId(id);
		int index = userRepo.indexOf(check.getId());
		return Optional.of(userRepo.get(index));
	}

	public void addProduct(Product product) {
		logger.info("Within UserService.addProduct() method. Adding a product to list with id " + product.getId());
		this.userRepo.add(product);
	}

	/**
	 * @param id to delete the product
	 */
	public void deleteProduct(int id) {
		logger.info("Within UserService.deleteProduct() method. Deleting product from list with id " + id);
		Product check = new Product();
		check.setId(id);
		int index = userRepo.indexOf(check.getId());
		userRepo.remove(id);
	}

	/**
	 * @param id of product to update
	 * @return optional<product> updated
	 */
	public Optional<Product> updateProdcut(int productId, Product product) {
		logger.info("Within UserService.updateProdcut() method. Returning updated product with id " + productId);
		Product check = new Product();
		check.setId(productId);
		int index = userRepo.indexOf(check.getId());
		Product updated = userRepo.get(index);
		updated.setName(product.getName());
		updated.setPrice(product.getPrice());
		return Optional.of(updated);
	}

	public List<Product> getSortedList() {
		logger.info("Within UserService.getSortedList() method. Returning sorted list by price");
		return productComparator.returnSortedListByLowestPrice(userRepo);
	}

}
