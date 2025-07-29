package org.ironhack.Food_Punck.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserStoreId implements Serializable {

	private int idUser;
	private int idStore;
}
