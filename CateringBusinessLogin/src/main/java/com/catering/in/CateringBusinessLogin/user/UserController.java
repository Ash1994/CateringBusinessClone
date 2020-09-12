package com.catering.in.CateringBusinessLogin.user;

import com.catering.in.CateringBusinessLogin.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@Slf4j
public class UserController {

    private final IUserService svc;
    UserController(IUserService svc) {
        this.svc = svc;
    }

    @GetMapping("/")
    private ResponseEntity<?> siteUp() {
        log.info("Site Is Ready to Use:: {}");
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/user/getById/{id}")
    private ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = svc.getUserById(id);
        log.info("user:: {}", user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/user")
    private String getUserById(@RequestBody User user) {
        svc.saveAll(user);
        return "Created";
    }

    @GetMapping("/principal")
    public Principal user(Principal principal) {
        return principal;
    }

}
