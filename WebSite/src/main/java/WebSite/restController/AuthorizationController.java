package WebSite.restController;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
@RestController
public class AuthorizationController {

	  @GetMapping("/admin/resource")
	  @PreAuthorize("hasAuthority('READ_PRIVILEGE') and hasRole('ADMIN')")
	  public ResponseEntity<String> sayHelloWithRoleAdminAndReadAuthority() {
	    return ResponseEntity.ok("Hello, you have access to a protected resource that requires admin role and read authority.");
	 }
	 
	  @DeleteMapping("/admin/resource")
	  @PreAuthorize("hasAuthority('DELETE_PRIVILEGE') and hasRole('ADMIN')")
	  public ResponseEntity<String> sayHelloWithRoleAdminAndDeleteAuthority() {
	    return ResponseEntity.ok("Hello, you have access to a protected resource that requires admin role and delete authority.");
	 }
	  @PostMapping("/user/resource")
	  @PreAuthorize("hasAuthority('CREATE_PRIVILEGE') and hasRole('USER')")
	  public ResponseEntity<String> sayHelloWithRoleUserAndCreateAuthority() {
	    return ResponseEntity.ok("Hello, you have access to a protected resource that requires user role and create authority.");
	 }
	  @PutMapping("/user/resource")
	  @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE') and hasRole('USER')")
	  public ResponseEntity<String> sayHelloWithRoleUserAndUpdateAuthority() {
	    return ResponseEntity.ok("Hello, you have access to a protected resource that requires user role and update authority.");
	 }

	
	
}
