package org.ironhack.Food_Punck.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Review {
	
	private int id;
	private String title;
	private String text;
	private int valueRanking;
	private Store Store;
	
}
