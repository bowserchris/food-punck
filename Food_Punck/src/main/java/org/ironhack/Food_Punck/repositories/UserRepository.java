package org.ironhack.Food_Punck.repositories;

import java.util.List;
import java.util.Optional;

import org.ironhack.Food_Punck.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	Optional<User> findByEmail(String email);
	Optional<User> findByAddress(int idAddress);
	Optional<User> findByName(String firstName);
	Optional<User> findByUserName(String userName);
	List<User> findByIdUser(int idUser);

}
