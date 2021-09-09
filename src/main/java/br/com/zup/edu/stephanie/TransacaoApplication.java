package br.com.zup.edu.stephanie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class TransacaoApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransacaoApplication.class, args);
    }
}

Criar