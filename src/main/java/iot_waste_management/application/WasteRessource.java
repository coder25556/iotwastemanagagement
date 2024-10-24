package iot_waste_management.application;

import iot_waste_management.domain.dynamoDB.DynamoDBService;
import iot_waste_management.domain.model.WasteData;
import iot_waste_management.domain.util.MapData;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import java.awt.*;

@Slf4j
@Path("/waste-management/data/speichern")
public class WasteRessource {



    @Inject
    DynamoDBService dynamoDBService;

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

    public Response saveDataToDB(WasteData wasteData){

        try{
            dynamoDBService.sendToDB(MapData.mapToDbModel(wasteData));
            return Response.ok().build();
        }catch(Exception e){
            log.error(e.getMessage(),e);
            return Response.serverError().build();
        }
    }
}
