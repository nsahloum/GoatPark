package com.switchfully.goatpark.service.dto.member;

import com.switchfully.goatpark.domain.person.Role;

public record KeycloakUserDTO (String userName, String password, Role role){
}