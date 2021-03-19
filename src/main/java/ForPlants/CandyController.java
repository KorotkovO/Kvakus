package ForPlants;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;





@Path("/api/candy")
@Produces("application/json")
@Consumes("application/json")
@ApplicationScoped
public class CandyController {


    CandyRepository reposit;

    public CandyController(CandyRepository reposit) {
        this.reposit = reposit;
    }


    @GET
    @Produces("application/json")
    public Iterable<CandyModel> findAll() {
        return reposit.findAll();
    }



//    @DELETE
//    @Path("{name}")
//    public void delete(@org.jboss.resteasy.annotations.jaxrs.PathParam String name) {
//        reposit.deleteByName(name);
//    }

    @POST
    @Path("/name/{name}/file/{file}/listened/{listened}/company/{company}")
    @Produces("application/json")
    public CandyModel create(@PathParam String name, @PathParam String file, @PathParam int listened, @PathParam String company) {
        return reposit.save(new CandyModel(name, file, listened, company));
    }


    @POST
    @Path("/add/candy")
    @Produces("application/json")
    public Response addProduct(CandyModel candy){
        reposit.save(candy);
        return Response.ok().build();
    }




/*    @PUT
    @Path("/id/{id}/color/{color}")
    @Produces("application/json")
    public Fruit changeColor(@org.jboss.resteasy.annotations.jaxrs.PathParam Long id, @org.jboss.resteasy.annotations.jaxrs.PathParam String color) {
        Optional<Fruit> optional = fruitRepository.findById(id);
        if (optional.isPresent()) {
            Fruit fruit = optional.get();
            fruit.setColor(color);
            return fruitRepository.save(fruit);
        }

        throw new IllegalArgumentException("No Fruit with id " + id + " exists");
    }*/

    @GET
    @Path("/name/{name}")
    @Produces("application/json")
    public CandyModel findByName(@PathParam String name) {
        return reposit.findByName(name);
    }




}
