package org.ironhack.Food_Punck.models;

import java.sql.Timestamp;

import org.ironhack.Food_Punck.util.CommonConst;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_User")
	private int id;
	@Column(nullable = false)
	private String userName;
	@Column(nullable = false)
	private String name;
	private String lastName1;
	private String lastName2;
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = true)
	private Timestamp dateCreated;
	
	@OneToOne
	@JoinColumn(name = CommonConst.MYSQL_ID_ADDRESS, 
				referencedColumnName = CommonConst.MYSQL_ID_ADDRESS, 
				nullable = true) // 	user."id_Address",address."id_Address"
	private Address address;
	
//	@ManyToMany
//	@JoinTable(name = CommonConst.MYSQL_TABLE_USERS_STORES, 					/// Users_follow_Stores, .iduser, .idStore 
//				joinColumns = @JoinColumn(name = CommonConst.MYSQL_ID_USER), 
//					inverseJoinColumns = @JoinColumn(name = CommonConst.MYSQL_ID_STORE))
//	private List<Store> storesFollowed;
	
	//// Unsure if whether or not to change this datatype to a list of List<>UsersHasProducts> ///
//	@OneToMany
//	@JoinTable(name = CommonConst.MYSQL_TABLE_USERS_PRODUCTS,
//				joinColumns = @JoinColumn(name = CommonConst.MYSQL_ID_USER),
//					inverseJoinColumns = @JoinColumn(name = CommonConst.MYSQL_ID_PRODUCT))
//	private List<Product> productsFollowed;
	
//	@OneToMany(mappedBy = "user") ///Either its "comparativeResults" from below, or change to "user" for within the ResultCompare.class User "user" attribute
//	private List<ResultCompare> comparativeResults;
//	
//	@OneToMany(mappedBy = "user")	/// Either its "userReviews" for the list below, or change to "user" for within the Review.class User "user" attribute
//	private List<Review> userReviews;
	
//	@ManyToOne
//	@JoinColumn(name = CommonConst.MYSQL_ID_STORE, referencedColumnName = CommonConst.MYSQL_ID_STORE)
	
	/// BELOW ARE 12 METHODS TO ADD,UPDATE AND REMOVE THE 4 LISTS ///
	
//	public void addResult(ResultCompare result) {
//		this.getComparativeResults().add(result);
//	}
//	
//	public void updateResult(ResultCompare result) {
//		int index = this.getComparativeResults().indexOf(result);
//		this.getComparativeResults().set(index, result);
//	}
//	
//	public void followStore(Store store) {
//		this.getStoresFollowed().add(store);
//	}
//	
//	public void updateFollowedStore(Store store) {
//		int index = this.getStoresFollowed().indexOf(store);
//		this.getStoresFollowed().set(index, store);
//	}
//	
//	public void removeFollowedStore(Store store) {
//		this.getStoresFollowed().remove(store);
//	}
//	
//	public void followProduct(Product product) {
//		this.getProductsFollowed().add(product);
//	}
//	
//	public void updateFollowedProduct(Product product) {
//		int index = this.getProductsFollowed().indexOf(product);
//		this.getProductsFollowed().set(index, product);
//	}
//	
//	public void removeFollowedProduct(Product product) {
//		this.getProductsFollowed().remove(product);
//	}
//	
//	public void addReview(Review review) {
//		this.getUserReviews().add(review);
//	}
//	
//	public void updateReview(Review review) {
//		int index = this.getUserReviews().indexOf(review);
//		this.getUserReviews().set(index, review);
//	}
//	
//	public void removeReview(Review review) {
//		this.getUserReviews().remove(review);
//	}
//	
}
