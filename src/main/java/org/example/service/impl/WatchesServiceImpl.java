package org.example.service.impl;

import org.example.entity.Watches;
import org.example.entity.enums.Type;
import org.example.repository.WatchesJPARepository;
import org.example.repository.WatchesRepository;
//import org.example.repository.jdbcimpl.WatchesRepositoryJDBCImpl;
import org.example.service.WatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WatchesServiceImpl implements WatchesService {

    @Autowired
    private WatchesJPARepository watchesRepository;
//    private WatchesRepository watchesRepository = new WatchesRepositoryJDBCImpl();

    @Override
    public List<Watches> getWatchesByType(Type type) {
        return watchesRepository.getWatchesByType(type);
    }

    @Override
    public List<Watches> getWatchesList() {
        return watchesRepository.findAll();
    }

    @Override
    public List<Watches> getMechanicalWatchesWithPriceLower(int price) {
        List<Watches> all = watchesRepository.findAll();
        return all.stream().filter(watches -> getWatchesByType(Type.MECHANICAL).equals("MECHANICAL"))
                .filter(watches -> watches.getPrice()<price)
                .toList();
    }
//
//    @Override
//    public List<Watches> getWatchesByCountry(String country) {
//        return watchesRepository.getWatchesByCountry(country);
//    }
//
//    @Override
//    public List<Manufacturer> getManufacturerBySumPriceLess(int enteredPrice) {
//        return List.of();
//    }


}
