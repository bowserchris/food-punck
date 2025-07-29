package org.ironhack.Food_Punck.controllers;

import java.util.List;

import org.ironhack.Food_Punck.models.Product;
import org.ironhack.Food_Punck.models.Promotion;
import org.ironhack.Food_Punck.models.Store;
import org.ironhack.Food_Punck.repositories.ProductPromotionRepository;
import org.ironhack.Food_Punck.repositories.ProductRepository;
import org.ironhack.Food_Punck.repositories.PromotionRepository;
import org.ironhack.Food_Punck.repositories.StoreRepository;
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
@RequestMapping(CommonConst.INDEX_STORE) // mapped to base + "/store" in CommonConst
public class StoreController {

	@Autowired
	private StoreRepository storeRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private PromotionRepository promoRepo;
	
	@Autowired
	private ProductPromotionRepository productPromoRepo;

	private final Logger logger = LoggerFactory.getLogger(StoreController.class);

	@GetMapping("/")
	public String hello() {
		return "Hello from the store backend.";
	}
	
	/* missing following methods to apply in future
	 * applyPromotion(Promotion promo) return ResponseEntity
	 * removePromotion(Promotion promo) return ResponseEntity
	 * updatePassword process?
	 */
	
	/// All 3 post mappings ///
	
	@PostMapping(CommonConst.URL_ADD_STORE) // base + "/store" + "/addStore"
	public ResponseEntity<Store> addStore(@RequestBody Store store){
		if (store != null) {
			return ResponseEntity.ok(this.storeRepo.save(store));
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping(CommonConst.URL_ADD_PRODUCT) // base + "/store" + "/addProduct"
	public ResponseEntity<Product> addProductToInventory(@RequestBody Product product){
		if (product != null) {
			return ResponseEntity.ok(this.productRepo.save(product));
		} else {
			return ResponseEntity.noContent().build();
		}
	}	
	@PostMapping(CommonConst.URL_ADD_PROMO) // base + "/store" + "/addPromo"
	public ResponseEntity<Promotion> addStore(@RequestBody Promotion promo){
		if (promo != null) {
			return ResponseEntity.ok(this.promoRepo.save(promo));
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	/// All 3 update mappings ///
	
	@PutMapping(CommonConst.URL_BY_STORE_ID) // base + "/store" + "/idStore/{id}"
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
	
	@PutMapping(CommonConst.URL_BY_PRODUCT_ID) // base + "/store" + "/idProduct/{id}"
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
	
	@PutMapping(CommonConst.URL_BY_PROMO_ID) // base + "/store" + "/idPromo/{id}"
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
	
	/// All 3 delete mappings ///
	
	@DeleteMapping(CommonConst.URL_BY_STORE_ID) // base + "/store" + "/idStore/{id}"
	public void deleteStore(@PathVariable int id) {
		this.storeRepo.deleteById(id);
	}
	
	@DeleteMapping(CommonConst.URL_BY_PRODUCT_ID) // base + "/store" + "/idProduct/{id}"
	public void deleteProductFromInventory(@PathVariable int id) {
		this.productRepo.deleteById(id);
	}
	
	@DeleteMapping(CommonConst.URL_BY_PROMO_ID) // base + "/store" + "/idPromo/{id}"
	public void deletePromo(@PathVariable int id) {
		this.promoRepo.deleteById(id);
	}
	
	/// All 3 get1 mappings ///
	
	@GetMapping(CommonConst.URL_BY_STORE_ID) // base + "/store" + "/idStore/{id}"
	public ResponseEntity<List<Store>> getStoreByID(@PathVariable int id) {
		List<Store> store = this.storeRepo.findByIdStore(id);
		if (store.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(store);
		}
	}
	
	@GetMapping(CommonConst.URL_BY_PRODUCT_ID) // base + "/store" + "/idProduct/{id}"
	public ResponseEntity<List<Product>> getProductByID(@PathVariable int id) {
		List<Product> product = this.productRepo.findByIdProduct(id);
		if (product.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(product);
		}
	}
	
	@GetMapping(CommonConst.URL_BY_PROMO_ID) // base + "/store" + "/idPromo/{id}"
	public ResponseEntity<List<Promotion>> getPromoByID(@PathVariable int id) {
		List<Promotion> promo = this.promoRepo.findByIdPromo(id);
		if (promo.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(promo);
		}
	}

	/// All 3 getAll mappings ///
	
	@GetMapping(CommonConst.URL_GET_ALL_STORES) // base + "/store" + "/allStores"
	public List<Store> getAllStores() {
		return this.storeRepo.findAll();
	}

	@GetMapping(CommonConst.URL_GET_ALL_PRODUCTS) // base + "/store" + "/allProducts"
	public List<Product> getAllProducts() {
		return this.productRepo.findAll();
	}
	
	@GetMapping(CommonConst.URL_GET_ALL_PROMOS) // base + "/store" + "/allPromos"
	public List<Promotion> getAllPromotions() {
		return this.promoRepo.findAll();
	}

}
