package iot_waste_management.domain.model;

import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data // Lombok generiert automatisch Getter, Setter, toString, equals, hashCode
@DynamoDbBean
public  class WasteDataDBModel {

    private String timestamp;
    private String ersterBehaelter;
    private String zweiterBehaelter;
    private String dritterBehealter;
    private String akkustand;

    @DynamoDbPartitionKey // Definiert das Feld als Partition Key in DynamoDB
    public String getTimestamp() {
        return timestamp;
    }
}