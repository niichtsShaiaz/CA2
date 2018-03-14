/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Shxnna
 */
public class Facademan {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_CA2_war_1.0-SNAPSHOTPU");
    
    public List<Person> getAllPerons()
    {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createNamedQuery("Person.findAll", Person.class);
        List<Person> persons = query.getResultList();
        em.close();
        return persons;
    }
    
    public Person getPersonById(int id)
    {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Person> query = em.createNamedQuery("Person.findById", Person.class);
        query.setParameter("id", id);
        Person person = query.getSingleResult();
        em.close();
        return person;
    }
    
    public List<Person> getAllPersonsContactInfo()
    {
        return null;
    }
    
    public Person getAllPersonsContactInfoById(int id)
    {
        return null;
    }
    
    public void createPerson(Person person)
    {
        
    }
}
