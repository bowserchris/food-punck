package org.ironhack.Food_Punck.models;

import java.sql.Timestamp;
import java.util.List;

import org.ironhack.Food_Punck.util.CommonConst;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "Stores")
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_Store")
	private int id;
	private String name;
	private String email;
	private String password;
	private Timestamp dateCreated;
	
	@OneToOne
	@JoinColumn(name = CommonConst.MYSQL_ID_ADDRESS, referencedColumnName = CommonConst.MYSQL_ID_ADDRESS) // 	store."id_Address",address."id_Address"
	private Address address;
	
//	@OneToMany(mappedBy = "store")	/// either its referencing this list attribute below, or change to "store" for within hte Promotion.class Store "store" attribute
//	private List<Promotion> promotions;
//
//	@OneToMany(mappedBy = "store")
////	@JoinTable(name = CommonConst.MYSQL_TABLE_STORES_INVENTORY, 					/// Store_Inventory, .idstore, .idproduct 
////				joinColumns = @JoinColumn(name = CommonConst.MYSQL_ID_STORE), 
////					inverseJoinColumns = @JoinColumn(name = CommonConst.MYSQL_ID_PRODUCT))
//	private List<Product> inventory;
	
//	@ManyToOne
//	@JoinColumn(name = CommonConst.MYSQL_ID_STORE, referencedColumnName = CommonConst.MYSQL_ID_STORE)
	
//	public void addToInventory(Product product) {
//		this.getInventory().add(product);
//	}
//	
//	public void updateInventroy(Product product) {
//		int index = this.getInventory().indexOf(product);
//		this.getInventory().set(index, product);
//	}
//	
//	public void removeFromInvetory(Product product) {
//		this.getInventory().remove(product);
//	}
//	
//	public void addPromotion(Promotion promotion) {
//		this.getPromotions().add(promotion);
//	}
//	
//	public void updatePromotion(Promotion promotion) {
//		int index = this.getPromotions().indexOf(promotion);
//		this.getPromotions().set(index, promotion);
//	}
//	
//	public void removePromotion(Promotion promotion) {
//		this.getPromotions().remove(promotion);
//	}
	
	
	
}
