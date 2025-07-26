package org.ironhack.Food_Punck.repositories;

import java.util.Optional;

import org.ironhack.Food_Punck.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	Optional<Address> findByPostCode(String postCode);
	Optional<Address> findByStreet(String street);

}
