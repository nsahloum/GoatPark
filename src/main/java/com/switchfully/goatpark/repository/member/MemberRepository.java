package com.switchfully.goatpark.repository.member;

import com.switchfully.goatpark.domain.person.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class MemberRepository {

    private final EntityManager manager;

    public MemberRepository(EntityManager manager) {
        this.manager = manager;
    }


    public Person registerMember(Person person) {
        manager.persist(person);

        String sql = "SELECT p FROM Person p WHERE p.name = :name";
        Person result = manager.createQuery(sql, Person.class)
                .setParameter("name", person.getName())
                .getSingleResult();

        return manager.find(Person.class, result.getId());
    }
}
