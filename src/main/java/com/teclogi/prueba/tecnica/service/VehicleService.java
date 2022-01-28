package com.teclogi.prueba.tecnica.service;

import com.teclogi.prueba.tecnica.model.Location;
import com.teclogi.prueba.tecnica.model.Satellite;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VehicleService {
    public Location getLocation(ArrayList<Satellite> satellites){
        Location vehicleLocation = new Location();
        /*-----Via Cramer's rule----*/
        float x1 = satellites.get(0).getLocation().getXPosition();
        float x2 = satellites.get(1).getLocation().getXPosition();
        float x3 = satellites.get(2).getLocation().getXPosition();
        float y1 = satellites.get(0).getLocation().getYPosition();
        float y2 = satellites.get(1).getLocation().getYPosition();
        float y3 = satellites.get(2).getLocation().getYPosition();
        float r1 = satellites.get(0).getDistance();
        float r2 = satellites.get(1).getDistance();
        float r3 = satellites.get(2).getDistance();
        float a = 2*(x2 - x1);
        float b = 2*(y2 - y1);
        float c = 2*(x3 - x2);
        float d = 2*(y3 - y2);
        float e = (float) (Math.pow(r1,2) -  Math.pow(r2,2) - Math.pow(x1,2) + Math.pow(x2,2) - Math.pow(y1,2) +Math.pow(y2,2));
        float f = (float) (Math.pow(r2,2) -  Math.pow(r3,2) - Math.pow(x2,2) + Math.pow(x3,2) - Math.pow(y2,2) +Math.pow(y3,2));
        float x = ((e*d) - (b*f))/((a*d) - (b*c));
        float y = ((a*f) - (e*c))/((a*d) - (b*c));
        vehicleLocation.setXPosition(x);
        vehicleLocation.setYPosition(y);
        return vehicleLocation;
    }


    public boolean isInDanger(String [] messages){

        return false;
    }
}
