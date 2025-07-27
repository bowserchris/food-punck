package org.ironhack.Food_Punck.models;

import java.sql.Timestamp;

import org.ironhack.Food_Punck.util.CommonConst;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = CommonConst.MYSQL_TABLE_USERS_PRODUCTS)		// User_has_Products
public class UsersHasProducts {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStore;
    
    @ManyToOne
    @JoinColumn(name = CommonConst.MYSQL_ID_USER, referencedColumnName = CommonConst.MYSQL_ID_USER)		// id_User
    private User user;

    @ManyToOne
    @JoinColumn(name = CommonConst.MYSQL_ID_PRODUCT, referencedColumnName = CommonConst.MYSQL_ID_PRODUCT)	// id_Product
    private Product product;

    @ManyToOne
    @JoinColumn(name = CommonConst.MYSQL_ID_STORE, referencedColumnName = CommonConst.MYSQL_ID_STORE)	// id_Store
    private Store store;
    
    private Timestamp dateCreated;
    private Timestamp dateModified;

}
