package org.org.backend.services;

import org.org.backend.entities.Payment;
import org.org.backend.entities.PaymentStatus;
import org.org.backend.entities.PaymentType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface IPaymentService {
    public Payment savePayment(MultipartFile file, double amount, PaymentType type,
                               LocalDate date, String studentCode) throws IOException;
    public byte[] getPaymentFile(Long id) throws IOException;
    public Payment updatePaymentStatus(PaymentStatus status, Long paymentId);

}