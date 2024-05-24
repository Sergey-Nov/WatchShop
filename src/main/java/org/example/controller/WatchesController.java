package org.example.controller;


import org.example.entity.Watches;
import org.example.entity.enums.Type;
import org.example.service.WatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/watches")
public class WatchesController {
    @Autowired
    private WatchesService watchesService;

    @GetMapping(params = "type")
    public List<Watches> getWatchesByType(@RequestParam Type type){
        return watchesService.getWatchesByType(type);}

    @GetMapping
    public List<Watches> getWatchesList(){
        return watchesService.getWatchesList();
    }

    @GetMapping(params = "price")
    public List<Watches> getMechanicalWatchesWithPriceLower(@RequestParam int price){
        return watchesService.getMechanicalWatchesWithPriceLower(price);
    }
}
