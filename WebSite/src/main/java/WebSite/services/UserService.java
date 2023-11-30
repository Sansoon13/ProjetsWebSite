package WebSite.services;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import WebSite.entities.User;
import WebSite.exceptions.UserException;
import WebSite.repositories.UserRepository;
import jakarta.persistence.Access;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PasswordEncoder psE;
	
	//Authentification de l'utilisateur
	public Optional<User> Authentification(String username,String password) {
		if(username==null || password==null) {
			throw new UserException("username or password is null");
		}
		Optional<User> optUser=userRepo.findByUsername(username);
		if(optUser.isPresent() && psE.matches(password, optUser.get().getPassword())){
			System.out.println("authentification réussi");
			return optUser;
		}
		System.out.println("authentification échoué");
		return Optional.empty();
	}
	
	//Création d'un nouvel utilisateur
	public User create(User user) {
		
		if(userRepo.findByUsername(user.getUsername()).isPresent()) {
			throw new UserException("username already taken");
		}
		if(userRepo.findByEmail(user.getEmail()).isPresent()) {
			throw new UserException("Email already taken");
		}
		user.setPassword(psE.encode(user.getPassword()));
		user.setDateEntry(LocalDate.now());
		return userRepo.save(user);
	}
	
	//Actualisation / modification des informations
	public User update(User user) {
		if(user.getId()==null) {
			throw new UserException("Id cannot be null");
		}
		Optional<User> userOpt=userRepo.findById(user.getId());
		if(userOpt.isPresent()) {
			User foundUser=userOpt.get();
			if(!foundUser.getUsername().equals(user.getUsername()) && !userRepo.findByUsername(user.getUsername()).isPresent()) {
				foundUser.setUsername(user.getUsername());
			}
			if(!foundUser.getEmail().equals(user.getEmail()) && !userRepo.findByEmail(user.getEmail()).isPresent()) {
				foundUser.setEmail(user.getEmail());
			}
			if(!foundUser.getFirstName().equals(user.getFirstName()) && !userRepo.findByFirstName(user.getFirstName()).isPresent()) {
				foundUser.setFirstName(user.getFirstName());
			}
			if(!foundUser.getPassword().isEmpty() && !psE.matches(foundUser.getPassword(),user.getPassword() )) {
				foundUser.setPassword(psE.encode(user.getPassword()));
			}else {
				throw new UserException("new password same old password");
			}
				userRepo.save(foundUser);
		}
		throw new UserException(user.getId());
	}
	
	//image
	public User store(MultipartFile file,Long id) throws IOException {
		Optional<User> optUser=userRepo.findById(id);
		if(optUser.isPresent()) {
			User user=optUser.get();
			user.setImage(file.getBytes());
			return userRepo.save(user);
		}
		throw new UserException(id);	
	}
	public User findByIdFecthEvaluations(Long id) {
		if(id==null) {
			throw new UserException(id);
		}
		return userRepo.findByIdFetchEvaluations(id).orElseThrow(()->{
			throw new UserException(id);
		});
	}
	
	public User findById(Long id) {
		if(id==null) {
			throw new UserException("id cannot be null");
		}
		return userRepo.findById(id).orElseThrow(()->{
			throw new UserException(id);
		});
	}
	
}
