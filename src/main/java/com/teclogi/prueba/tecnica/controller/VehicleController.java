package com.teclogi.prueba.tecnica.controller;

import com.teclogi.prueba.tecnica.model.Position;
import com.teclogi.prueba.tecnica.model.Satellite;
import com.teclogi.prueba.tecnica.model.Vehicle;
import com.teclogi.prueba.tecnica.service.SatelliteService;
import com.teclogi.prueba.tecnica.service.VehicleService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class VehicleController {
    @Autowired
    VehicleService vehicleService;
    @Autowired
    SatelliteService satelliteService;

    @PostMapping("/tracking/")
    public ResponseEntity<Vehicle> getResponse(@RequestBody String payload) {
        JSONObject jsonObject = new JSONObject(payload);

        /*----------SATELLITES-------*/
        JSONArray satellitesJSONArray = jsonObject.getJSONArray("satellites");
        ArrayList<Satellite> satellitesArrayList = new ArrayList<>();
        for (int i = 0; i < satellitesJSONArray.length(); i++) {
            String name = satellitesJSONArray.getJSONObject(i).getString("name");
            double distance = satellitesJSONArray.getJSONObject(i).getDouble("distance");
            satellitesArrayList.add(new Satellite(name, distance, new Position()));
        }
        satellitesArrayList = satelliteService.setSatellitesPosition(satellitesArrayList);
        Vehicle vehicle = new Vehicle();
        vehicle.setPosition(vehicleService.getLocation(satellitesArrayList));

        /*-----------MESSAGE---------*/
        JSONArray messageJSONArray = jsonObject.getJSONArray("message");
        String[] messages = new String[messageJSONArray.length()];
        for (int i = 0; i < messageJSONArray.length(); i++) {
            messages[i] = messageJSONArray.getString(i);
        }
        if (vehicleService.isInDanger(messages)) {
            vehicle.setInDanger(true);
        } else {
            vehicle.setInDanger(false);
        }

        if (vehicle.getPosition() != null & vehicle.isInDanger()) {
            return ResponseEntity.ok().body(vehicle);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
