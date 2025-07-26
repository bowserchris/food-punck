package org.ironhack.Food_Punck.repositories;

import java.util.List;
import java.util.Optional;

import org.ironhack.Food_Punck.models.ResultCompare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultCompareRepository extends JpaRepository<ResultCompare, Integer> {
	
	Optional<ResultCompare> findByUserId(int idUser);
	List<ResultCompare> findByIdResult(int idResult);

}
