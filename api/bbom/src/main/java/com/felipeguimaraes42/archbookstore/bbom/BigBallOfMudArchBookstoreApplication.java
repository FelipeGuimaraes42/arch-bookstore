package com.felipeguimaraes42.archbookstore.bbom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BigBallOfMudArchBookstoreApplication {

  public static void main(String[] args) {
    SpringApplication.run(BigBallOfMudArchBookstoreApplication.class, args);
  }
}
