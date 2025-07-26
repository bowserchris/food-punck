package org.ironhack.Food_Punck.repositories;

import java.util.Optional;

import org.ironhack.Food_Punck.models.ResultCompare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultCompareRepository extends JpaRepository<ResultCompare, Integer> {
	
	Optional<ResultCompare> findByUserId(int idUser);

}
