/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entities.Address;
import Entities.CityInfo;
import Entities.Person;
import Entities.Phone;
import java.util.ArrayList;
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
    
    public Person getPersonByPhone(int phoneNumber)
    {
        Person person = null;
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT p FROM Phone p WHERE p.number = :phoneNumber");
        q.setParameter("phoneNumber", phoneNumber);
        Phone phone  = (Phone)q.getSingleResult();
        person = phone.getPerson();
        return person;
    }
    
    public List<Person> getPersonsByHobby(String hobby)
    {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT p FROM Person p, Hobby h WHERE h.name = :hobby and p.hobbys = h");
        q.setParameter("hobby", hobby);
        List<Person> personList = (List<Person>)q.getResultList();
        return personList;
    }
    
    
    
    public List<Person> getAllPersonsInCity(int zip){
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT p FROM Person p, CityInfo c WHERE c.zip = :zip and c.addresses = p.address");
        q.setParameter("zip", zip);
        List<Person> personList = (List<Person>)q.getResultList();
        return personList;
    }
    
    
    public static void main(String[] args) {
        Facademan face = new Facademan();
        List<Person> list = face.getPersonsByHobby("Fodbold");
        System.out.println(list.get(0).getfName());
    }
    
}
