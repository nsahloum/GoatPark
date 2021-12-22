package com.switchfully.goatpark.repository.division;

import com.switchfully.goatpark.domain.division.Division;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class DivisionRepositoryTest {

    @Autowired
    private DivisionRepository divisionRepository;


    @Test
    public void saveDivision() {
        Division division = new Division("Division Name", " Original name", "Najima");
        Division saved = divisionRepository.save(division);
        assertThat(saved).usingRecursiveComparison().ignoringFields("id").isEqualTo(division);
    }
}