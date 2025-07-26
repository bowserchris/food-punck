package org.ironhack.Food_Punck.models;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	private String name;
	private String lastName1;
	private String lastName2;
	private String email;
	private String password;
	private Timestamp dateCreated;
	private Address address;
	private List<Store> storesFollowed;
	private List<Product> productsFollowed;
	private List<ResultCompare> comparativeResults;
	private List<Review> userReviews;
	
	/// BELOW ARE 12 METHODS TO ADD,UPDATE AND REMOVE THE 4 LISTS ///
	
	public void addResult(ResultCompare result) {
		this.getComparativeResults().add(result);
	}
	
	public void updateResult(ResultCompare result) {
		int index = this.getComparativeResults().indexOf(result);
		this.getComparativeResults().set(index, result);
	}
	
	public void followStore(Store store) {
		this.getStoresFollowed().add(store);
	}
	
	public void updateFollowedStore(Store store) {
		int index = this.getStoresFollowed().indexOf(store);
		this.getStoresFollowed().set(index, store);
	}
	
	public void removeFollowedStore(Store store) {
		this.getStoresFollowed().remove(store);
	}
	
	public void followProduct(Product product) {
		this.getProductsFollowed().add(product);
	}
	
	public void updateFollowedProduct(Product product) {
		int index = this.getProductsFollowed().indexOf(product);
		this.getProductsFollowed().set(index, product);
	}
	
	public void removeFollowedProduct(Product product) {
		this.getProductsFollowed().remove(product);
	}
	
	public void addReview(Review review) {
		this.getUserReviews().add(review);
	}
	
	public void updateReview(Review review) {
		int index = this.getUserReviews().indexOf(review);
		this.getUserReviews().set(index, review);
	}
	
	public void removeReview(Review review) {
		this.getUserReviews().remove(review);
	}
	
}
