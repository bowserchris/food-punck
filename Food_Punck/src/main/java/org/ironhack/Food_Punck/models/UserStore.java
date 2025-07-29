package org.ironhack.Food_Punck.models;

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
@Table(name = CommonConst.MYSQL_TABLE_USERS_STORES)
@IdClass(UserStoreId.class)
public class UserStore {

	@Id
	@Column(name = CommonConst.MYSQL_ID_USER)
	private int idUser;
	
	@Id
	@Column(name = CommonConst.MYSQL_ID_STORE)
	private int idStore;
	
	private Timestamp dateFollowed;
	private Timestamp dateUnFollowed;
	
}
