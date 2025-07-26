package org.ironhack.Food_Punck.models;

import java.sql.Timestamp;

import org.ironhack.Food_Punck.util.PromotionType;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Promotion {
	
	private int id;
	private String name;
	private PromotionType type;
	private double discountValue;
	private Store store;
	private boolean promoActive;
	private Timestamp dateCreated;
	private Timestamp dateApplied;
	private Timestamp dateExpired;
	
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
