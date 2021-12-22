package com.switchfully.goatpark.api;

import com.switchfully.goatpark.service.MemberService;
import com.switchfully.goatpark.service.dto.member.create.CreateMemberDto;
import com.switchfully.goatpark.service.dto.member.returndto.PersonDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/members", consumes = "application/json")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDto register(@RequestBody CreateMemberDto createMemberDto) {
        return memberService.registerMember(createMemberDto);
    }
}
