package org.ironhack.Food_Punck.repositories;

import java.util.List;
import java.util.Optional;

import org.ironhack.Food_Punck.models.UserStore;
import org.ironhack.Food_Punck.models.UserStoreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserStoreRepository extends JpaRepository<UserStore, UserStoreId> {
	
	Optional<UserStore> findByUserId(@Param("id_User") int idUser);
	Optional<UserStore> findByStoreId(@Param("id_Store") int idStore);
	
	@Query("SELECT * FROM Users_follow_Stores ufs"
			+ "INNER JOIN User u ON ufs.id_User = u.id_User WHERE ufs.id_User = :id_User"
			+ "INNER JOIN Stores s ON ufs.id_Store = s.id_Store WHERE ufs.id_Store = :id_Store")
	List<UserStoreId> findByUserAndStoreId(@Param("id_User") int idUser, @Param("id_Store") int idStore);

}
