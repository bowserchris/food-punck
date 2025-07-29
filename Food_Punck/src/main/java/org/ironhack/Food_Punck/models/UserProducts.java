package org.ironhack.Food_Punck.models;

import java.sql.Timestamp;

import org.ironhack.Food_Punck.util.CommonConst;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = CommonConst.MYSQL_TABLE_USERS_PRODUCTS)
public class UserProducts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_User_Product")
	private int id;
	private Timestamp dateCreated;
	private Timestamp dateModified;
	
	@ManyToOne
	@JoinColumn(name = CommonConst.MYSQL_ID_USER, referencedColumnName = CommonConst.MYSQL_ID_USER) /// reviews.iduser, user.iduser
	private User user;
	
	@ManyToOne
	@JoinColumn(name = CommonConst.MYSQL_ID_PRODUCT, referencedColumnName = CommonConst.MYSQL_ID_PRODUCT) /// reviews.idstore, store.idstore
	private Product product;

}
