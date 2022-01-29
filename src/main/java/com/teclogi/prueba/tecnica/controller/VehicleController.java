package com.teclogi.prueba.tecnica.controller;

import com.teclogi.prueba.tecnica.model.Position;
import com.teclogi.prueba.tecnica.model.Satellite;
import com.teclogi.prueba.tecnica.service.SatelliteService;
import com.teclogi.prueba.tecnica.service.VehicleService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;
    @Autowired
    SatelliteService satelliteService;

    @PostMapping("/tracking/")
    public Position getVehicleLocation(@RequestBody String payload){
        JSONObject jsonObject = new JSONObject(payload);
        JSONArray satellitesJSONArray = jsonObject.getJSONArray("satellites");
        ArrayList<Satellite> satellitesArrayList = new ArrayList<>();
        for(int i=0; i<satellitesJSONArray.length();i++){
            String name = satellitesJSONArray.getJSONObject(i).getString("name");
            float distance = satellitesJSONArray.getJSONObject(i).getFloat("distance");
            satellitesArrayList.add(new Satellite(name, distance,new Position()));
        }
        satellitesArrayList= satelliteService.setSatellitesPosition(satellitesArrayList);
        return vehicleService.getLocation(satellitesArrayList);
    }
}
