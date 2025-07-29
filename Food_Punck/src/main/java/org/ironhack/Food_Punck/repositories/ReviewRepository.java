package org.ironhack.Food_Punck.repositories;

import java.util.List;
import java.util.Optional;

import org.ironhack.Food_Punck.models.Review;
import org.ironhack.Food_Punck.util.CommonConst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Table;

@Repository
@Table(name = CommonConst.MYSQL_TABLE_REVIEWS)
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
	Optional<Review> findByTitle(String title);
	Optional<Review> findByStoreId(int idStore);
//	List<Review> findByIdReview(int idReview);

}
