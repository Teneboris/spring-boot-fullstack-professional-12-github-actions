package com.example.demo.student;

import com.example.demo.student.exception.BadRequestException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;
    //private AutoCloseable autoCloseable;
    private StudentService underTest;

    /**
     * this going to run before each Test and going to have a freh studentservice
     */
    @BeforeEach
    void setUp() {
        //autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new StudentService(studentRepository);
    }

    /**
     * close the result
     * @throws Exception
     */
   /* @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }*/

    @Test
    void canGetAllStudents() {
        //when
        underTest.getAllStudents();
        //then
        verify(studentRepository).findAll();
    }

    @Test
    void canaddStudent() {
        //given
        Student student = new Student(
                "Makamté Tene",
                "makamtetene@gmail.com",
                Gender.FEMALE
        );

        //when
        underTest.addStudent(student);

        //then
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);

        /**
         * capture the actuell student they was passt inside the save methode
         */
        verify(studentRepository).save(studentArgumentCaptor.capture());

        Student capturedStudent = studentArgumentCaptor.getValue();
        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    void willThrowWhenEmailIsTaken () {
        //given
        Student student = new Student(
                "Makamté Tene",
                "makamtetene@gmail.com",
                Gender.FEMALE
        );
        given(studentRepository.selectExistsEmail(student.getEmail())).willReturn(true);
        //when
        //then
       assertThatThrownBy(() -> underTest.addStudent(student))
               .isInstanceOf(BadRequestException.class)
               .hasMessageContaining("Email " + student.getEmail() + " taken");

        /**
         * that mean the studentRepository will never save a student
         */
        verify(studentRepository, never()).save(any());
    }

    @Test
    void candeleteStudent() {
        
    }
}