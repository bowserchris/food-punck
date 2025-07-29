package org.ironhack.Food_Punck.repositories;

import java.util.List;
import java.util.Optional;

import org.ironhack.Food_Punck.models.ResultCompare;
import org.ironhack.Food_Punck.util.CommonConst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Table;

@Repository
@Table(name = CommonConst.MYSQL_TABLE_RESULT_COMPARE)
public interface ResultCompareRepository extends JpaRepository<ResultCompare, Integer> {
	
	Optional<ResultCompare> findByUserId(int idUser);
	List<ResultCompare> findByListProductsId(int idProduct);
	
	@Query(value = "SELECT * FROM Result_Comparative_Log WHERE id_user = ?1 AND product_id = ?2", nativeQuery = true)
	List<ResultCompare> findByUserProductId(int idUser, int idProduct);

}
