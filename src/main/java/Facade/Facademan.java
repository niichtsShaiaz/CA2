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
        em.close();
        return null;
    }
    
    public Person getPersonById(int id)
    {
        EntityManager em = emf.createEntityManager();
        em.close();
        return null;
    }
    
    public List<Person> getAllPersonsContactInfo()
    {
        EntityManager em = emf.createEntityManager();
        em.close();
        return null;
    }
    
    public Person getAllPersonsContactInfoById(int id)
    {
        EntityManager em = emf.createEntityManager();
        em.close();
        return null;
    }
    
    public void createPerson(Person person)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction();
        em.close();
    }
}
