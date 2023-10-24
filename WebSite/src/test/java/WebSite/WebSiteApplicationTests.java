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
import WebSite.repositories.UserReopsitory;
import WebSite.services.UserService;
import jakarta.transaction.Transactional;

@SpringBootTest
class WebSiteApplicationTests {

	@Autowired
	UserService userSrv;
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
		Adresse a=new Adresse();
		a.setRue("blablablabla");
		a.setCodePostal("blabla");
		a.setNumero("34");
		u1.setAdresse(a);
		userSrv.create(u1);
	}
	
	

}
