package ForPhone;


import ForPlants.CandyController;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;


@Path("/ari4java")
@RequestScoped
public class OtherApplication {


    public static int x;

    @Inject
    CandyController candyController;

    public void getSize() {
//        CandyModel candy = new CandyModel("","",7,"");
//        candy.persist();
//
//        System.out.println(CandyModel.listAll().size());

    }


    public static int getX(){
        return x;
    }



}
