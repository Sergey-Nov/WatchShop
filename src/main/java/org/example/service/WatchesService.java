package org.example.service;

import org.example.entity.Manufacturer;
import org.example.entity.Watches;
import org.example.entity.enums.Type;

import java.util.List;

public interface WatchesService {

    List<Watches> getWatchesByType(Type type);
    List<Watches> getMechanicalWatchesWithPriceLower(int price);
    List<Watches> getWatchesList();
//    List<Watches> getWatchesByCountry(String country);
//    List<Manufacturer> getManufacturerBySumPriceLess(int enteredPrice);
}
