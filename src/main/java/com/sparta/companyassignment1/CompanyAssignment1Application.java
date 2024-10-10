package com.sparta.companyassignment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CompanyAssignment1Application {

    public static void main(String[] args) {
        SpringApplication.run(CompanyAssignment1Application.class, args);
    }

}
