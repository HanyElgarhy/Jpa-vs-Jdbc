package com.test.database.databasedemo.jpa;

import com.test.database.databasedemo.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id){
        return entityManager.find(Person.class,id);
    }

    public Person update(Person person){
        return entityManager.merge(person);
    }
    public Person insertPerson(Person person){
        return entityManager.merge(person);
    }

    public void  deletePersonById(int id){
        Person person = findById(id);
        entityManager.remove(person);
    }
    public List<Person> findAll(){
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find all user",Person.class);
        return namedQuery.getResultList();
    }
}
