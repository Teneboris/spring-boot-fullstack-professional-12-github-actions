package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    /**
     * after any test everything have to be delete
     */
    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckWhenStudentEmailExists() {
        String email ="makamtetene@gmail.com";
        //given
        Student student = new Student(
                "Makamté Tene",
                email,
                Gender.FEMALE
        );
        underTest.save(student);
        //when
        boolean expected = underTest.selectExistsEmail(email);

        //then
        assertThat(expected).isTrue();
    }

    @Test
    void itShouldCheckWhenStudentEmailDoesNotExists() {

        //given
        String email ="makamtetene@gmail.com";
        //when
        boolean expected = underTest.selectExistsEmail(email);

        //then
        assertThat(expected).isFalse();
    }
}