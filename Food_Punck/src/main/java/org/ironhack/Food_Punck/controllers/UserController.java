package org.ironhack.Food_Punck.controllers;

import java.util.List;
import java.util.Optional;

import org.ironhack.Food_Punck.models.Product;
import org.ironhack.Food_Punck.models.Promotion;
import org.ironhack.Food_Punck.models.ResultCompare;
import org.ironhack.Food_Punck.models.Review;
import org.ironhack.Food_Punck.models.Store;
import org.ironhack.Food_Punck.models.User;
import org.ironhack.Food_Punck.repositories.ProductPromotionRepository;
import org.ironhack.Food_Punck.repositories.ProductRepository;
import org.ironhack.Food_Punck.repositories.PromotionRepository;
import org.ironhack.Food_Punck.repositories.ResultCompareRepository;
import org.ironhack.Food_Punck.repositories.ReviewRepository;
import org.ironhack.Food_Punck.repositories.StoreRepository;
import org.ironhack.Food_Punck.repositories.UserRepository;
import org.ironhack.Food_Punck.repositories.UserStoreRepository;
import org.ironhack.Food_Punck.util.CommonConst;
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

@RestController
@RequestMapping(CommonConst.INDEX_USER) // mapped to base + "/user" in CommonConst
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private ResultCompareRepository resultRepo;
	
	@Autowired
	private StoreRepository storeRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private PromotionRepository promoRepo;
	
	@Autowired
	private ProductPromotionRepository productPromoRepo;
	
	@Autowired
	private UserStoreRepository userStoreRepo;
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/")
	public String hello() {
		return "Hello from the user backend.";
	}
	
	/* methods needed to fully implement
	 * comopareproducts method
	 * searchbyproductname
	 * searchbyproducttype
	 * searchstorebyname
	 * searchstorebypostcode
	 * searchbystoreandproduct
	 * update password separate meethod?
	 * followstore
	 * unfollowstore
	 * followproducts
	 * unfollowproducts
	 * 
	 */
	
	/// All 6 post mappings ///
	
	@PostMapping(CommonConst.URL_ADD_USER) // base + "/user" + "/addUser"
	public ResponseEntity<User> addUser(@RequestBody User user){
		if (user != null) {
			logger.error(user.toString());
			logger.info(user.toString());
			return ResponseEntity.ok(this.userRepo.save(user));
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping(CommonConst.URL_ADD_REVIEW) // base + "/user" + "/addReview"
	public ResponseEntity<Review> addReview(@RequestBody Review review){
		if (review != null) {
			return ResponseEntity.ok(this.reviewRepo.save(review));
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping(CommonConst.URL_ADD_RESULT) // base + "/user" + "/addResult"
	public ResponseEntity<ResultCompare> addResultCompare(@RequestBody ResultCompare result){
		if (result != null) {
			return ResponseEntity.ok(this.resultRepo.save(result));
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping(CommonConst.URL_ADD_STORE) // base + "/user" + "/addStore"
	public ResponseEntity<Store> addStore(@RequestBody Store store){
		if (store != null) {
			return ResponseEntity.ok(this.storeRepo.save(store));
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping(CommonConst.URL_ADD_PRODUCT) // base + "/user" + "/addProduct"
	public ResponseEntity<Product> addProductToInventory(@RequestBody Product product){
		if (product != null) {
			return ResponseEntity.ok(this.productRepo.save(product));
		} else {
			return ResponseEntity.noContent().build();
		}
	}	
	@PostMapping(CommonConst.URL_ADD_PROMO) // base + "/user" + "/addPromo"
	public ResponseEntity<Promotion> addStore(@RequestBody Promotion promo){
		if (promo != null) {
			return ResponseEntity.ok(this.promoRepo.save(promo));
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	/// All 6 update mappings ///
	
	@PutMapping(CommonConst.URL_BY_USER_ID) // base + "/user" + "/idUser/{id}"
	public ResponseEntity<User> updateStore(@PathVariable int id, @RequestBody User userDetails) {
		User updatedUser = this.userRepo.findById(id).orElse(null);
		if (updatedUser != null) {
			updatedUser.setId(userDetails.getId());
			updatedUser.setUserName(userDetails.getUserName());
			updatedUser.setName(userDetails.getName());
			updatedUser.setLastName1(userDetails.getLastName1());
			updatedUser.setLastName2(userDetails.getLastName2());
			updatedUser.setEmail(userDetails.getEmail());
			updatedUser.setAddress(userDetails.getAddress());
			return ResponseEntity.ok(this.userRepo.save(updatedUser));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(CommonConst.URL_BY_REVIEW_ID) // base + "/user" + "/idReview/{id}"
	public ResponseEntity<Review> updateReview(@PathVariable int id, @RequestBody Review reviewDetails) {
		Review updatedReview = this.reviewRepo.findById(id).orElse(null);
		if (updatedReview != null) {
			updatedReview.setId(reviewDetails.getId());
			updatedReview.setTitle(reviewDetails.getTitle());
			updatedReview.setText(reviewDetails.getText());
			updatedReview.setValueRanking(reviewDetails.getValueRanking());
			updatedReview.setStore(reviewDetails.getStore());
			return ResponseEntity.ok(this.reviewRepo.save(updatedReview));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping(CommonConst.URL_BY_RESULT_ID) // base + "/user" + "/idResult/{id}"
	public ResponseEntity<ResultCompare> updateResultCompare(@PathVariable int id, @RequestBody ResultCompare resultDetails) {
		ResultCompare updatedResult = this.resultRepo.findById(id).orElse(null);
		if (updatedResult != null) {
			updatedResult.setId(resultDetails.getId());
			updatedResult.setResult(resultDetails.getResult());
			updatedResult.setUserComments(resultDetails.getUserComments());
			updatedResult.setUser(resultDetails.getUser());
			//////////////// missing modified date time here or is it done in mysql?
			return ResponseEntity.ok(this.resultRepo.save(updatedResult));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(CommonConst.URL_BY_STORE_ID) // base + "/user" + "/idStore/{id}"
	public ResponseEntity<Store> updateStore(@PathVariable int id, @RequestBody Store storeDetails) {
		Store updatedStore = this.storeRepo.findById(id).orElse(null);
		if (updatedStore != null) {
			updatedStore.setId(storeDetails.getId());
			updatedStore.setName(storeDetails.getName());
			updatedStore.setEmail(storeDetails.getEmail());
			return ResponseEntity.ok(this.storeRepo.save(updatedStore));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(CommonConst.URL_BY_PRODUCT_ID) // base + "/user" + "/idProduct/{id}"
	public ResponseEntity<Product> updateProductInInventory(@PathVariable int id, @RequestBody Product productDetails) {
		Product updatedProduct = this.productRepo.findById(id).orElse(null);
		if (updatedProduct != null) {
			updatedProduct.setId(productDetails.getId());
			updatedProduct.setName(productDetails.getName());
			updatedProduct.setType(productDetails.getType());
			updatedProduct.setPrice(productDetails.getPrice());
			updatedProduct.setWeight(productDetails.getWeight());
			updatedProduct.setDiscount(productDetails.isDiscount());
			updatedProduct.setStore(productDetails.getStore());
			updatedProduct.setDateDelivered(productDetails.getDateDelivered());
			updatedProduct.setDateExpired(productDetails.getDateExpired());
			return ResponseEntity.ok(this.productRepo.save(updatedProduct));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping(CommonConst.URL_BY_PROMO_ID) // base + "/user" + "/idPromo/{id}"
	public ResponseEntity<Promotion> updatePromotion(@PathVariable int id, @RequestBody Promotion promoDetails) {
		Promotion updatedPromo = this.promoRepo.findById(id).orElse(null);
		if (updatedPromo != null) {
			updatedPromo.setId(promoDetails.getId());
			updatedPromo.setName(promoDetails.getName());
			updatedPromo.setType(promoDetails.getType());
			updatedPromo.setDiscountValue(promoDetails.getDiscountValue());
			updatedPromo.setStore(promoDetails.getStore());
			updatedPromo.setPromoActive(promoDetails.isPromoActive());
			updatedPromo.setDateApplied(promoDetails.getDateApplied());
			updatedPromo.setDateExpired(promoDetails.getDateExpired());
			return ResponseEntity.ok(this.promoRepo.save(updatedPromo));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	/// All 6 delete mappings ///
	
	@DeleteMapping(CommonConst.URL_BY_USER_ID) // base + "/user" + "/idUser/{id}"
	public void deleteUser(@PathVariable int id) {
		this.userRepo.deleteById(id);
	}
	
	@DeleteMapping(CommonConst.URL_BY_REVIEW_ID) // base + "/user" + "/idReview/{id}"
	public void deleteReview(@PathVariable int id) {
		this.reviewRepo.deleteById(id);
	}
	
	@DeleteMapping(CommonConst.URL_BY_RESULT_ID) // base + "/user" + "/idResult/{id}"
	public void deleteResult(@PathVariable int id) {
		this.resultRepo.deleteById(id);
	}
	
	@DeleteMapping(CommonConst.URL_BY_STORE_ID) // base + "/user" + "/idStore/{id}"
	public void deleteStore(@PathVariable int id) {
		this.storeRepo.deleteById(id);
	}
	
	@DeleteMapping(CommonConst.URL_BY_PRODUCT_ID) // base + "/user" + "/idProduct/{id}"
	public void deleteProductFromInventory(@PathVariable int id) {
		this.productRepo.deleteById(id);
	}
	
	@DeleteMapping(CommonConst.URL_BY_PROMO_ID) // base + "/user" + "/idPromo/{id}"
	public void deletePromo(@PathVariable int id) {
		this.promoRepo.deleteById(id);
	}	
	
	/// All 6 get1 mappings ///
	
	@GetMapping(CommonConst.URL_BY_USER_ID) // base + "/user" + "/idUser/{id}"
	public ResponseEntity<Optional<User>> getUserByID(@PathVariable int id) {
		Optional<User> user = this.userRepo.findById(id);
		if (user.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(user);
		}
	}
	
	@GetMapping(CommonConst.URL_BY_REVIEW_ID) // base + "/user" + "/idReview/{id}"
	public ResponseEntity<Optional<Review>> getReviewByID(@PathVariable int id) {
		Optional<Review> review = this.reviewRepo.findById(id);
		if (review.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(review);
		}
	}
	
	@GetMapping(CommonConst.URL_BY_RESULT_ID) // base + "/user" + "/idResult/{id}"
	public ResponseEntity<Optional<ResultCompare>> getResultByID(@PathVariable int id) {
		Optional<ResultCompare> result = this.resultRepo.findById(id);
		if (result.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(result);
		}
	}
	
	@GetMapping(CommonConst.URL_BY_STORE_ID) // base + "/user" + "/idStore/{id}"
	public ResponseEntity<Optional<Store>> getStoreByID(@PathVariable int id) {
		Optional<Store> store = this.storeRepo.findById(id);
		if (store.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(store);
		}
	}
	
	@GetMapping(CommonConst.URL_BY_PRODUCT_ID) // base + "/user" + "/idProduct/{id}"
	public ResponseEntity<Optional<Product>> getProductByID(@PathVariable int id) {
		Optional<Product> product = this.productRepo.findById(id);
		if (product.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(product);
		}
	}
	
	@GetMapping(CommonConst.URL_BY_PROMO_ID) // base + "/user" + "/idPromo/{id}"
	public ResponseEntity<Optional<Promotion>> getPromoByID(@PathVariable int id) {
		Optional<Promotion> promo = this.promoRepo.findById(id);
		if (promo.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(promo);
		}
	}
	
	/// All 6 getAll mappings ///

	@GetMapping(CommonConst.URL_GET_ALL_USERS) // base + "/user" + "/allUsers"
	public List<User> getAllUsers() {
		return this.userRepo.findAll();
	}
	
	@GetMapping(CommonConst.URL_GET_ALL_REVIEWS) // base + "/user" + "/allReviews"
	public List<Review> getAllReviews() {
		return this.reviewRepo.findAll();
	}
	
	@GetMapping(CommonConst.URL_GET_ALL_RESULTS) // base + "/user" + "/allResults"
	public List<ResultCompare> getAllResultCompares() {
		return this.resultRepo.findAll();
	}
	
	@GetMapping(CommonConst.URL_GET_ALL_STORES) // base + "/user" + "/allStores"
	public List<Store> getAllStores() {
		return this.storeRepo.findAll();
	}

	@GetMapping(CommonConst.URL_GET_ALL_PRODUCTS) // base + "/user" + "/allProducts"
	public List<Product> getAllProducts() {
		return this.productRepo.findAll();
	}
	
	@GetMapping(CommonConst.URL_GET_ALL_PROMOS) // base + "/user" + "/allPromos"
	public List<Promotion> getAllPromotions() {
		return this.promoRepo.findAll();
	}


}
