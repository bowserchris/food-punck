package org.ironhack.Food_Punck.repositories;

import java.util.List;
import java.util.Optional;

import org.ironhack.Food_Punck.models.UserStore;
import org.ironhack.Food_Punck.models.UserStoreId;
import org.ironhack.Food_Punck.util.CommonConst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Table;

@Repository
@Table(name= CommonConst.MYSQL_TABLE_USERS_STORES)
public interface UserStoreRepository extends JpaRepository<UserStore, UserStoreId> {
	
	Optional<UserStore> findByIdUser(@Param("id_User") int idUser);
	Optional<UserStore> findByIdStore(@Param("id_Store") int idStore);
	
//	@Query("SELECT * FROM Users_follow_Stores ufs"
//			+ "INNER JOIN User u ON ufs.id_User = u.id_User WHERE ufs.id_User = :id_User"
//			+ "INNER JOIN Stores s ON ufs.id_Store = s.id_Store WHERE ufs.id_Store = :id_Store")
	
	@Query(value = "SELECT * FROM Users_follow_Stores WHERE id_user = ?1 AND id_store = ?2", nativeQuery = true)
	List<UserStoreId> findByUserStoreId(@Param("id_User") int idUser, @Param("id_Store") int idStore);

}
