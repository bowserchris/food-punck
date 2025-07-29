package org.ironhack.Food_Punck.models;

import java.io.Serializable;
import java.sql.Timestamp;

import org.ironhack.Food_Punck.util.CommonConst;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = CommonConst.MYSQL_TABLE_PRODUCTS_PROMOTIONS)
@IdClass(ProductPromotionId.class)
public class ProductPromotion implements Serializable {
	
	@Id
	@Column(name = CommonConst.MYSQL_ID_PRODUCT)
	private int idProduct;
	
	@Id
	@Column(name = CommonConst.MYSQL_ID_PROMOTION)
	private int idPromotion;
	
	private Timestamp dateApplied;
	private Timestamp dateExpired;

}
