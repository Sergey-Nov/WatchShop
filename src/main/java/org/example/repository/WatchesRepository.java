package org.example.repository;

import org.example.entity.Manufacturer;
import org.example.entity.Watches;
import org.example.entity.enums.Type;

import java.util.List;

public interface WatchesRepository {
    List<Watches> getWatchesByType(Type type);
    List<Watches> getMechanicalWatchesWithPriceLower(int price);
    List<Watches> findAll();
//    List<Watches> getWatchesByCountry(String country);
//    List<Manufacturer> getManufacturerBySumPriceLess(int enteredPrice);
}
