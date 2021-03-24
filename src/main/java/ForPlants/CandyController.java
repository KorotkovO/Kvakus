package ForPlants;


import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.sun.net.httpserver.HttpsParameters;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.Body;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.quarkus.panache.common.Sort;





@Path("/api/candy")
@Produces("application/json")
@Consumes("application/json")
@ApplicationScoped
public class CandyController {




    @GET
    public Iterable<CandyModel> findAll() {
        return CandyModel.listAll();
    }





    @DELETE
    @Path("{id}")
    @Transactional
    public void delete(@org.jboss.resteasy.annotations.jaxrs.PathParam Long id) {
        CandyModel.deleteById(id);
    }





    @POST
    @Path("/add")
    @Transactional
    @Body
    public Response create(CandyModel candyToSave) {
        candyToSave.persist();
        return Response.ok(candyToSave).status(201).build();
    }


    @PUT
    @Path("{id}")
    @Body
    @Transactional
    public CandyModel update(@PathParam Long id, CandyModel newcandy) {

        CandyModel oldcandy = CandyModel.findById(id);

        if (oldcandy == null) {
            throw new WebApplicationException("Candy with id of " + id + " does not exist.", 404);
        }

            oldcandy.setCompany(newcandy.getCompany());
            oldcandy.setName(newcandy.getName());
            oldcandy.setFile(newcandy.getFile());
            oldcandy.setListened(newcandy.getListened());

        return oldcandy;
    }




    @GET
    @Path("{id}")
    public CandyModel findById(@org.jboss.resteasy.annotations.jaxrs.PathParam Long id) {
        return CandyModel.findById(id);
    }







}
