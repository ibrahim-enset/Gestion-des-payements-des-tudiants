package org.org.backend.repositories;

import org.org.backend.entities.Payment;
import org.org.backend.entities.PaymentStatus;
import org.org.backend.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);
}