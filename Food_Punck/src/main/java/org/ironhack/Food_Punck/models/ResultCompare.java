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
public class ResultCompare {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String result;
	private String userComments;
	private User user;
	private List<Product> listProducts;
	private Timestamp dateCreated;
	private Timestamp dateModified;

}
