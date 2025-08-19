package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.user.AuthenticationDTO;
import com.aluracursos.forohub.domain.user.User;
import com.aluracursos.forohub.infra.security.TokenResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import com.aluracursos.forohub.infra.security.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity<TokenResponseDTO> login(@RequestBody @Valid AuthenticationDTO AuthenticationData) {
        Authentication authToken  = new UsernamePasswordAuthenticationToken(AuthenticationData.login(), AuthenticationData.password());
        Authentication authenticatedUser  = this.manager.authenticate(authToken);
        String tokenJWT = this.tokenService.generateToken((User) authenticatedUser.getPrincipal());
        return ResponseEntity.ok(new TokenResponseDTO(tokenJWT, "Bearer"));
    }
}
