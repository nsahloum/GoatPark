package com.switchfully.goatpark.service;

import com.switchfully.goatpark.service.domain.person.Person;
import com.switchfully.goatpark.repository.member.MemberRepository;
import com.switchfully.goatpark.security.KeycloakService;
import com.switchfully.goatpark.security.KeycloakUserDTO;
import com.switchfully.goatpark.security.Role;
import com.switchfully.goatpark.service.dto.member.create.CreateMemberDto;
import com.switchfully.goatpark.service.dto.member.returndto.PersonDto;
import com.switchfully.goatpark.service.mapper.KeycloakMapper;
import com.switchfully.goatpark.service.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final KeycloakService keycloakService;
    private final MemberMapper memberMapper;
    private final KeycloakMapper keycloakMapper;

    public MemberService(MemberRepository memberRepository, KeycloakService keycloakService, MemberMapper memberMapper, KeycloakMapper keycloakMapper) {
        this.memberRepository = memberRepository;
        this.keycloakService = keycloakService;
        this.memberMapper = memberMapper;
        this.keycloakMapper = keycloakMapper;
    }

    public PersonDto registerMember(CreateMemberDto createMemberDto) {
        String keycloakId = addPersonToKeycloak(createMemberDto);
        Person person = memberMapper.map(createMemberDto);
        return memberMapper.map(memberRepository.registerMember(person), keycloakId);
    }

    private String addPersonToKeycloak(CreateMemberDto createMemberDto) {
        KeycloakUserDTO keycloakUserDTO = keycloakMapper.map(createMemberDto, Role.MEMBER);
        return keycloakService.addUser(keycloakUserDTO);
    }

    public List<Person> getAllMembers() {
//        return memberRepository.getAllMembers().stream().map(member -> memberMapper.map(member)).collect(Collectors.toList());
        return memberRepository.getAllMembers();

    }
}
