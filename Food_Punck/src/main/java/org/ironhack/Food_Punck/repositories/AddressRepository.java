package org.ironhack.Food_Punck.repositories;

import java.util.List;
import java.util.Optional;

import org.ironhack.Food_Punck.models.Address;
import org.ironhack.Food_Punck.util.CommonConst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Table;

@Repository
@Table(name = CommonConst.MYSQL_TABLE_ADDRESSES)
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	Optional<Address> findByPostCode(String postCode);
	Optional<Address> findByStreet(String street);

}
