package WebSite.entities;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import WebSite.restController.UserRestController;

import  static WebSite.entities.Privilege.*;
import jakarta.security.auth.message.config.RegistrationListener;
import lombok.Getter;

public enum Role {

	USER(Set.of(READ_PRIVILEGE))
	,ADMIN(Set.of(READ_PRIVILEGE,
			WRITE_PRIVILEGE,
			DELETE_PRIVILEGE,
			UPDATE_PRIVILEGE));
	
	
	private Role() {
		// TODO Auto-generated constructor stub
	}
	private Role(Set<Privilege> privileges) {
				this.privileges = privileges;
			}

	private Set<Privilege> privileges;
	
	public List<SimpleGrantedAuthority> getAuthorities(){
		List<SimpleGrantedAuthority> authorities=getPrivileges().stream().map(p->new SimpleGrantedAuthority(p.name())).toList();
		System.out.println("___"+this.name());
		System.out.println(authorities);
		authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name())); 
		return authorities;
	}

	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	
}
