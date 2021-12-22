package com.switchfully.goatpark.repository.division;

import com.switchfully.goatpark.domain.division.Division;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
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