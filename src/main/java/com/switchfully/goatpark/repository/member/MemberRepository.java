package com.switchfully.goatpark.repository.member;

import com.switchfully.goatpark.service.domain.person.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MemberRepository {

    private final EntityManager manager;

    public MemberRepository(EntityManager manager) {
        this.manager = manager;
    }


    public Person registerMember(Person person) {
        manager.persist(person);
        String sql = "SELECT p FROM Person p WHERE p.emailAddress = :email";
        return manager.createQuery(sql, Person.class)
                .setParameter("email", person.getEmailAddress())
                .getSingleResult();
    }

    public List<Person> getAllMembers() {
        String sql = "SELECT p FROM Person p WHERE p.membership IS NOT NULL";
        return manager.createQuery(sql, Person.class).getResultList();
    }

    public Person getMemberById(int personId) {
        return manager.createQuery("select p from Person p where p.id  = :personId", Person.class)
                .setParameter("personId", personId)
                .getResultList().stream().findFirst().orElse(null);
    }
}
