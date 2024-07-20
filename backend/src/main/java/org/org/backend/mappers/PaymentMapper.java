package org.org.backend.mappers;

import lombok.AllArgsConstructor;
import org.org.backend.entities.Payment;
import org.org.backend.entities.PaymentStatus;
import org.org.backend.entities.PaymentType;
import org.springframework.stereotype.Component;
import org.org.backend.dto.PaymentDTO;
import org.org.backend.repositories.StudentRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
@AllArgsConstructor
public class PaymentMapper {

    StudentRepository studentRepository;
    public PaymentDTO dtoToEntite(PaymentDTO dto) {
        Payment p = new Payment();
        p.setAmount(dto.getAmount());
        p.setStatus(PaymentStatus.valueOf(dto.getStatus()));
        p.setType(PaymentType.valueOf(dto.getType()));
        p.setDate(LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        p.setFile(dto.getFile());
        p.setStudent(studentRepository.findById(dto.getId_student()).get());
        return dto;
    }
}