/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Api;

import Entities.Person;
import Facade.Facademan;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
        String persons = gson.toJson(facade.getAllPerons());
        return persons;
    }
    
    @Path("/complete/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersonCompleteId(@PathParam("id") int id)
    {
        //need validation
        String person = gson.toJson(facade.getPersonById(id));
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
        String person = gson.toJson(facade.getAllPersonsContactInfoById(id));
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
    
    
    
    
    
}