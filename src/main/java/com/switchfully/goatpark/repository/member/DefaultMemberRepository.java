package com.switchfully.goatpark.repository.member;

import com.switchfully.goatpark.domain.person.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class DefaultMemberRepository implements MemberRepository{

    private final EntityManager manager;

    public DefaultMemberRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public Person registerMember(Person person) {
        manager.persist(person);
        var sql = "SELECT p FROM Person p WHERE p.emailAddress = :email";
        var result = manager.createQuery(sql, Person.class)
                .setParameter("email", person.getEmailAddress())
                .getSingleResult();
        return manager.find(Person.class, result.getId());
    }
}
