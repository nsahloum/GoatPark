package com.switchfully.goatpark.api;

import com.switchfully.goatpark.service.MemberService;
import com.switchfully.goatpark.service.dto.member.create.CreateMemberDto;
import com.switchfully.goatpark.service.dto.member.returndto.MembersDto;
import com.switchfully.goatpark.service.dto.member.returndto.PersonDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/members", produces = APPLICATION_JSON_VALUE)
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto register(@RequestBody CreateMemberDto createMemberDto) {
        return memberService.registerMember(createMemberDto);
    }


    @GetMapping
    @PreAuthorize("hasAuthority('GET_ALL_MEMBERS')")
    @ResponseStatus(HttpStatus.OK)
    public List<MembersDto> getAllMembers() {
        return memberService.getAllMembers();
    }
}
