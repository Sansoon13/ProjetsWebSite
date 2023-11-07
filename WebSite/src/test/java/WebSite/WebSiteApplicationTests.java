package WebSite;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import WebSite.entities.Adresse;
import WebSite.entities.User;
import WebSite.repositories.ProductRepository;
import WebSite.repositories.UserReopsitory;
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
		User u1=new User();
		u1.setEmail("user@email.fr");
		u1.setPassword(psE.encode("azerty"));
		u1.setUsername("user1");
		User u2=new User();
		u2.setEmail("user2@email.fr");
		u2.setPassword(psE.encode("azerty"));
		u2.setUsername("user2");
		Adresse a=new Adresse(); 
		a.setRue("blablablabla");
		a.setCodePostal("blabla");
		a.setNumero("34");
		u1.setAdresse(a);
		userSrv.create(u1);
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
