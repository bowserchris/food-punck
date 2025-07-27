package org.ironhack.Food_Punck.models;

import java.sql.Timestamp;

import org.ironhack.Food_Punck.util.CommonConst;
import org.ironhack.Food_Punck.util.PromotionType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Promotion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private PromotionType type;
	private double discountValue;
	private boolean promoActive;
	private Timestamp dateCreated;
	private Timestamp dateApplied;
	private Timestamp dateExpired;
	
	@ManyToOne
	@JoinColumn(name = CommonConst.MYSQL_ID_STORE, referencedColumnName = CommonConst.MYSQL_ID_STORE)	/// promotion.idstore, store.idstore
	private Store store;
	
	// Receives Product.getCurrentPrice(), applies the discount price, then returns new value
	public double applyDiscount(double totalCurrentPrice) {
		double discountPriceTotal = totalCurrentPrice - (totalCurrentPrice * this.discountValue / 100);
		return discountPriceTotal;
	}
	
	// Receives Product.getCurrentPrice(), reverts the discount price, then returns the value
	public double revertDiscount(double totalDiscountPrice) {
		double revertedPrice = totalDiscountPrice / (1 - this.discountValue / 100);
		return revertedPrice;
	}

}
