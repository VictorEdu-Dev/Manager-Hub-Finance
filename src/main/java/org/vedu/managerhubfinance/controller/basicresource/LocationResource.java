package org.vedu.managerhubfinance.controller.basicresource;

import java.io.Serializable;
import java.lang.invoke.MethodHandles;
import java.util.Map;
import java.util.logging.Logger;

import org.vedu.managerhubfinance.service.location.LocationService;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/location")
public class LocationResource implements Serializable {
    private static final long serialVersionUID = -8123149342539582297L;
    private final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @EJB
    LocationService basicService;

    @GET
    @Path("/address/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAddressInfo(@PathParam("id") String cep) {
        logger.info("Getting address info by CEP: " + cep);
        try {
            Map<String, String> addressInfo = basicService.getAddressInfo(cep)
                .orElseThrow(() -> new WebApplicationException("Address not found for the given CEP", Response.Status.NOT_FOUND));
            return Response.ok(addressInfo, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            logger.severe("Error getting address info by CEP: " + e.getMessage());
            throw new WebApplicationException("Internal server error", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
