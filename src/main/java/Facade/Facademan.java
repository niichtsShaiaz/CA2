/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entities.CityInfo;
import Entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Shxnna
 */
public class Facademan {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2");
    
    public List<Person> getAllPerons()
    {
        List<Person> allPersons = null;
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT p FROM Person p");
        allPersons = (List<Person>)q.getResultList();
        return allPersons;
    }
    
    public Person getPersonById(int id)
    {
        Person person = null;
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT p FROM Person p WHERE p.id = :id");
        q.setParameter("id", id);
        person = (Person)q.getSingleResult();
        return person;
    }
    
    
    public void createPerson(Person person)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }
    
    public List<CityInfo> getAllCityInfo(){
        List<CityInfo> cityInfo = null;
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT c FROM CityInfo c");
        cityInfo = (List<CityInfo>)q.getResultList();
        return cityInfo;
    }

    public Object getAllPersonsContactInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getAllPersonsContactInfoById(int id) {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT p FROM Person p WHERE p.id = :id");
        q.setParameter("id", id);
        Person person = (Person)q.getSingleResult();
        return person;
    }
}
