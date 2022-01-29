package com.teclogi.prueba.tecnica.service;

import com.teclogi.prueba.tecnica.model.Position;
import com.teclogi.prueba.tecnica.model.Satellite;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VehicleService {
    public Position getLocation(ArrayList<Satellite> satellites){
        Position vehiclePosition = new Position();
        /*-----Via Cramer's rule----*/
        float x1 = satellites.get(0).getPosition().getX();
        float x2 = satellites.get(1).getPosition().getX();
        float x3 = satellites.get(2).getPosition().getX();
        float y1 = satellites.get(0).getPosition().getY();
        float y2 = satellites.get(1).getPosition().getY();
        float y3 = satellites.get(2).getPosition().getY();
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
        vehiclePosition.setX(x);
        vehiclePosition.setY(y);
        return vehiclePosition;
    }

    public boolean isInDanger(String [] messages){

        return false;
    }
}
