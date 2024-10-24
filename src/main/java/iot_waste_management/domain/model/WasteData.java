package iot_waste_management.domain.model;


import lombok.Data;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
public class WasteData {

    String timestamp;

    String ersterBehaelter;

    String zweiterBehaelter;

    String dritterBehealter;

    String akkustand;

}
