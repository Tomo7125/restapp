package sk.tomashrdy.ress;


import sk.tomashrdy.model.Person;
import sk.tomashrdy.services.PersonServices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/persons")
public class PersonResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersons(){
        return PersonServices.getPersonService().getAllPerson();
    }

    @GET
    @Path("/{personId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonById(@PathParam("personId") Long personId){
        return PersonServices.getPersonService().getPersonById(personId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPerson(Person person){
        return PersonServices.getPersonService().addPerson(person);
    }

    @PUT
    @Path("/{personId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person updatePerson(Person person, @PathParam("personId") Long personId){
        person.setId(personId);
        return PersonServices.getPersonService().updatePerson(person);
    }

    @DELETE
    @Path("/{personId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person deletePerson(Person person ,@PathParam("personId") Long personId){
        person.setId(personId);
        PersonServices.getPersonService().deletePerson(person);
        return PersonServices.getPersonService().getPersonById(personId);
    }
}
