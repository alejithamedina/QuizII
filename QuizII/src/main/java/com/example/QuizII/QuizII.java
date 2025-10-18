package com.example.QuizII;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizII {

    public static void main(String[] args) {

        cargarEnv();
        SpringApplication.run(QuizII.class, args);
    }
    public static void cargarEnv() {

        Dotenv dotenv = Dotenv.load();
        System.setProperty("BD_URL", dotenv.get("BD_URL"));
        System.setProperty("USER_NAME", dotenv.get("USER_NAME"));
        System.setProperty("PASSWORD", dotenv.get("PASSWORD"));

        System.out.println("BD_URL=" + System.getProperty("BD_URL"));
        System.out.println("USER_NAME=" + System.getProperty("USER_NAME"));
    }
}

