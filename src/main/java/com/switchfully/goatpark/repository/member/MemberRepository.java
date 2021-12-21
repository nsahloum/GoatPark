package com.switchfully.goatpark.repository.member;

import com.switchfully.goatpark.domain.person.Person;

public interface MemberRepository {
    Person registerMember(Person person);
}
