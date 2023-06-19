package com.felipeguimaraes42.architecturehortifruti.none;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class NoneArchitectureHortifrutiApplication {

  public static void main(String[] args) {
    SpringApplication.run(NoneArchitectureHortifrutiApplication.class, args);
  }
}
