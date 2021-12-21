package com.ingarch.promoteur.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingarch.promoteur.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Optional<User> findByEmail(String email);


	Boolean existsByUsername(String username);

	Boolean existsByPassword(String password);

	Boolean existsByEmail(String email);

	Optional<User> findUserById(Long id);

	List<User> findUserByRolesId(Integer id);


//	@Transactional
//	public User validateUser(String Username, String password) {
//		return User.validateUser(Username, password);
//	}}

}

