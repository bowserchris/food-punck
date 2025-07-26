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
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String password;
	private Timestamp dateCreated;
	private Address address;
	private List<Product> inventory;
	private List<Promotion> promotions;
	
	public void addToInventory(Product product) {
		this.getInventory().add(product);
	}
	
	public void updateInventroy(Product product) {
		int index = this.getInventory().indexOf(product);
		this.getInventory().set(index, product);
	}
	
	public void removeFromInvetory(Product product) {
		this.getInventory().remove(product);
	}
	
	public void addPromotion(Promotion promotion) {
		this.getPromotions().add(promotion);
	}
	
	public void updatePromotion(Promotion promotion) {
		int index = this.getPromotions().indexOf(promotion);
		this.getPromotions().set(index, promotion);
	}
	
	public void removePromotion(Promotion promotion) {
		this.getPromotions().remove(promotion);
	}
	
	
	
}
