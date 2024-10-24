package iot_waste_management.domain.util;

import iot_waste_management.domain.model.WasteData;
import iot_waste_management.domain.model.WasteDataDBModel;

public class MapData {

    public static WasteDataDBModel mapToDbModel(WasteData wasteData) {
        WasteDataDBModel dbModel = new WasteDataDBModel();
        dbModel.setTimestamp(wasteData.getTimestamp());
        dbModel.setErsterBehaelter(wasteData.getErsterBehaelter());
        dbModel.setZweiterBehaelter(wasteData.getZweiterBehaelter());
        dbModel.setDritterBehealter(wasteData.getDritterBehealter());
        dbModel.setAkkustand(wasteData.getAkkustand());
        return dbModel;
    }
}
