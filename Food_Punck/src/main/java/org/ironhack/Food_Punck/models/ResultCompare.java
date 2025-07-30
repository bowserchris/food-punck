package org.ironhack.Food_Punck.models;

import java.sql.Timestamp;
import java.util.List;

import org.ironhack.Food_Punck.util.CommonConst;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = CommonConst.MYSQL_TABLE_RESULT_COMPARE)
public class ResultCompare {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String result;
	private String userComments;
	private Timestamp dateCreated;
	private Timestamp dateModified;
	
	@ManyToOne
	//@OneToMany
	@JoinTable(name = CommonConst.MYSQL_TABLE_USERS_PRODUCTS,
				joinColumns = @JoinColumn(name = CommonConst.MYSQL_ID_USER),
					inverseJoinColumns = @JoinColumn(name = CommonConst.MYSQL_ID_PRODUCT))
	// @JoinColumn(name = CommonConst.MYSQL_ID_USER, referencedColumnName = CommonConst.MYSQL_ID_USER)	/// result.iduser, user.iduser
	private User user;
	
	//// Unsure if whether or not to change this datatype to a list of List<>UsersHasProducts> ///
	@OneToMany
	@JoinTable(name = CommonConst.MYSQL_TABLE_USERS_PRODUCTS,
				joinColumns = @JoinColumn(name = CommonConst.MYSQL_ID_USER),
					inverseJoinColumns = @JoinColumn(name = CommonConst.MYSQL_ID_PRODUCT))
	private List<Product> listProducts;

}
