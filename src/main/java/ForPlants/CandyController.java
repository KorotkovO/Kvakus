package ForPlants;


import java.io.*;
import java.util.*;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import ForPhone.StasisListener;
import org.jboss.resteasy.annotations.Body;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.*;



@Path("/api/candy")
@ApplicationScoped
public class CandyController {


    public static MultiBody exbody;
    boolean b = false;
    public static int example;

    public CandyController (){ }


//    public static void setSongName(String s){
//        StasisListener.songId = "aaaaaaaaaaaaa";
//    }
//
//    public static String getSongName(){
//        String o = StasisListener.songId;
//        return o;
//    }


    @GET
    public List<CandyModel> findAll() {
        return CandyModel.listAll();
    }



    @GET
    @Path("{id}")
    public CandyModel findOne(@org.jboss.resteasy.annotations.jaxrs.PathParam Long id){
        return CandyModel.findById(id);
    }



    @DELETE
    @Path("{id}")
    @Transactional
    @Produces("application/json")
    @Consumes("application/json")
    public void delete(@org.jboss.resteasy.annotations.jaxrs.PathParam Long id) {
        CandyModel.deleteById(id);
    }





    @POST
    @Path("/add")
    @Transactional
    @Body
    @Produces("application/json")
    @Consumes("application/json")
    public Response create(CandyModel candyToSave) {
        if(b==true){
            candyToSave.setFile(exbody.fileName + " ");
            b = false;
        }else{
            candyToSave.setFile("no file");
        }
        candyToSave.persist();
        return Response.ok(candyToSave).status(201).build();
    }


    @PUT
    @Path("{id}")
    @Body
    @Transactional
    @Produces("application/json")
    @Consumes("application/json")
    public CandyModel update(@PathParam Long id, CandyModel newcandy) {

        CandyModel oldcandy = CandyModel.findById(id);

        if (oldcandy == null) {
            throw new WebApplicationException("Candy with id of " + id + " does not exist.", 404);
        }

            oldcandy.setCompany(newcandy.getCompany());
            oldcandy.setName(newcandy.getName() + CandyModel.listAll().size());
//            oldcandy.setFile(newcandy.getFile());
            if(b==true){
            oldcandy.setFile(exbody.fileName + " ");
                b = false;
            }
            oldcandy.setListened(newcandy.getListened());

        return oldcandy;
    }

    public static int getSize(){
        return CandyModel.getCount();
    }




    @GET
    @Path("{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public CandyModel findById(@org.jboss.resteasy.annotations.jaxrs.PathParam Long id) {
        return CandyModel.findById(id);
    }



    private String getFileName(MultivaluedMap<String, String> header) {

        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");

        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {

                String[] name = filename.split("=");

                String finalFileName = name[1].trim().replaceAll("\"", "");
                return finalFileName;
            }
        }
        return "unknown";
    }


    @POST
    @Path("/multipart")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void sendFile(@MultipartForm MultipartFormDataInput data) throws Exception {
        b = true;

        MultiBody body = new MultiBody();

        InputPart i = data.getFormDataMap().get("file").get(0);
//        Map<String, List<InputPart>> map = data.getFormDataMap();

        body.fileName = getFileName(i.getHeaders()) + "";
        body.file = i.getBody(InputStream.class,null);

        OutputStream output = new FileOutputStream(new File("D:/var/lib/asterisk/sounds/" + "Sound" + body.fileName));

        int read = 0;
        byte[] bytes = new byte[1024];

//        output = new FileOutputStream(new File(""));
        while ((read = body.file.read(bytes)) != -1) {
            output.write(bytes, 0, read);
        }
        output.flush();
        output.close();


        this.exbody = body;


    }










}
