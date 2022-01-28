package com.teclogi.prueba.tecnica.service;

import com.teclogi.prueba.tecnica.model.Location;
import com.teclogi.prueba.tecnica.model.Satellite;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SatelliteService {
    public ArrayList<Satellite> setLocation(ArrayList<Satellite> satellites){
        for(Satellite s: satellites){
            switch (s.getName()){
                case "Sputnik":
                    s.setLocation(new Location(-500,-200));
                    break;
                case "Explorer":
                    s.setLocation(new Location(100,-100));
                    break;
                case "Asterix":
                    s.setLocation(new Location(500,100));
                    break;
                default:
                    s.setLocation(new Location(200,200));
            }
        }
        return satellites;
    }
}
