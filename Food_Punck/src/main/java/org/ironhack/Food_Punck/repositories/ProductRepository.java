package org.ironhack.Food_Punck.repositories;

import java.util.Optional;

import org.ironhack.Food_Punck.models.Product;
import org.ironhack.Food_Punck.util.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Optional<Product> findByName(String name);
	Optional<Product> findByType(Enum<ProductType> type);
	
}
