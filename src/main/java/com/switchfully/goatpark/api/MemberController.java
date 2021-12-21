package com.switchfully.goatpark.api;

import com.switchfully.goatpark.service.MemberService;
import com.switchfully.goatpark.service.dto.member.CreateMemberDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/members", consumes = "application/json")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @PostMapping
    public int register(@RequestBody CreateMemberDto createMemberDto) {
        return memberService.registerMember(createMemberDto);
    }
}
