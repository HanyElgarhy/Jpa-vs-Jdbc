package com.test.database.databasedemo.mapper;


import com.test.database.databasedemo.entity.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person=new Person();
        person.setId(rs.getInt("id"));
        person.setName(rs.getString("name"));
        person.setLocation(rs.getString("location"));
        person.setBirth_Date(rs.getTimestamp("birth_date"));
        return person;
    }
}
