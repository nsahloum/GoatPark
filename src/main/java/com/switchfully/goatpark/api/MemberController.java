package com.switchfully.goatpark.api;

import com.switchfully.goatpark.service.MemberService;
import com.switchfully.goatpark.service.domain.person.Person;
import com.switchfully.goatpark.service.dto.member.create.CreateMemberDto;
import com.switchfully.goatpark.service.dto.member.returndto.PersonDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping(path = "/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto register(@RequestBody CreateMemberDto createMemberDto) {
        return memberService.registerMember(createMemberDto);
    }

    @GetMapping(produces = "application/json" )
    @PreAuthorize("hasAnyAuthority('GET_ALL_MEMBERS')")
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getAllMembers() {
        return memberService.getAllMembers();
    }
}
