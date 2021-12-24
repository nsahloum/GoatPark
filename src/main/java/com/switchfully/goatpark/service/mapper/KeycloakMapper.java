package com.switchfully.goatpark.service.mapper;

import com.switchfully.goatpark.service.dto.member.KeycloakUserDTO;
import com.switchfully.goatpark.domain.person.Role;
import com.switchfully.goatpark.service.dto.member.create.CreateMemberDto;
import org.springframework.stereotype.Component;

@Component
public class KeycloakMapper {

    public KeycloakUserDTO map(CreateMemberDto createMemberDto, Role role) {
        return new KeycloakUserDTO(
                createMemberDto.username(),
                createMemberDto.password(),
                role);
    }
}
