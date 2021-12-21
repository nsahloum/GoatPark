package com.switchfully.goatpark.service;

import com.switchfully.goatpark.domain.person.Person;
import com.switchfully.goatpark.repository.member.MemberRepository;
import com.switchfully.goatpark.security.KeycloakService;
import com.switchfully.goatpark.security.KeycloakUserDTO;
import com.switchfully.goatpark.service.dto.member.CreateMemberDto;
import org.springframework.stereotype.Service;

@Service
public class DefaultMemberService implements MemberService{

    private final MemberRepository memberRepository;
    private final KeycloakService keycloakService;
    private final MemberMapper memberMapper;

    public DefaultMemberService(MemberRepository memberRepository, KeycloakService keycloakService) {
        this.memberRepository = memberRepository;
        this.keycloakService = keycloakService;
    }

    @Override
    public int registerMember(CreateMemberDto createMemberDto) {
        KeycloakUserDTO keycloakUserDTO = memberMapper.map(createMemberDto);
        keycloakService.addUser();
        Person person = memberMapper.map(createMemberDto);
        return memberRepository.registerMember(person).getId();
    }
}
