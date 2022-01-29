package com.teclogi.prueba.tecnica.service;

import com.teclogi.prueba.tecnica.model.Position;
import com.teclogi.prueba.tecnica.model.Satellite;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SatelliteService {
    public ArrayList<Satellite> setSatellitesPosition(ArrayList<Satellite> satellites){
        for(Satellite s: satellites){
            switch (s.getName()){
                case "Sputnik":
                    s.setPosition(new Position(-50,0));
                    break;
                case "Explorer":
                    s.setPosition(new Position(0, 173.2050808f));
                    break;
                case "Asterix":
                    s.setPosition(new Position(50,0));
                    break;
                default:
                    s.setPosition(new Position(50,200));
            }
        }
        return satellites;
    }
}
