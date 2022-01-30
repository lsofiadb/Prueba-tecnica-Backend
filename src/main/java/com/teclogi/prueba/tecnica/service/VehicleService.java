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
        float equation1 = (float) (Math.pow((x - x1),2) + Math.pow((y - y1),2));
        float equation2 = (float) (Math.pow((x - x2),2) + Math.pow((y - y2),2));
        float equation3 = (float) (Math.pow((x - x3),2) + Math.pow((y - y3),2));
        float equality1 = (float) Math.pow(r1,2) - equation1;
        float equality2 = (float) Math.pow(r2,2) - equation2;
        float equality3 = (float) Math.pow(r3,2) - equation3;
        if(Math.abs(equality1) <Math.pow(10,-12) & Math.abs(equality2) <Math.pow(10,-12) & Math.abs(equality3) <Math.pow(10,-12)){
            vehiclePosition.setX(roundNumber((float) x,1));
            vehiclePosition.setY(roundNumber((float) y,1));
            return vehiclePosition;
        }else{
            return null;
        }
    }

    public float roundNumber(float number, int digitsNumber){
        float result = number * (float) Math.pow(10, digitsNumber);
        result = Math.round(result);
        result = result/(float) Math.pow(10, digitsNumber);
        return result;
    }

    public boolean isInDanger(String [] messages ){
        boolean danger = false;
        int sequences = 0;
        char [][] matrix = new char[messages.length][messages.length];
        System.out.println("MATRIX");
        for(int i = 0; i<messages.length; i++){
            for(int j = 0; j< messages.length; j++){
                matrix [i][j] = messages [i].charAt(j);
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
        /*-----PATH 1: HORIZONTAL -------*/
        for(int i = 0; i<matrix.length;i++){
            for(int j = 0; j<3;j++){
                if(matrix[i][j] == matrix[i][j+1] && matrix[i][j+1] == matrix[i][j+2] & matrix[i][j+2] ==matrix[i][j+3]){
                    sequences++;
                }
            }
        }
        /*-----PATH 2: VERTICAL ------*/
        for(int i = 0; i<3;i++){
            for(int j = 0; j< matrix.length;j++){
                if(matrix[j][i] == matrix[j][i+1] && matrix[j][i+1] == matrix[j][i+2] & matrix[j][i+2] ==matrix[j][i+3]){
                    sequences++;
                }
            }
        }

        /*-----PATH 3: PRINCIPAL DIAGONAL ------*/
        for(int i = 0; i<matrix.length;i++){
            for(int j = 0; j< 3;j++){
                if(i == j){
                    if(matrix[i][j] == matrix [i+1][j+1] & matrix[i+1][j+1] == matrix[i+2][j+2] & matrix[i+2][j+2] == matrix[i+3][j+3]){
                        sequences++;
                    }
                }
            }
        }

        System.out.println("sequences");
        System.out.println(sequences);

        if(sequences > 1){
            return true;
        }else{
            return false;
        }
    }
}
