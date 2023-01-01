package com.example.cakeExamBackend.Services;

import com.example.cakeExamBackend.Models.JwtRequest;
import com.example.cakeExamBackend.Models.JwtResponse;
import com.example.cakeExamBackend.Models.UserModel;
import com.example.cakeExamBackend.Repositories.UserRepo;
import com.example.cakeExamBackend.Security.SImplementations.AuthImpl;
import com.example.cakeExamBackend.Security.SImplementations.UserDetailsImpl;
import com.example.cakeExamBackend.Security.SUtilities.JwtUtil;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
   private AuthImpl auth;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception { //JWT Token létrehozása
        System.out.println("Tried creating a JWT token");
        String loginUserName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();

        System.out.println("Tried username in JWTToken: "+loginUserName); //TESTING <--
        System.out.println("Tried password in JWTToken: "+userPassword);
        UserDetails userDetails = loadUserByUsername(loginUserName);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        UserModel user = userRepo.findByuserName(loginUserName).get();
        return new JwtResponse(user, newGeneratedToken);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> user = userRepo.findByuserName(username);

        UserModel u = user.orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        return new UserDetailsImpl(u);
    }
}
