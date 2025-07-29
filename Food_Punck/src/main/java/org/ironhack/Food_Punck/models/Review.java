package org.ironhack.Food_Punck.models;

import org.ironhack.Food_Punck.util.CommonConst;

import jakarta.persistence.Column;
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
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_Review")
	private int id;
	private String title;
	private String text;
	private int valueRanking;
	
	@ManyToOne
	@JoinColumn(name = CommonConst.MYSQL_ID_USER, referencedColumnName = CommonConst.MYSQL_ID_USER) /// reviews.iduser, user.iduser
	private User user;
	
	@ManyToOne
	@JoinColumn(name = CommonConst.MYSQL_ID_STORE, referencedColumnName = CommonConst.MYSQL_ID_STORE) /// reviews.idstore, store.idstore
	private Store store;
	
}
