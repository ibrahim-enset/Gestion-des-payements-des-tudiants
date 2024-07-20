package org.org.backend.repositories;


import org.org.backend.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student findByCode(String code);
    List<Student> findByProgramId(String programId);

    List<Student> findByFirstNameContainsIgnoreCase(String firstName);
}