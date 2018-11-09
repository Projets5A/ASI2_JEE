package rest;

import common.UserModel;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/WatcherAuth")
public interface WatcherAuthInterface {

    @POST()
    @Produces(MediaType.APPLICATION_JSON)
    String message(UserModel user);

    /*
    @GET()
    @Produces(MediaType.TEXT_PLAIN)
    String message();
*/
}
