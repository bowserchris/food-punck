/**
 * @author bowserchris
 */
package com.smash.food_punk.controllers;

import static com.smash.food_punk.util.FoodPunkConstants.INDEX;
import static com.smash.food_punk.util.FoodPunkConstants.INDEX_USER;
import static com.smash.food_punk.util.FoodPunkConstants.URL_BY_PRODUCT_ID;
import static com.smash.food_punk.util.FoodPunkConstants.URL_GET_ALL_PRODUCTS;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smash.food_punk.models.Product;
import com.smash.food_punk.service.UserService;

/**
 * Controller class for User
 */
@RestController
@RequestMapping(INDEX_USER) // mapped to HOST_START + "/user" in CommonConst
public class UserController {

	@Autowired
	private UserService userService;

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping(INDEX) // mapped to HOST_START + "/user" + "/"
	public String hello() {
		return "POW! Fruit Punch! You just got Punxed!";
	}

	@GetMapping(URL_GET_ALL_PRODUCTS) // base + "/user" + "/allProducts"
	public List<Product> getAllProducts() {
		logger.info("Within UserController.getAllProducts() method");
		return this.userService.getProducts();
	}

	@GetMapping(URL_BY_PRODUCT_ID) // base + "/user" + "/idProduct/{id}"
	public ResponseEntity<Optional<Product>> getProductByID(@PathVariable int id) {
		logger.info("Within UserController.getProductById() method");
		Optional<Product> product = this.userService.getProductById(id);
		if (product.isEmpty()) {
			logger.info("Within UserController.getProductById() method. Product is Empty");
			return ResponseEntity.notFound().build();
		}
		logger.info("Within UserController.getProductById() method. Product returned");
			return ResponseEntity.ok(product);
	}

	@PostMapping("/addProduct")
	public void addProduct(@RequestBody Product product) {
		userService.addProduct(product);
	}

	@DeleteMapping(URL_BY_PRODUCT_ID) // base + "/user" + "/idProduct/{id}"
	public void deleteProductFromInventory(@PathVariable int id) {
		logger.info("Within UserController.deleteProductFromInventory() method.");
		this.userService.deleteProduct(id);
	}

	@PutMapping(URL_BY_PRODUCT_ID) // base + "/user" + "/idProduct/{id}"
	public ResponseEntity<Product> updateProductInInventory(@PathVariable int id, @RequestBody Product productDetails) {
		Product updatedProduct = this.userService.updateProdcut(id, productDetails).orElse(null);
		logger.info("Within UserController.updateProductInInventory() method.");
		if (updatedProduct != null) {
			updatedProduct.setId(productDetails.getId());
			updatedProduct.setName(productDetails.getName());
//			updatedProduct.setType(productDetails.getType());
			updatedProduct.setPrice(productDetails.getPrice());
//			updatedProduct.setWeight(productDetails.getWeight());
//			updatedProduct.setDiscount(productDetails.isDiscount());
//			updatedProduct.setStore(productDetails.getStore());
//			updatedProduct.setDateDelivered(productDetails.getDateDelivered());
//			updatedProduct.setDateExpired(productDetails.getDateExpired());
			return ResponseEntity.ok(updatedProduct);
		}
		logger.info("Within UserController.updateProductInInventory() method. Product is Empty");
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/sortProducts") // base + "/user" + "/sortProducts"
	public List<Product> getSortedList() {
		logger.info("Within UserController.getSortedList() method.");
		return userService.getSortedList();
	}

	@GetMapping("/lowestPrice") // base + "/user" + "/lowestPrice"
	public Product getLowestPricedProduct() {
		return userService.getSortedList().get(0);
	}

}
