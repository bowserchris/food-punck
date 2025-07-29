package org.ironhack.Food_Punck.models;

import java.sql.Timestamp;
import java.util.List;

import org.ironhack.Food_Punck.util.CommonConst;
import org.ironhack.Food_Punck.util.ProductType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private ProductType type;
	private double price;
	private float weight;
	private boolean discount;
	private Timestamp dateDelivered;
	private Timestamp dateExpired;
	private float quantity;
	private Timestamp datePurchased;
	private Timestamp dateSold;
	
//	@JoinTable(name = CommonConst.MYSQL_TABLE_STORES_INVENTORY, 					/// Store_Inventory, .idstore, .idproduct 
//				joinColumns = @JoinColumn(name = CommonConst.MYSQL_ID_STORE), 
//					inverseJoinColumns = @JoinColumn(name = CommonConst.MYSQL_ID_PRODUCT))
	@ManyToOne
	@JoinColumn(name = CommonConst.MYSQL_ID_STORE, referencedColumnName = CommonConst.MYSQL_ID_STORE)
	private Store store;
	
	@ManyToMany
	@JoinTable(name = CommonConst.MYSQL_TABLE_PRODUCTS_PROMOTIONS,		/// Products_has_Promotions, .idProduct, .idPromotion 
				joinColumns = @JoinColumn(name = CommonConst.MYSQL_ID_PRODUCT),
					inverseJoinColumns = @JoinColumn(name = CommonConst.MYSQL_ID_PROMOTION))
	private List<Promotion> promotions;
	
	// If quantity has value above 0, calculates and return total by units, otherwise by weight and updates it
	public double calculateTotalPrice(int quantity, float currentWeight) {
		if (quantity == 0) {
			this.setWeight(currentWeight);
			this.setPrice(this.price * currentWeight);
		} else {
			this.setPrice(this.price * quantity);
		}
		return this.getPrice();
	}
	
	// Add logic here to call alterPriceWithDiscount when its been applied? Or Above?
	public boolean applyDiscountToProduct() {
		this.setDiscount(true);
		return this.isDiscount();
	}
	
	public boolean removeDiscountFromProduct() {
		this.setDiscount(false);
		return this.isDiscount();
	}
	
	// Receives Promotion, looks up if product lists it, gets the promo, applys the discount and calls its method
	public void alterPriceWithDiscount(Promotion promotion) {
		int index = this.getPromotions().indexOf(promotion);
		Promotion promo = this.getPromotions().get(index);
		this.setPrice(promo.applyDiscount(this.getPrice()));
	}
	
	// The inverse to the above method
	public void revertPriceWithoutDiscount(Promotion promotion) {
		int index = this.getPromotions().indexOf(promotion);
		Promotion promo = this.getPromotions().get(index);
		this.setPrice(promo.revertDiscount(this.getPrice()));
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
