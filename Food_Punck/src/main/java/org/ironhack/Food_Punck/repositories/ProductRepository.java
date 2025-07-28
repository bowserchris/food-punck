package org.ironhack.Food_Punck.repositories;

import java.util.List;
import java.util.Optional;

import org.ironhack.Food_Punck.models.Product;
import org.ironhack.Food_Punck.util.CommonConst;
import org.ironhack.Food_Punck.util.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Table;

@Repository
@Table(name = CommonConst.MYSQL_TABLE_PRODUCTS)
public interface ProductRepository extends JpaRepository<Product, Integer> {

	Optional<Product> findByName(String name);
	Optional<Product> findByType(Enum<ProductType> type);
	List<Product> findByIdProduct(int idProduct);
	List<Product> findByIdStore(int idStore);
	
}
