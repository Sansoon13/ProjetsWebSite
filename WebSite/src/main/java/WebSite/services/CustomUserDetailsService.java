package WebSite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import WebSite.repositories.UserReopsitory;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserReopsitory userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepo.findByUsername(username).orElseThrow(() -> {
			throw new UsernameNotFoundException("utilisateur inconnu");
		});
	}

}
