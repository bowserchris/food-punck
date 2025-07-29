package org.ironhack.Food_Punck.repositories;

import java.util.List;
import java.util.Optional;

import org.ironhack.Food_Punck.models.Promotion;
import org.ironhack.Food_Punck.util.CommonConst;
import org.ironhack.Food_Punck.util.PromotionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Table;

@Repository
@Table(name = CommonConst.MYSQL_TABLE_PROMOTIONS)
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

	Optional<Promotion> findByName(String name);
	Optional<Promotion> findByType(Enum<PromotionType> type);
	
}
