package com.aluracursos.forohub.infra.security;

public record TokenResponseDTO(
        String token,
        String tokenType
){
}
