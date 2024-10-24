package iot_waste_management.domain.dynamoDB;

import iot_waste_management.domain.model.WasteData;
import iot_waste_management.domain.model.WasteDataDBModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

@ApplicationScoped
public class DynamoDBService {

    @Inject
    DynamoDbClient dynamoDbClient;

    @ConfigProperty(name = "dynamodb.table.name")
    String tableName;

    public void sendToDB(WasteDataDBModel wasteData) throws Exception {

        try {
            // Erstelle den DynamoDB Enhanced Client
            DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
                    .dynamoDbClient(dynamoDbClient)
                    .build();

            // Erhalte die DynamoDB-Tabelle
            DynamoDbTable<WasteDataDBModel> table = enhancedClient.table(tableName, TableSchema.fromClass(WasteDataDBModel.class));

            // Speichere das WasteData-Objekt
            table.putItem(wasteData);

        } catch (DynamoDbException e) {
            // Logge den Fehler und wirf eine Exception weiter, die die Ressource behandeln kann
            throw new Exception("Fehler beim Speichern der Daten in DynamoDB: " + e.getMessage(), e);
        }
    }
}
