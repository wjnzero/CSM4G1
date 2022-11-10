package com.management.cgmanagement.controller.login;

import com.management.cgmanagement.model.dto.JwtResponse;
import com.management.cgmanagement.model.entity.Role;
import com.management.cgmanagement.model.entity.User;
import com.management.cgmanagement.service.jwt.TokenService;
import com.management.cgmanagement.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin
public class Connect {
    @Autowired
    TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        try {
            // Tạo ra 1 đối tượng Authentication.
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = tokenService.createToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User currentUser = userService.findByEmail(user.getEmail());
            return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities()));
        } catch (Exception e) {
//            return ResponseEntity<Object>("Not Found User", HttpStatus.NO_CONTENT);
            return ResponseEntity.ok("Not Found User");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId(2L);
        roles.add(role);
        user.setRoleSet(roles);
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

}
