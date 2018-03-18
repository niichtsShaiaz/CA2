/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;

import Entities.Person;
import Facade.Facademan;
import JsonMessages.ContactInfo;
import JsonMessages.PersonMessage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author ezl
 */
@Path("person")
public class PersonResource
{
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Facademan facade = new Facademan();

    @Context
    private UriInfo context;

    public PersonResource()
    {
    }
    
    @Path("/complete")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonComplete()
    {
        //need validation
        ArrayList<PersonMessage> messages = new ArrayList<>();
        List<Person> list = facade.getAllPerons();
        for(Person p : list){
            messages.add(new PersonMessage(p));
        }
        String persons = gson.toJson(messages);
        return persons;
    }
    
    @Path("/complete/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonCompleteId(@PathParam("id") int id)
    {
        Person p = facade.getPersonById(id);
        PersonMessage pm = new PersonMessage(p);
        String person = gson.toJson(pm);
        return person;
    }
    
    @Path("/contactinfo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getContactInfo()
    {
        //need validation
        String persons = gson.toJson(facade.getAllPersonsContactInfo());
        return persons;
    }
    
    @Path("/contactinfo/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getContactinfoId(@PathParam("id") int id)
    {
        //need validation
        Person p = facade.getPersonById(id);
        ContactInfo CI = new ContactInfo(p);
        String person = gson.toJson(CI);
        return person;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPerson(String message)
    {
        // need validation
        Person person = gson.fromJson(message, Person.class);
        facade.createPerson(person);
    }
    
    @Path("/phone/{number}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonByPhone(@PathParam("number") int number){
        
        Person person = facade.getPersonByPhone(number);
        PersonMessage pm = new PersonMessage(person);
        return gson.toJson(pm);
    }
    
    @Path("/hobby/{hobby}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonByHobby(@PathParam("hobby") String hobby){
        List<PersonMessage> pmList = new ArrayList<>();
        List<Person> personList = facade.getPersonsByHobby(hobby);
        for(Person p : personList){
            pmList.add(new PersonMessage(p));
        }
        return gson.toJson(pmList);
    }
    
}
