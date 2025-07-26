package org.ironhack.Food_Punck.repositories;

import java.util.List;
import java.util.Optional;

import org.ironhack.Food_Punck.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
	Optional<Review> findByTitle(String title);
	Optional<Review> findByStore(int idStore);
	List<Review> findByIdReview(int idReview);

}
