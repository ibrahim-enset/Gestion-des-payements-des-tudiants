package org.org.backend.mappers;

import org.org.backend.dto.StudentDTO;
import org.org.backend.entities.Student;

public class StudentMapper {

    public Student dtoToEntite(StudentDTO dto){


        return Student.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .photo(dto.getPhoto())
                .programId(dto.getProgramId())
                .code(dto.getCode())
                .build();
    }
}
