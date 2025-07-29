package org.ironhack.Food_Punck.repositories;

import java.util.List;
import java.util.Optional;

import org.ironhack.Food_Punck.models.Store;
import org.ironhack.Food_Punck.util.CommonConst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Table;

@Repository
@Table(name = CommonConst.MYSQL_TABLE_STORES)
public interface StoreRepository extends JpaRepository<Store, Integer> {

	Optional<Store> findByEmail(String email);
	@Query("SELECT s FROM Store s WHERE s.address.idAddress = :idAddress")
	Optional<Store> findByAddressId(@Param(value = "idAddress") int idAddress);
	Optional<Store> findByName(String name);
	
}
