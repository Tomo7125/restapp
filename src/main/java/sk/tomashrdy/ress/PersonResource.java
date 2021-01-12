package sk.tomashrdy.ress;


import sk.tomashrdy.model.Person;
import sk.tomashrdy.services.PersonServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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

}
