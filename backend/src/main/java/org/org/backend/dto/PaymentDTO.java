package org.org.backend.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaymentDTO {
    private String date;
    private double amount;
    private String type;
    private String status;
    private String file;
    private String id_student;

}