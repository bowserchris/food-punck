package org.ironhack.Food_Punck.repositories;

import java.util.List;
import java.util.Optional;

import org.ironhack.Food_Punck.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {

	Optional<Store> findByEmail(String email);
	Optional<Store> findByAddress(int idAddress);
	Optional<Store> findByName(String name);
	List<Store> findByIdStore(int idStore);
	
}
