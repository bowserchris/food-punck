package org.ironhack.Food_Punck.repositories;

import java.util.List;
import java.util.Optional;

import org.ironhack.Food_Punck.models.ResultCompare;
import org.ironhack.Food_Punck.models.UserProducts;
import org.ironhack.Food_Punck.util.CommonConst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Table;

@Repository
@Table(name = CommonConst.MYSQL_TABLE_USERS_PRODUCTS)
public interface UserProductRepository extends JpaRepository<UserProducts, Integer> {
	
	Optional<UserProducts> findByUserId(int idUser);
	List<UserProducts> findByProductId(int idProduct);
	
	@Query(value = "SELECT * FROM Users_has_Products WHERE id_user = ?1 AND product_id = ?2", nativeQuery = true)
	List<UserProducts> findByUserProductId(int idUser, int idProduct);

}
