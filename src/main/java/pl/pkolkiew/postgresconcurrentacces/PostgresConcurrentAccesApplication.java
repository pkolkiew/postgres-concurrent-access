package pl.pkolkiew.postgresconcurrentacces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PostgresConcurrentAccesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostgresConcurrentAccesApplication.class, args);
    }

}
