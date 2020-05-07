package com.test.database.databasedemo;

import com.test.database.databasedemo.entity.Person;
import com.test.database.databasedemo.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;


@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

    @Autowired
    PersonJpaRepository personJpaRepository;
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Find user by id -> {}",personJpaRepository.findById(101));
        logger.info("insert a user -> {}",personJpaRepository.insertPerson(new Person("Hany21","Congo", new Date())));
        personJpaRepository.deletePersonById(101);
        logger.info("Select * from person -> {}", personJpaRepository.findAll() );
    }
}
