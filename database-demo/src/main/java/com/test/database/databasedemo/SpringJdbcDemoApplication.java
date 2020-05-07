package com.test.database.databasedemo;


import com.test.database.databasedemo.entity.Person;
import com.test.database.databasedemo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private final Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}",dao.retrieveAll());
		logger.info("User by ID ->{}",dao.retrieveById(10001));
		logger.info("delete by ID -{}",dao.deleteById(10001));
		logger.info("insert user in table -> {}",dao.insert(new Person(100,"Josefina","mexico",new Date())));
		logger.info("update user in table -> {}",dao.update(new Person(100,"Ramoseventos","mexico", new Date())));
	}
}
