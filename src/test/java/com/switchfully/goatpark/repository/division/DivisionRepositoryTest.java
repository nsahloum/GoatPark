package com.switchfully.goatpark.repository.division;

import com.switchfully.goatpark.service.domain.division.Division;
import com.switchfully.goatpark.service.dto.division.DivisionDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DivisionRepositoryTest {

    @Autowired
    private DivisionRepository divisionRepository;
    private Division division;
    private Division saved;

    @BeforeAll
    public void setUp() {
        division = new Division("Division Name", "Original name", "Najima", 0);
        saved = divisionRepository.save(division);
    }

    @Test
    public void saveDivision() {
        assertThat(saved).usingRecursiveComparison().ignoringFields("id").isEqualTo(division);
    }

    @Test
    public void getByName() {
        Division divisionToCheck = divisionRepository.findDivisionByName("Division Name");
        assertThat(divisionToCheck).isNotNull();
    }

    @Test
    public void getByOriginalName() {
        Division divisionToCheck = divisionRepository.findDivisionByOriginalName("Original name");
        assertThat(divisionToCheck).isNotNull();
    }

    @Test
    public void getAllDivisions(){
        List<Division> divisions = divisionRepository.getAllDivisions();
        assertThat(divisions).isNotNull();
    }

    @Test
    public void getById(){
        int id = division.getId();
        Division divisionToCheck = divisionRepository.getById(id);
        assertThat(divisionToCheck.getName()).isEqualTo(division.getName());
    }
}