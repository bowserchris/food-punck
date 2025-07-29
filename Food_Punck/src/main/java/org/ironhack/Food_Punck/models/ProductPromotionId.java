package org.ironhack.Food_Punck.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductPromotionId implements Serializable {
	
	private int idProduct;
	private int idPromotion;

}
