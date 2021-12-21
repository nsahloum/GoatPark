package com.switchfully.goatpark.repository.division;

import com.switchfully.goatpark.domain.division.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface DivisionRepository extends JpaRepository<Division, Integer> {

    public Division save(Division divisionToSave);
}
