package org.org.backend;

import org.org.backend.entities.Payment;
import org.org.backend.entities.PaymentStatus;
import org.org.backend.entities.PaymentType;
import org.org.backend.entities.Student;
import org.org.backend.repositories.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.org.backend.repositories.StudentRepository;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

         @Bean
        CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository) {
                return args -> {
                        List<Student> students = List.of(
                        Student.builder().id(UUID.randomUUID().toString())
                                .code("11111").firstName("Ahmed").lastName("A").programId("A").build(),
                        Student.builder().id(UUID.randomUUID().toString())
                                .code("2222").firstName("Youssef").lastName("Youssef").programId("D").build(),
                        Student.builder().id(UUID.randomUUID().toString())
                                .code("112233355").firstName("Ayman").lastName("Youssef").programId("C").build(),
                        Student.builder().id(UUID.randomUUID().toString())
                                .code("44444").firstName("Kamal").lastName("Kamal").programId("BDCC").build(),
                        Student.builder().id(UUID.randomUUID().toString())
                                .code("1125233").firstName("Mohamed").lastName("Mohamed").programId("GLSID").build(),
                        Student.builder().id(UUID.randomUUID().toString())
                                .code("11244244").firstName("Imane").lastName("Imane").programId("GLSID").build()
                        );

                        studentRepository.saveAll(students);

                        PaymentType[] paymentTypes = PaymentType.values();
                        Random random = new Random();
                        studentRepository.findAll().forEach(st -> {
                        for (int i = 0; i < 10; i++) {
                                int index = random.nextInt(paymentTypes.length);
                                Payment payment = Payment.builder()
                                .date(LocalDate.now())
                                .amount(1000 + random.nextInt(19001)) // Random amount between 1000 and 20000
                                .type(paymentTypes[index])
                                .status(PaymentStatus.CREATED)
                                .student(st)
                                .build();
                                paymentRepository.save(payment);
                        }
                        });
         };
        }
}
