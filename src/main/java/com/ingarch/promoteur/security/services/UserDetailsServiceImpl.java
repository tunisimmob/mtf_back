package com.ingarch.promoteur.security.services;

import com.ingarch.promoteur.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ingarch.promoteur.models.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email));

		return UserDetailsImpl.build(user);
	}


	public boolean changePassword(String email, String password) {
		User user = findByEmail(email);
		user.setPassword(passwordEncoder.encode(password));
		if(save(user) != null) {
			return true;
		}
		return false;
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email).get();
	}

	public User save(User user){
		return userRepository.save(user);
	}
}
