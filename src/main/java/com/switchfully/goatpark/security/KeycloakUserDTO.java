package com.switchfully.goatpark.security;

public record KeycloakUserDTO (String userName, String password, Role role){
}