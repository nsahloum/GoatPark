package com.switchfully.goatpark.repository.division;

import com.switchfully.goatpark.domain.division.Division;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DivisionRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public Division save(Division divisionToSave) {
        entityManager.persist(divisionToSave);
        return divisionToSave;
    }

    public String findDivisionByName(String name) {
        Division division = entityManager.createQuery("select d from Division d where d.name = :name", Division.class)
                .setParameter("name", name)
                .getSingleResult();
        if(division != null){
            return division.getName();
        }
        return null;
    }

    public String findDivisionByOriginalName(String originalName) {
        Division division = entityManager.createQuery("select d from Division d where d.originalName = :originalName", Division.class)
                .setParameter("originalName", originalName)
                .getSingleResult();
        if(division != null){
            return division.getName();
        }
        return null;
    }
}
