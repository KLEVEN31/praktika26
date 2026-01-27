package com.example.praktik26;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@SpringBootApplication
public class Praktik26Application {

    public static void main(String[] args) {
        SpringApplication.run(Praktik26Application.class, args);

        System.out.println("=========================================");
        System.out.println("ПРИЛОЖЕНИЕ ЗАПУЩЕНО УСПЕШНО!");
        System.out.println("=========================================");
        System.out.println("Доступные endpoints:");
        System.out.println("  GET  http://localhost:8080/api/customers");
        System.out.println("  POST http://localhost:8080/api/customers");
        System.out.println("  PUT  http://localhost:8080/api/customers/{code}");
        System.out.println("  GET  http://localhost:8080/api/lots");
        System.out.println("  POST http://localhost:8080/api/lots");
        System.out.println("=========================================");
        System.out.println("Frontend доступен по адресу: http://localhost:3000");
        System.out.println("=========================================");
    }

    @Bean
    public DSLContext dslContext(DataSource dataSource, Environment environment) {
        // Создаем DSLContext для работы с jOOQ
        return DSL.using(dataSource,
                org.jooq.SQLDialect.POSTGRES // или другой диалект, в зависимости от БД
        );
    }
}