package com.switchfully.goatpark.service;

import com.switchfully.goatpark.service.dto.member.CreateMemberDto;

public interface MemberService {
    int registerMember(CreateMemberDto createMemberDto);
}
