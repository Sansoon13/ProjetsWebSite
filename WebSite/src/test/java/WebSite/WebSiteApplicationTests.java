package WebSite;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import WebSite.entities.Adresse;
import WebSite.entities.Role;
import WebSite.entities.User;
import WebSite.repositories.ProductRepository;
import WebSite.repositories.UserRepository;
import WebSite.services.ProductService;
import WebSite.services.UserService;
import jakarta.transaction.Transactional;

@SpringBootTest
class WebSiteApplicationTests {

	@Autowired
	UserService userSrv;
	@Autowired
	ProductRepository prepo;
	@Autowired
	ProductService proSrv;
	@Autowired
	PasswordEncoder psE;
	
	@Test
	@Transactional
	@Commit
	@Disabled
	void contextLoads() {
		Adresse a=new Adresse(); 
		a.setRue("blablablabla");
		a.setCodePostal("blabla");
		a.setNumero("34");
		
		User u1=new User();
		u1.setEmail("admin@email.fr");
		u1.setPassword(psE.encode("admin"));
		u1.setUsername("admin");
		u1.setRole(Role.ADMIN);
		u1.setDateEntry(LocalDate.now());
		u1.setFirstName("Admin");
		u1.setLastName("Admin");
		
		
//		User u2=new User();
//		u2.setEmail("user2@email.fr");
//		u2.setPassword(psE.encode("azerty"));
//		u2.setUsername("user2");
//		u2.setDateEntry(LocalDate.now());
//		u2.setRole(Role.ROle_USER);
//		
//		u2.setAdresse(a);
		u1.setAdresse(a);
		
		userSrv.create(u1);
		//userSrv.create(u2);
	}
	@Test
	@Disabled
	void testRepo(){
		prepo.findByIdFetchIngredients(1L);
		proSrv.findByIdWithEvaluations(2L);
		
		System.out.println(prepo.findByIdFetchIngredients(1L).get().getIngredients());
		System.out.println(proSrv.findByIdWithEvaluations(2L).getEvaluations());
	}
	
	

}
