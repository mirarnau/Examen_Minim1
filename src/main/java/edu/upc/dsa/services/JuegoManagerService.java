package edu.upc.dsa.services;

import edu.upc.dsa.models.InterestPoint;
import edu.upc.dsa.models.User;

import edu.upc.dsa.util.JuegoManager;
import edu.upc.dsa.util.JuegoManagerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.auth.In;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/juego", description = "Endpoint to Covid19 vaccination service.")
@Path("/juego")
public class JuegoManagerService {
    private JuegoManager manager;

    public JuegoManagerService(){
        this.manager = JuegoManagerImpl.getInstance();
        if (true){
            //Definition of the initial users.
            User user0 = new User("Arnau");
            User user1 = new User("Bianca");
            User user2 = new User("Jordi");

            //Definition of the initial users.
            user0 = new User("Arnau");
            user1 = new User("Bianca");
            user2 = new User("Jordi");

            manager.addUser(user0);
            manager.addUser(user1);
            manager.addUser(user2);

            //Definition of the interest points.
            InterestPoint interestPoint0 = new InterestPoint("Bridge");
            InterestPoint interestPoint1 = new InterestPoint("Door");
            InterestPoint interestPoint2 = new InterestPoint("Hall");
            InterestPoint interestPoint3 = new InterestPoint("Bathroom");
            InterestPoint interestPoint4 = new InterestPoint("Restaurant");

            manager.addInterestPoint(interestPoint0);
            manager.addInterestPoint(interestPoint1);
            manager.addInterestPoint(interestPoint2);
            manager.addInterestPoint(interestPoint3);
            manager.addInterestPoint(interestPoint4);

            //Users cross different interest points */
            manager.informUserInterestPoint(user0.getIdUser(), interestPoint0.getIdInterestPoint());
            manager.informUserInterestPoint(user0.getIdUser(), interestPoint1.getIdInterestPoint());
            manager.informUserInterestPoint(user0.getIdUser(), interestPoint2.getIdInterestPoint());

            manager.informUserInterestPoint(user1.getIdUser(), interestPoint3.getIdInterestPoint());
            manager.informUserInterestPoint(user1.getIdUser(), interestPoint2.getIdInterestPoint());

            manager.informUserInterestPoint(user2.getIdUser(), interestPoint4.getIdInterestPoint());
        }

    }

    //----------------------------------------------

    @POST
    @ApiOperation(value = "Add a user to the system.", notes = "Additional information.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added user.")
    })
    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser (User user) {
        this.manager.addUser(user);
        return Response.status(201).build();
    }

    //----------------------------------------------

    @GET
    @ApiOperation(value = "Get the full user class given its id.", notes = "Additional information.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message= "ERROR, user not found.")
    })

    @Path("/getInfoUser/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfoUser(@PathParam("idUser") String idUser){
        if (manager.getInfoUser(idUser) != null){
            return Response.status(201).entity(manager.getInfoUser(idUser)).build();
        }
        else{
            return Response.status(404).build();
        }

    }

    //----------------------------------------------

    @GET
    @ApiOperation(value = "User crosses an interest point.", notes = "Additional information.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message= "ERROR, user not found.")
    })

    @Path("/informUserInterestPoint/{idUser}/{idInterestPoint}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response informUserInterestPoint(@PathParam("idUser") String idUser, @PathParam("idInterestPoint") String idInterestPoint){
        if ((this.manager.getInfoUser(idUser)) != null){
            return Response.status(201).build();
        }
        else{
            return Response.status(404).build();
        }
    }

    //----------------------------------------------

    @GET
    @ApiOperation(value = "User crosses an interest point.", notes = "Additional information.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message= "ERROR, user not found.")
    })

    @Path("/getInterestPointsCrossedByUser/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInterestPointsCrossedByUser(@PathParam("idUser") String idUser){
        if ((this.manager.getInfoUser(idUser)) != null){
            List <InterestPoint> resultList = this.manager.getInterestPointsCrossedByUser(idUser);
            GenericEntity<List<InterestPoint>> entity = new GenericEntity<List<InterestPoint>>(resultList){};
            return Response.status(201).entity(entity).build();
        }
        else{
            return Response.status(404).build();
        }
    }

    //----------------------------------------------

    @GET
    @ApiOperation(value = "List of users that have crosses the specified interest point.", notes = "Additional information.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer = "List"),
            @ApiResponse(code = 404, message= "ERROR, user not found.")
    })

    @Path("/getUsersInterestPoint/{idInterestPoint}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersInterestPoint(@PathParam("idInterestPoint") String idInterestPoint){
        List<User> listUsersResult = this.manager.getUsersInterestPoint(idInterestPoint);
        System.out.println("Length: " + listUsersResult.size());

        if (listUsersResult.size() > 0){
            GenericEntity<List<User>> entity = new GenericEntity<List<User>>(listUsersResult){};
            return Response.status(201).entity(entity).build();
        }
        else{
            return Response.status(404).build();
        }
    }

    //----------------------------------------------

    @GET
    @ApiOperation(value = "List of users ordered by crossed interest points.", notes = "Additional information.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer = "List"),
            @ApiResponse(code = 404, message= "ERROR, user not found.")
    })

    @Path("/getUsersOrderedInterestPoint")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersOrderedInterestPoint (){
        List<User> listUser = this.manager.getUsersOrderedInterestPoints();
        if (listUser.size() > 0) {
            GenericEntity<List<User>> entity = new GenericEntity<List<User>>(listUser) {};
            return Response.status(201).entity(entity).build();
        }
        else{
            return Response.status(404).build();
        }

    }

    //----------------------------------------------


}
