package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student Gustavo = new Student(
                    "Luis Gustavo Acosta Ruiz",
                    LocalDate.of(1999, 4, 25),
                    "acostarluisg@gmail.com"
            );
            Student Bjorn = new Student(
                    "Bjorn Acosta Ruiz",
                    LocalDate.of(2005, 4, 22),
                    "bjornacosta@gmail.com"
            );
            studentRepository.saveAll(List.of(Gustavo, Bjorn));
        };
    }
}
