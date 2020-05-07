package com.test.database.databasedemo.jdbc;

import com.test.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
@Repository
public class PersonJdbcDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Person> retrieveAll(){
        return jdbcTemplate.query("Select * from person", new BeanPropertyRowMapper<Person>(Person.class));
    }
    public Person retrieveById(int id){
        return jdbcTemplate.queryForObject("Select * from person where id=?",
                new Object[]{id},new BeanPropertyRowMapper<Person>(Person.class));
    }
    public int deleteById(int id){
        return jdbcTemplate.update("delete from person where id=?", id);
    }
    public int insert(Person person){
        return jdbcTemplate.update(
                "insert into person(id,name,location,birth_date) values(?,?,?,?)",
                person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getBirth_Date().getTime()));
    }
    public int update(Person person){
        return jdbcTemplate.update(
                "update person  set name=?, location=?, birth_date=? where id=?",
                person.getName(),person.getLocation(),new Timestamp(person.getBirth_Date().getTime()),person.getId());
    }
}
