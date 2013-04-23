package com.noip;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@ManagedBean
@Path("myresource")
public class MyResource {

    @Inject
    MyService myService;

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getit")
    public String getIt() {
        return "Got it {" + myService + "}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Path("/callit")
    public Response callIt() {
        CacheControl cc = new CacheControl();
        cc.setProxyRevalidate(true);
        cc.setMaxAge(86400);

        Response response = Response.ok("called!").cacheControl(cc).build();
        return response;
    }

}
