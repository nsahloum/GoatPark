package com.switchfully.goatpark.repository.member;

import com.switchfully.goatpark.service.domain.person.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class MemberRepository {

    private final EntityManager manager;

    public MemberRepository(EntityManager manager) {
        this.manager = manager;
    }


    public Person registerMember(Person person) {
        manager.persist(person);
        String sql = "SELECT p FROM Person p WHERE p.name = :name";
        return manager.createQuery(sql, Person.class)
                .setParameter("name", person.getName())
                .getSingleResult();
    }
}
