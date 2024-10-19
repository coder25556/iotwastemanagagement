package iot_waste_management.application;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import java.awt.*;

@Path("/waste-management/data/speichern")
public class WasteRessource {


    @POST
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "200",
                            description = "Daten konnten gespeichert werden",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON)
                            //schema = @Schema(implementation = )
                    ),
                    @APIResponse(
                            responseCode = "400",
                            description = "Client hat was falsch gemacht"
                    )
            }
    )

    public Response saveDataToDB(){
        Testobjekt testobjekt=new Testobjekt("Htgeklappt");

        return Response.ok(testobjekt).build();
    }
}
